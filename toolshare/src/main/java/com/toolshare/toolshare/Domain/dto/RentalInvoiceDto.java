package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

public class RentalInvoiceDto {
    private LocalDate generationDate;
    private Long idPayments;

    public LocalDate getGenerationDate() {
        return generationDate;
    }
    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }
    public Long getIdPayments() {
        return idPayments;
    }
    public void setIdPayments(Long idPayments) {
        this.idPayments = idPayments;
    }

}
