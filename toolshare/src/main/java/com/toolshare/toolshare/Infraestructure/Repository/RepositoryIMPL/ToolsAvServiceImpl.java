package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.ToolsAvService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;

@Service
public class ToolsAvServiceImpl implements ToolsAvService{

    private final ToolsECRepository toolsECRepository;

    public ToolsAvServiceImpl(ToolsECRepository toolsECRepository) {
        this.toolsECRepository = toolsECRepository;
    }

    @Override
    public List<ToolsEquipmentConstruction> getAvailableTools() {
        List<ToolsEquipmentConstruction> toolsAvailable = toolsECRepository.findByStatus(StatusToolsEC.Available);
        
        return toolsAvailable;
    }

    @Override
    public List<ToolsEquipmentConstruction> getPriceTools() {
        return toolsECRepository.findAllByOrderByPriceDayAsc();
    }
}
