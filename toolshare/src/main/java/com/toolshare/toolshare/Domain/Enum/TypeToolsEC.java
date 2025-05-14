package com.toolshare.toolshare.Domain.Enum;

public enum TypeToolsEC {
    Tools("Tool"),
    EquipmentConstructions("EquipmentConstructions");

    private String type;

    TypeToolsEC(String type) {
        this.type= type;
    }

    public String getType() {
        return type;
    }
}
