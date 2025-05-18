package com.toolshare.toolshare.Domain.Enum;

public enum StatusDamageReport {
    Pending("Pending"),
    Under("Under"),
    Resolved("Resolved");

    private String status;
    StatusDamageReport(String status) {
        this.status=status;
    }
    public String getStatus() {
        return status;
    }

}
