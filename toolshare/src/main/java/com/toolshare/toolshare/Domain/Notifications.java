package com.toolshare.toolshare.Domain;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusNotifications;

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
public class Notifications {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDate date_message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusNotifications status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Users id_user;

    public Notifications() {
    }

    public Notifications(Long id, String message, StatusNotifications status, Users id_user) {
        this.id = id;
        this.message = message;
        this.status = status;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StatusNotifications getStatus() {
        return status;
    }

    public void setStatus(StatusNotifications status) {
        this.status = status;
    }

    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
    }

    
}
