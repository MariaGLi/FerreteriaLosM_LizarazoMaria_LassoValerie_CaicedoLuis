package com.toolshare.toolshare.Domain.Enum;

public enum StatusToolsEC {
    Available("Available"),
    Rented("Rented"),
    Damaged("Damaged"),
    Maintenance("Maintenance");

    private String status;

    StatusToolsEC(String status){
        this.status= status;
    }

    public String getStatus() {
        return status;
    }

}
