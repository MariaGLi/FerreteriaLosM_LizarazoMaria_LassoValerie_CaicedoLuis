package com.toolshare.toolshare.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ToolsInvoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoices invoices;

    @ManyToOne
    @JoinColumn(name = "tools_id")
    private ToolsEquipmentConstruction toolsEquipmentConstruction;

    @Column(nullable = false)
    private Double unit_value;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double total_value;

    public ToolsInvoices() {
    }

    public ToolsInvoices(Long id, Invoices invoices, ToolsEquipmentConstruction toolsEquipmentConstruction,
            Double unit_value, Integer quantity, Double total_value) {
        this.id = id;
        this.invoices = invoices;
        this.toolsEquipmentConstruction = toolsEquipmentConstruction;
        this.unit_value = unit_value;
        this.quantity = quantity;
        this.total_value = total_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }

    public ToolsEquipmentConstruction getToolsEquipmentConstruction() {
        return toolsEquipmentConstruction;
    }

    public void setToolsEquipmentConstruction(ToolsEquipmentConstruction toolsEquipmentConstruction) {
        this.toolsEquipmentConstruction = toolsEquipmentConstruction;
    }

    public Double getUnit_value() {
        return unit_value;
    }

    public void setUnit_value(Double unit_value) {
        this.unit_value = unit_value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }

    
}
