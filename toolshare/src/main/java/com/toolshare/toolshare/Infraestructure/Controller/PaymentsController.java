package com.toolshare.toolshare.Infraestructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.PaymentsService;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.dto.PaymentsDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/add")
    public ResponseEntity<Payments> neePayment(@RequestBody PaymentsDto dto) {
        Payments payment= paymentsService.newPayment(dto);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }
    
    @GetMapping("/paid")
    public List<Payments> statusPaid() {
        return paymentsService.getAllStatusPaid();
    }
    
}
