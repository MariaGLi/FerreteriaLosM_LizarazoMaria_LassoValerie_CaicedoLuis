package com.toolshare.toolshare.Domain.dto;

import com.toolshare.toolshare.Domain.Enum.StatusPayments;

public class PaymentsDto {
    Long idReservation;
    String paymentMethod;
    StatusPayments status;
    
    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public StatusPayments getStatus() {
        return status;
    }
    public void setStatus(StatusPayments status) {
        this.status = status;
    }

    
}
