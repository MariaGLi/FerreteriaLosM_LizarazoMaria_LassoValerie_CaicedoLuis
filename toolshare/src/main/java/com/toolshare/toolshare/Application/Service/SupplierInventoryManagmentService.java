package com.toolshare.toolshare.Application.Service;

import java.time.LocalDate;
import java.util.List;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.TypeToolsEC;
import com.toolshare.toolshare.Domain.dto.ToolsECRequest;

public interface SupplierInventoryManagmentService {
    ToolsEquipmentConstruction AddToolsEC(ToolsECRequest dto);
    ToolsEquipmentConstruction deleteTool(Long id);
    ToolsEquipmentConstruction updateTool(Long id, Double priceDayS);
}
