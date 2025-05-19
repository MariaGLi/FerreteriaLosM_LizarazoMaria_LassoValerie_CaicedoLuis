package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.RentalInvoiceService;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Users;
import com.toolshare.toolshare.Domain.dto.RentalInvoiceDto;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;
import com.toolshare.toolshare.Infraestructure.Repository.PaymentsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.UsersRepository;

@Service
public class RentalInvoiceImpl implements RentalInvoiceService{
    @Autowired
    private InvoicesRepository invoicesRepository;

    @Autowired 
    private UsersRepository usersRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Invoices newInvoice(RentalInvoiceDto dto) {
        Payments paymentId= paymentsRepository.findById(dto.getIdPayments()).orElseThrow(()-> new RuntimeException("Payment not found"));
        Users userId= usersRepository.findById(dto.getIdClient()).orElseThrow(()-> new RuntimeException("Client not found"));
        Long NumbreInvoice= invoicesRepository.findLastInvoiceNumber() + 1;

        Invoices invoice= new Invoices();

        invoice.setAddress("Calle 123 #45-67, Bogotá");
        invoice.setCellphone("302456780");
        invoice.setExpiration_date(LocalDate.now().plusDays(20));
        invoice.setId_client(userId);
        invoice.setId_payments(paymentId);
        invoice.setInvoice_generation_date(dto.getGenerationDate());
        invoice.setName_tool_share("ToolShare SAS");
        invoice.setAnd_total(0);
        invoice.setNit("900123-7");
        invoice.setUrl_signature("https://firma.toolshare.com/1001");
        invoice.setRegistration_date(LocalDate.now());
        invoice.setNumber_invoice(NumbreInvoice);

        return invoicesRepository.save(invoice);
    }

}
