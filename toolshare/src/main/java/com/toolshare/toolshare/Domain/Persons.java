package com.toolshare.toolshare.Domain;

import java.util.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.websocket.ClientEndpoint;

@Entity
public class Persons {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String last_name;

    @Column(length = 30)
    private String cellphone;

    private String email;

    @Column(nullable = false)
    private Date date_register;

    @OneToOne
    @JoinColumn(nullable = false)
    private Users id_user;

    public Persons() {
    }

    public Persons(Long id, String name, String last_name, String cellphone, String email, Date date_register,
            Users id_user) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.cellphone = cellphone;
        this.email = email;
        this.date_register = date_register;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_register() {
        return date_register;
    }

    public void setDate_register(Date date_register) {
        this.date_register = date_register;
    }

    public Users getId_user() {
        return id_user;
    }

    public void setId_user(Users id_user) {
        this.id_user = id_user;
    }

    
}
