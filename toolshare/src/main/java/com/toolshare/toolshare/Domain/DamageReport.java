package com.toolshare.toolshare.Domain;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusDamageReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DamageReport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate report_date;

    @Column(nullable = false)
    private LocalDate solution_date;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDamageReport status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Users id_users_report;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ToolsEquipmentConstruction idToolsEC;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Reservations id_reservation;

    public DamageReport() {
    }

    public DamageReport(Long id, LocalDate report_date, String description, StatusDamageReport status,
            Users id_users_report, ToolsEquipmentConstruction idToolsEC, Reservations id_reservation) {
        this.id = id;
        this.report_date = report_date;
        this.description = description;
        this.status = status;
        this.id_users_report = id_users_report;
        this.idToolsEC = idToolsEC;
        this.id_reservation = id_reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReport_date() {
        return report_date;
    }

    public void setReport_date(LocalDate report_date) {
        this.report_date = report_date;
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

    public Users getId_users_report() {
        return id_users_report;
    }

    public void setId_users_report(Users id_users_report) {
        this.id_users_report = id_users_report;
    }

    public ToolsEquipmentConstruction getIdToolsEC() {
        return idToolsEC;
    }

    public void setIdToolsEC(ToolsEquipmentConstruction idToolsEC) {
        this.idToolsEC = idToolsEC;
    }

    public Reservations getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Reservations id_reservation) {
        this.id_reservation = id_reservation;
    }
    
    
}
