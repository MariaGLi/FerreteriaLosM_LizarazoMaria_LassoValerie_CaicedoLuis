package com.toolshare.toolshare.Domain.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Long id;
    private String name_store;
    private String nit;
    private String address;
    private Long number_invoice;
    private String cellphone;
    private LocalDate registration_date;
    private LocalDate invoice_generation_date;
    private LocalDate expiration_date;
    private String url_signature;
    private double and_total;
    private PersonResponse person;
    private PaymentResponse payment;
    private List<ToolsInvoiceResponse> tools;
}
