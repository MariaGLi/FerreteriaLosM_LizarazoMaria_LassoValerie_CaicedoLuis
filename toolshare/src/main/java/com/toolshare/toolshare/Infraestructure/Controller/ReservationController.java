package com.toolshare.toolshare.Infraestructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.ReservationService;
import com.toolshare.toolshare.Domain.Reservations;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/reservationManagement", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    @Autowired
    private ReservationService rManagementService;

    @PutMapping("/accept/{id}")
    public Reservations accep(@PathVariable Long id) {
        return rManagementService.acceptReservations(id);
    }

    @PutMapping("/reject/{id}")
    public Reservations reject(@PathVariable Long id) {
        return rManagementService.rejectReservations(id);
    }

    @GetMapping("/completed")
    public List<Reservations> getAllStatusCompleted() {
        return rManagementService.getAllStatusCompleted();
    }
    
    @GetMapping("/pending")
    public List<Reservations> getAllStatusPending() {
        return rManagementService.getAllStatusPending();
    }
    
}
