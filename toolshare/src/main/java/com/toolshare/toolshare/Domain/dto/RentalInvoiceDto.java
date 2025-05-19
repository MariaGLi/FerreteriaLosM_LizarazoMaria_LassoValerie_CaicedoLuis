package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

public class RentalInvoiceDto {
    private LocalDate generationDate;
    private LocalDate expirationDate;
    private Double andTotal;
    private Long idClient;
    private Long idPayments;

    public LocalDate getGenerationDate() {
        return generationDate;
    }
    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Double getAndTotal() {
        return andTotal;
    }
    public void setAndTotal(Double andTotal) {
        this.andTotal = andTotal;
    }
    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public Long getIdPayments() {
        return idPayments;
    }
    public void setIdPayments(Long idPayments) {
        this.idPayments = idPayments;
    }

}
