package com.toolshare.toolshare.Domain.Enum;

public enum TypeUsers {
    Customer("Customer"),
    Supplier("Supplier"),
    Admin("Admin");

    private String description;

    TypeUsers(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
