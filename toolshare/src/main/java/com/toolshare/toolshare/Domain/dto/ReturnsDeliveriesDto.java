package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusReturnsD;

public class ReturnsDeliveriesDto {
    private Long reservationId;
    private String commentary;
    private StatusReturnsD status;
    private LocalDate returnDate;
    
    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getCommentary() {
        return commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    public StatusReturnsD getStatus() {
        return status;
    }
    public void setStatus(StatusReturnsD status) {
        this.status = status;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    
}
