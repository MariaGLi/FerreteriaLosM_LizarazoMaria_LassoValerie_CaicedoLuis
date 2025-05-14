package com.toolshare.toolshare.Domain.Enum;

public enum StatusPayments {
    Pending("Pending"),
    Paid("Paid"),
    Failed("Failed");

    private String status;

    StatusPayments(String status) {
        this.status= status;
    }

    public String getStatus() {
        return status;
    } 

}
