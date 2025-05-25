package com.toolshare.toolshare.Domain.Enum;

public enum StatusReturnsD {
    Good("Good"),
    Damaged("Damaged"),
    MissingFaulty("Missing_Faulty");

    private String status;
    StatusReturnsD(String status) {
        this.status= status;
    }
    public String getStatus() {
        return status;
    }

}
