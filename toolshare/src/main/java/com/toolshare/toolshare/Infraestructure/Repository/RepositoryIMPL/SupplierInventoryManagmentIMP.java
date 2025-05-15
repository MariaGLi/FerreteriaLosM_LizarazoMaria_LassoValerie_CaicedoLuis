package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.SupplierInventoryManagmentService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Users;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.Enum.TypeToolsEC;
import com.toolshare.toolshare.Domain.dto.ToolsECRequest;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;
import com.toolshare.toolshare.Infraestructure.Repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierInventoryManagmentIMP implements SupplierInventoryManagmentService{

    @Autowired
    private ToolsECRepository repository;
    @Autowired
    private UsersRepository userRepository;

    @Override
    public ToolsEquipmentConstruction AddToolsEC(ToolsECRequest dto) {
        
        // check if the id is null
        if (dto.getSupplierId()== null){
            throw new IllegalArgumentException("The id is mandatory");
        }

        Users supplier= userRepository.findById(dto.getSupplierId()).orElseThrow(() -> new RuntimeException("Suppier with " + dto.getSupplierId() + " not found"));
        ToolsEquipmentConstruction tool= new ToolsEquipmentConstruction();

        tool.setName(dto.getName());
        tool.setCategory(dto.getCategory());
        tool.setDate_register(dto.getDateRegister());
        tool.setPrice_day(dto.getPriceDay());
        tool.setDescription(dto.getDescription());
        tool.setType(dto.getType());
        tool.setStatus(dto.getStatus());
        tool.setId_user_supplier(supplier);

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
    public ToolsEquipmentConstruction updateTool(Long id, Double priceDay) {
        
        Optional<ToolsEquipmentConstruction> findTool= repository.findById(id);
        
        if(findTool== null){
            throw new RuntimeException("Enter the id");
        } 
        ToolsEquipmentConstruction toolExist= findTool.get();
        toolExist.setPrice_day(priceDay);

        return repository.save(toolExist);
    }


}
