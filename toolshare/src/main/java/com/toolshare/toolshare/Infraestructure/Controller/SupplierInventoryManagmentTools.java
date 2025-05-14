package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.SupplierInventoryManagmentService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

@RestController
@RequestMapping(value = "/InventoryManagment", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierInventoryManagmentTools {

    @Autowired
    private SupplierInventoryManagmentService  SIMservice;

    
}   
