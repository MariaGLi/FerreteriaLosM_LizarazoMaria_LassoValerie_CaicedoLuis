package com.toolshare.toolshare.Domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toolshare.toolshare.Domain.Enum.StatusReturnsD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ReturnsDeliveries {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private LocalDate delivery_date;

    private LocalDate return_date;

    @Column(columnDefinition = "TEXT")
    private String commentary;

    @Enumerated(EnumType.STRING)
    private StatusReturnsD status;

    @OneToOne
    @JsonIgnore
    private Reservations id_reservations;

    public ReturnsDeliveries() {
    }

    public ReturnsDeliveries(Long id, LocalDate delivery_date, LocalDate return_date, String commentary,
            StatusReturnsD status, Reservations id_reservations) {
        this.id = id;
        this.delivery_date = delivery_date;
        this.return_date = return_date;
        this.commentary = commentary;
        this.status = status;
        this.id_reservations = id_reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
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

    public Reservations getId_reservations() {
        return id_reservations;
    }

    public void setId_reservations(Reservations id_reservations) {
        this.id_reservations = id_reservations;
    }

    
}
