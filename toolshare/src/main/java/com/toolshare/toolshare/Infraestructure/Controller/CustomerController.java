package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.ToolsAvService;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final ToolsAvService toolsAvService;
    
    public CustomerController(ToolsAvService toolsAvService) {
        this.toolsAvService = toolsAvService;
    }

    @GetMapping("/toolsAvailable")
    public List<ToolsEquipmentConstruction> getAvailableTools () {
        return toolsAvService.getAvailableTools();
    }
}