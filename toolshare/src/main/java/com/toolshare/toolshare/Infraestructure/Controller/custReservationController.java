package com.toolshare.toolshare.Infraestructure.Controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.custReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;

@RestController
@RequestMapping("/api/customer/reservations")
public class custReservationController {

    private final custReservationService reservService;

    public custReservationController(custReservationService reservService) {
        this.reservService = reservService;
    }

    @PostMapping("/addReservation")
    public Reservations createReservation(LocalDate start_date, LocalDate end_date, LocalDate Request_date,
            StatusReservations status) {
        return reservService.createReservation(start_date, end_date, Request_date, status);
    }
}
