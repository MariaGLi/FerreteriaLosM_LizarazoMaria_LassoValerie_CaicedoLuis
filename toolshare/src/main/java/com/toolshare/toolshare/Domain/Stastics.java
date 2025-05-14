package com.toolshare.toolshare.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stastics {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity_timesDamaged;

    @Column(nullable = false)
    private Integer total_income;

    @Column(nullable = false)
    private Integer total_rentals;

    @OneToOne
    private ToolsEquipmentConstruction idToolsEquipmentConstruction;

    public Stastics() {
    }

    public Stastics(Long id, Integer quantity_timesDamaged, Integer total_income, Integer total_rentals,
            ToolsEquipmentConstruction idToolsEquipmentConstruction) {
        this.id = id;
        this.quantity_timesDamaged = quantity_timesDamaged;
        this.total_income = total_income;
        this.total_rentals = total_rentals;
        this.idToolsEquipmentConstruction = idToolsEquipmentConstruction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity_timesDamaged() {
        return quantity_timesDamaged;
    }

    public void setQuantity_timesDamaged(Integer quantity_timesDamaged) {
        this.quantity_timesDamaged = quantity_timesDamaged;
    }

    public Integer getTotal_income() {
        return total_income;
    }

    public void setTotal_income(Integer total_income) {
        this.total_income = total_income;
    }

    public Integer getTotal_rentals() {
        return total_rentals;
    }

    public void setTotal_rentals(Integer total_rentals) {
        this.total_rentals = total_rentals;
    }

    public ToolsEquipmentConstruction getIdToolsEquipmentConstruction() {
        return idToolsEquipmentConstruction;
    }

    public void setIdToolsEquipmentConstruction(ToolsEquipmentConstruction idToolsEquipmentConstruction) {
        this.idToolsEquipmentConstruction = idToolsEquipmentConstruction;
    }

    
}
