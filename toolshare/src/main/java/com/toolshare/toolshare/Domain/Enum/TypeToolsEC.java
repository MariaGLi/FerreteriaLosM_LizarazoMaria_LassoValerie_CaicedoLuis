package com.toolshare.toolshare.Domain.Enum;

public enum TypeToolsEC {
    Tool("Tool"),
    EquipmentConstruction("EquipmentConstructions");

    private String type;

    TypeToolsEC(String type) {
        this.type= type;
    }

    public String getType() {
        return type;
    }

}
