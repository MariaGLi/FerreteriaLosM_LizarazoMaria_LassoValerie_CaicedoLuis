package com.toolshare.toolshare.Application.Service;

import java.time.LocalDate;
import java.util.List;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

public interface SupplierInventoryManagmentService {
    public List<ToolsEquipmentConstruction> AddToolsEC(Enum typeS, String nameS, String categoryS, LocalDate dateRegisterS, Double priceDayS, String descriptionS, Enum statusS);
}
