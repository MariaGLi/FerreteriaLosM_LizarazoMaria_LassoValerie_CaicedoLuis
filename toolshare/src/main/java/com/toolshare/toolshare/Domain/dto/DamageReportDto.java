package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusDamageReport;

public class DamageReportDto {
    
    private LocalDate reporDate;
    private LocalDate solutionDate;
    private String description;
    private StatusDamageReport status;
    private Long idClient;
    private Long idToolEC;
    private Long idReservation;

    public LocalDate getReporDate() {
        return reporDate;
    }
    public void setReporDate(LocalDate reporDate) {
        this.reporDate = reporDate;
    }
    public LocalDate getSolutionDate() {
        return solutionDate;
    }
    public void setSolutionDate(LocalDate solutionDate) {
        this.solutionDate = solutionDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public StatusDamageReport getStatus() {
        return status;
    }
    public void setStatus(StatusDamageReport status) {
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
    public Long getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    
}
