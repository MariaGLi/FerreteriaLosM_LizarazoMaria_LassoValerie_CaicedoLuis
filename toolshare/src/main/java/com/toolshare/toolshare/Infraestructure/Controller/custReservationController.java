package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.custReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.dto.ReservationDto;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class custReservationController {

    @Autowired
    private custReservationService reservService;
    
    @PostMapping("/addReservation")
    public ResponseEntity<Reservations> newReservations(@RequestBody ReservationDto reservDto){
        Reservations reservations = reservService.newReservations(reservDto);
        return new ResponseEntity<Reservations>(reservations, HttpStatus.CREATED);
    }
}
