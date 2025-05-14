package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.SupplierInventoryManagmentService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

@Service
public class SupplierInventoryManagmentIMP implements SupplierInventoryManagmentService{

    @Override
    public List<ToolsEquipmentConstruction> AddToolsEC(Enum typeS, String nameS, String categoryS,
            LocalDate dateRegisterS, Double priceDayS, String descriptionS, Enum statusS) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddToolsEC'");
    }

}
