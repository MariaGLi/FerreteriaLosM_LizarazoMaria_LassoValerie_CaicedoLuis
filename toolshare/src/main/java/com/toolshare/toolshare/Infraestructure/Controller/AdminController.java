package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.AdminReservationService;
import com.toolshare.toolshare.Application.Service.AdminToolsService;
import com.toolshare.toolshare.Application.Service.DamageReportService;
import com.toolshare.toolshare.Application.Service.PersonService;
import com.toolshare.toolshare.Domain.request.DamageReportUpdateRequest;
import com.toolshare.toolshare.Domain.response.DamageReportResponse;
import com.toolshare.toolshare.Domain.response.DamageReportUpdateResponse;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;
import com.toolshare.toolshare.Domain.response.StatusToolsResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PersonService personService;
    private final AdminToolsService adminToolsService;
    private final AdminReservationService adminReservationService;
    private final DamageReportService damageReportService;

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

    @GetMapping("/damageReport")
    public ResponseEntity<List<DamageReportResponse>> getDamageReport() {
        return ResponseEntity.ok(damageReportService.findAllReports());
    }
    
    @PatchMapping("/damageReport/{id}")
    public ResponseEntity<DamageReportUpdateResponse> updateDamageReport(@PathVariable Long id, @RequestBody DamageReportUpdateRequest response) {
        response.setId(id);
        return ResponseEntity.ok(damageReportService.updateDamageReport(response));
    }
    
}
