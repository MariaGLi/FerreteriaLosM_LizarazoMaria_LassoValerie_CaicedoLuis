package com.toolshare.toolshare.Domain.Enum;

public enum StatusNotifications {
    Payments("Payment"),
    Reservations("Reservation"),
    Returns("Return"),
    Alerts("Alert");

    private String status;

    StatusNotifications(String status) {
        this.status= status;
    }

    public String getStatus() {
        return status;
    }

}
