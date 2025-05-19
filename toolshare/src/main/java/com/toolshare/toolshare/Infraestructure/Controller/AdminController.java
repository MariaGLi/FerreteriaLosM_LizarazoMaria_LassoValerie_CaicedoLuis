package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.AdminReservationService;
import com.toolshare.toolshare.Application.Service.AdminToolsService;
import com.toolshare.toolshare.Application.Service.PersonService;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;
import com.toolshare.toolshare.Domain.response.StatusToolsResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PersonService personService;
    private final AdminToolsService adminToolsService;
    private final AdminReservationService adminReservationService;

    @PostMapping("/users")
    public ResponseEntity<List<PersonResponse>> getUsers(@RequestParam(required = false)String role) {
        if (role!=null) {
            
            if (role.equals("customer") || role.equals("supplier")) {
                return ResponseEntity.ok(personService.findPersonByRole(role));
            }
            
        }
        return ResponseEntity.ok(personService.findPersonCustomerSupplier());
    }

    @GetMapping("/stateTools")
    public ResponseEntity<List<StatusToolsResponse>> getStateTools() {
        return ResponseEntity.ok(adminToolsService.findStatusTools());
    }

    @GetMapping("/rentalHistory")
    public ResponseEntity<List<RentalHistoryResponse>> getRentalHistoryResponse() {
        return ResponseEntity.ok(adminReservationService.getRentalHistory());
    }
    

}
