package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusReservations;

public class ReservationDto {

    private LocalDate startDate;
    private LocalDate endDate; 
    private LocalDate requestDate;
    private StatusReservations status;
    private Long idClient;
    private Long idToolEC;

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalDate getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
    public StatusReservations getStatus() {
        return status;
    }
    public void setStatus(StatusReservations status) {
        this.status = status;
    }
    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public Long getIdToolEC() {
        return idToolEC;
    }
    public void setIdToolEC(Long idToolEC) {
        this.idToolEC = idToolEC;
    }
}
