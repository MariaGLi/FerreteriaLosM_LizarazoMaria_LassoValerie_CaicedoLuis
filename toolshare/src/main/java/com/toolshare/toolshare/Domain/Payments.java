package com.toolshare.toolshare.Domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toolshare.toolshare.Domain.Enum.StatusPayments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String payment_method;

    @Column(nullable = false)
    private Double price_total;

    @Column(nullable = false)
    private LocalDate payment_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPayments status;

    @OneToOne
    @JsonIgnore
    @JoinColumn(nullable = false)
    private Reservations id_reservations;

    public Payments() {
    }

    public Payments(Long id, String payment_method, Double price_total, LocalDate payment_date, StatusPayments status,
            Reservations id_reservations) {
        this.id = id;
        this.payment_method = payment_method;
        this.price_total = price_total;
        this.payment_date = payment_date;
        this.status = status;
        this.id_reservations = id_reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Double getPrice_total() {
        return price_total;
    }

    public void setPrice_total(Double price_total) {
        this.price_total = price_total;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public StatusPayments getStatus() {
        return status;
    }

    public void setStatus(StatusPayments status) {
        this.status = status;
    }

    public Reservations getId_reservations() {
        return id_reservations;
    }

    public void setId_reservations(Reservations id_reservations) {
        this.id_reservations = id_reservations;
    }

    
}
