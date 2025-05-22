package com.toolshare.toolshare.Domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.Enum.TypeToolsEC;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ToolsEquipmentConstruction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeToolsEC type;

    @Column(length = 30, nullable = false)
    private String name;
    
    @Column(length = 30, nullable = false)
    private String category;
    
    @Column(nullable = false)
    private LocalDate date_register;
    
    @Column(name = "price_day", nullable = false)
    private Double priceDay;
    
    @Column(nullable = false)
    private String image;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusToolsEC status;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Persons id_user_supplier;

    @ManyToMany(mappedBy = "toolsECList")
    @JsonManagedReference
    @JsonIgnore
    private List<Reservations> reservations_list;

    @OneToMany(mappedBy = "toolsEquipmentConstruction")
    @JsonIgnore
    private List<ToolsInvoices> tools_invoices_list;

    public ToolsEquipmentConstruction() {
    }

    public ToolsEquipmentConstruction(Long id, TypeToolsEC type, String name, String category, LocalDate date_register,
            Double priceday, String description, StatusToolsEC status, Persons id_user_supplier,
            List<Reservations> reservations_list, List<ToolsInvoices> tools_invoices_list) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.category = category;
        this.date_register = date_register;
        this.priceDay = priceday;
        this.description = description;
        this.status = status;
        this.id_user_supplier = id_user_supplier;
        this.reservations_list = reservations_list;
        this.tools_invoices_list = tools_invoices_list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeToolsEC getType() {
        return type;
    }

    public void setType(TypeToolsEC type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate_register() {
        return date_register;
    }

    public void setDate_register(LocalDate date_register) {
        this.date_register = date_register;
    }

    public Double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(Double priceDay) {
        this.priceDay = priceDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusToolsEC getStatus() {
        return status;
    }

    public void setStatus(StatusToolsEC status) {
        this.status = status;
    }

    public Persons getId_user_supplier() {
        return id_user_supplier;
    }

    public void setId_user_supplier(Persons id_user_supplier) {
        this.id_user_supplier = id_user_supplier;
    }

    public List<Reservations> getReservations_list() {
        return reservations_list;
    }

    public void setReservations_list(List<Reservations> reservations_list) {
        this.reservations_list = reservations_list;
    }

    public List<ToolsInvoices> getTools_invoices_list() {
        return tools_invoices_list;
    }

    public void setTools_invoices_list(List<ToolsInvoices> tools_invoices_list) {
        this.tools_invoices_list = tools_invoices_list;
    }
}
