package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.RentalInvoiceService;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.ToolsInvoices;
import com.toolshare.toolshare.Domain.Enum.StatusPayments;
import com.toolshare.toolshare.Domain.dto.RentalInvoiceDto;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;
import com.toolshare.toolshare.Infraestructure.Repository.PaymentsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsInvoiceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalInvoiceImpl implements RentalInvoiceService{
    @Autowired
    private InvoicesRepository invoicesRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private ToolsInvoiceRepository tInvoiceRepository;

    @Override
    public Invoices newInvoice(RentalInvoiceDto dto) {
        Payments payment= paymentsRepository.findById(dto.getIdPayments()).orElseThrow(()-> new RuntimeException("Payment not found"));
        //validation
        if(payment.getStatus() !=StatusPayments.Paid){
            throw new RuntimeException("Cannot generate invoice: payment has not been completed");
        }

        Reservations reservation = payment.getId_reservations();

        if(reservation== null || reservation.getToolsECList()== null || reservation.getToolsECList().isEmpty()){
            throw new RuntimeException("No tools found for this reservation");
        }

        Long NumbreInvoice= invoicesRepository.findLastInvoiceNumber() + 1;

        Invoices invoice= new Invoices();
        invoice.setAddress("Calle 123 #45-67, Bogotá");
        invoice.setCellphone("302456780");
        invoice.setExpiration_date(LocalDate.now().plusDays(20));
        invoice.setId_payments(payment);
        invoice.setInvoice_generation_date(dto.getGenerationDate());
        invoice.setName_tool_share("ToolShare SAS");
        invoice.setNit("900123-7");
        invoice.setUrl_signature("https://firma.toolshare.com/1001");
        invoice.setRegistration_date(LocalDate.now());
        invoice.setNumber_invoice(NumbreInvoice);
        invoice.setAnd_total(payment.getPrice_total());
        invoice.setId_client(reservation.getId_user_client());

        Invoices savedInvoices=  invoicesRepository.save(invoice);

        List<ToolsInvoices> toolsList= new ArrayList<>();
        double total= 0;
        for(ToolsEquipmentConstruction tool: reservation.getToolsECList()){
            ToolsInvoices toolsInvoices= new ToolsInvoices();
            toolsInvoices.setInvoices(savedInvoices);
            toolsInvoices.setToolsEquipmentConstruction(tool);

            Long days= ChronoUnit.DAYS.between(reservation.getStart_date(), reservation.getEnd_date());
            int quantity= (int)(days >0 ? days: 1);

            double unitV= tool.getPriceDay();
            double totalValue = unitV * quantity;

            toolsInvoices.setUnit_value(unitV);
            toolsInvoices.setTotal_value(totalValue);
            toolsInvoices.setQuantity(quantity);

            total += totalValue;
            toolsList.add(toolsInvoices);
        }
        tInvoiceRepository.saveAll(toolsList);
        savedInvoices.setAnd_total(total);
        return invoicesRepository.save(invoice);

    }

}
