package com.toolshare.toolshare.Domain.Enum;

public enum StatusReturnsD {
    Good("Good"),
    Damaged("Damaged"),
    Missing_Faulty("Missing_Faulty");

    private String status;
    StatusReturnsD(String status) {
        this.status= status;
    }
    public String getStatus() {
        return status;
    }

}
