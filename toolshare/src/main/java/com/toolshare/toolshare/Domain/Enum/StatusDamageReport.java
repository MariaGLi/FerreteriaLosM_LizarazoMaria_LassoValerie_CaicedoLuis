package com.toolshare.toolshare.Domain.Enum;

public enum StatusDamageReport {
    Pending("Pending"),
    Under("Under"),
    Solved("Solved");

    private String status;
    StatusDamageReport(String status) {
        this.status=status;
    }
    public String getStatus() {
        return status;
    }

}
