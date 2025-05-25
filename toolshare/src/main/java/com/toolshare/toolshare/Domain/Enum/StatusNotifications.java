package com.toolshare.toolshare.Domain.Enum;

public enum StatusNotifications {
    Payment("Payment"),
    Reservation("Reservation"),
    Return("Return"),
    Alert("Alert");

    private String status;

    StatusNotifications(String status) {
        this.status= status;
    }

    public String getStatus() {
        return status;
    }

}
