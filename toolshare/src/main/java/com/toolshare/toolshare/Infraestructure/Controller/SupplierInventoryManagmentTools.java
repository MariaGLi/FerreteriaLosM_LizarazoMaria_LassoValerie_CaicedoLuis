package com.toolshare.toolshare.Infraestructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.SupplierInventoryManagmentService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.dto.ToolsECRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping(value = "/InventoryManagment", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierInventoryManagmentTools {

    @Autowired
    private SupplierInventoryManagmentService  SIMservice;
    
    // link
    @PostMapping("/toolsAdd")
    public ResponseEntity<ToolsEquipmentConstruction> addTool(@RequestBody ToolsECRequest dto){
        ToolsEquipmentConstruction tool= SIMservice.AddToolsEC(dto);
        return new ResponseEntity<>(tool, HttpStatus.CREATED);
    }
    
    // link
    @DeleteMapping("/toolDelete/{id}")
    public ResponseEntity<ToolsEquipmentConstruction> deleteTool(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(SIMservice.deleteTool(id));
        
    }

    @PutMapping("toolUpdate/{id}")
    public ResponseEntity<ToolsEquipmentConstruction> editTool(@PathVariable (name = "id") Long id, @RequestBody ToolsEquipmentConstruction editTool) {
        
        try{
            ToolsEquipmentConstruction tool= SIMservice.updateTool(id,editTool.getPrice_day(), editTool.getStatus());
            return ResponseEntity.ok(tool);
            
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}   
