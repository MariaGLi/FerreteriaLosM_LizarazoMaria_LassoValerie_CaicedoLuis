package com.toolshare.toolshare.Domain.Enum;

public enum StatusReservations {
    Pending("Pending"),
    Approved("Approved"),
    Rejected("Rejected"),
    Canceled("Canceled"),
    Completed("Completed");

    private String status;

    StatusReservations(String status) {
        this.status= status;
    }

    public String getStatus() {
        return status;
    }

}
