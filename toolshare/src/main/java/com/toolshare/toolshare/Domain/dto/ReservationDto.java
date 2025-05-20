package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;
import java.util.List;
public class ReservationDto {

    private LocalDate startDate;
    private LocalDate endDate; 
    private LocalDate requestDate;
    private Long idClient;
    private List<Long> idToolEC;

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
    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public List<Long> getIdToolEC() {
        return idToolEC;
    }
    public void setIdToolEC(List<Long> idToolEC) {
        this.idToolEC = idToolEC;
    }
}
