package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.InventoryToolsService;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.dto.ToolsECRequest;
import com.toolshare.toolshare.Infraestructure.Repository.PersonRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InventoryToolsImpl implements InventoryToolsService{

    @Autowired
    private ToolsECRepository repository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ToolsECRepository tEquipmentConstruction;

    @Override
    public ToolsEquipmentConstruction AddToolsEC(ToolsECRequest dto) {
        
        // check if the id is null
        if (dto.getSupplierId()== null){
            throw new IllegalArgumentException("The id is mandatory");
        }

        Persons supplier= personRepository.findById(dto.getSupplierId()).orElseThrow(() -> new RuntimeException("Suppier with " + dto.getSupplierId() + " not found"));
        ToolsEquipmentConstruction tool= new ToolsEquipmentConstruction();

        tool.setName(dto.getName());
        tool.setCategory(dto.getCategory());
        tool.setDate_register(dto.getDateRegister());
        tool.setPriceDay(dto.getPriceDay());
        tool.setDescription(dto.getDescription());
        tool.setType(dto.getType());
        tool.setStatus(StatusToolsEC.Available);
        tool.setId_user_supplier(supplier);
        tool.setImage(dto.getImage());

        return repository.save(tool);
    }

    @Override
    public ToolsEquipmentConstruction deleteTool(Long id) {

        Optional<ToolsEquipmentConstruction> tool= repository.findById(id);
        
        if(!tool.isPresent()){
            throw new EntityNotFoundException("La herramienta no se encuentra registrada");
        }

        repository.deleteById(id);
        return tool.get();
    }

    @Override
    public ToolsEquipmentConstruction updateTool(Long id, Double priceDay, StatusToolsEC statusS) {
        
        Optional<ToolsEquipmentConstruction> findTool= repository.findById(id);
        ToolsEquipmentConstruction toolExist= findTool.get();
        toolExist.setPriceDay(priceDay);
        toolExist.setStatus(statusS);

        return repository.save(toolExist);
    }

    @Override
    public List<ToolsEquipmentConstruction> getAll() {
        return tEquipmentConstruction.findAll();
    }


}
