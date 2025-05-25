package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;


public interface ToolsAvService {
    List<ToolsEquipmentConstruction> getAvailableTools();
    List<ToolsEquipmentConstruction> getPriceTools();
}
