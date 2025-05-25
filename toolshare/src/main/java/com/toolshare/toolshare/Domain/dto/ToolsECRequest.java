package com.toolshare.toolshare.Domain.dto;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.Enum.TypeToolsEC;

public class ToolsECRequest{
    private Long supplierId;
    private TypeToolsEC type;
    private String name;
    private String category;
    private LocalDate dateRegister;
    private Double priceDay;
    private String description;
    private String image;

    
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
    public LocalDate getDateRegister() {
        return dateRegister;
    }
    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
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
    public Long getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}


