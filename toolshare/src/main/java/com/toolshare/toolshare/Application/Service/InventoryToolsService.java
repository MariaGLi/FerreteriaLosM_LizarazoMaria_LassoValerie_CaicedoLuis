package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.dto.ToolsECRequest;

public interface InventoryToolsService {
    ToolsEquipmentConstruction AddToolsEC(ToolsECRequest dto);
    ToolsEquipmentConstruction deleteTool(Long id);
    ToolsEquipmentConstruction updateTool(Long id, Double priceDayS, StatusToolsEC statusS);
}
