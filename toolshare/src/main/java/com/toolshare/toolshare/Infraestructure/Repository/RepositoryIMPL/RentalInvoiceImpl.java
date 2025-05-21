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
import com.toolshare.toolshare.Domain.response.InvoiceResponse;
import com.toolshare.toolshare.Domain.response.PaymentResponse;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.ReservationResponse;
import com.toolshare.toolshare.Domain.response.ToolsInvoiceResponse;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalInvoiceImpl implements RentalInvoiceService{
    @Autowired
    private InvoicesRepository invoicesRepository;

    @Override
    public Invoices newInvoice(RentalInvoiceDto dto) {
        return null;
    }

    @Override
    public List<InvoiceResponse> findAllInvoice() {
        List<Invoices> invoices = invoicesRepository.findAll();
        List<InvoiceResponse> response = new ArrayList<>();

        
        
        for (Invoices i : invoices) {
            List<ToolsInvoiceResponse> tools = new ArrayList<>();
            for (ToolsInvoices t : i.getTool_invoice_list()) {
                tools.add(ToolsInvoiceResponse.builder()
                    .id(t.getId())
                    .toolsEquipmentConstruction(t.getToolsEquipmentConstruction())
                    .unit_value(t.getUnit_value())
                    .quantity(t.getQuantity())
                    .total_value(t.getTotal_value())
                    .build()
                );
            }

            response.add(InvoiceResponse.builder()
            .id(i.getId())
            .name_store(i.getName_tool_share())
            .nit(i.getNit())
            .address(i.getAddress())
            .number_invoice(i.getNumber_invoice())
            .cellphone(i.getCellphone())
            .registration_date(i.getRegistration_date())
            .invoice_generation_date(i.getInvoice_generation_date())
            .expiration_date(i.getExpiration_date())
            .url_signature(i.getUrl_signature())
            .and_total(i.getAnd_total())
            .person(PersonResponse.builder()
                .id(i.getId_client().getId())
                .name(i.getId_client().getName())
                .lastName(i.getId_client().getLast_name())
                .email(i.getId_client().getEmail())
                .dateRegister(i.getId_client().getDate_register())
                .cellphone(i.getId_client().getCellphone())
                .userId(i.getId_client().getId_user().getId())
                .build()
            )
            .payment(PaymentResponse.builder()
                .id(i.getId_payments().getId())
                .payment_method(i.getId_payments().getPayment_method())
                .price_total(i.getId_payments().getPrice_total())
                .payment_date(i.getId_payments().getPayment_date())
                .status(i.getId_payments().getStatus())
                .reservation(ReservationResponse.builder()
                    .id(i.getId_payments().getId_reservations().getId())
                    .start_date(i.getId_payments().getId_reservations().getStart_date())
                    .end_date(i.getId_payments().getId_reservations().getEnd_date())
                    .request_date(i.getId_payments().getId_reservations().getRequest_date())
                    .status(i.getId_payments().getId_reservations().getStatus().toString())
                    .build()
                )
                .build()
            )
            .tools(tools)
            .build()
            );
        }

        return response;
    }

}
