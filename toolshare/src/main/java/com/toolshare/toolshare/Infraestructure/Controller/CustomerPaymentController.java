package com.toolshare.toolshare.Infraestructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.CustomerPaymentService;
import com.toolshare.toolshare.Domain.Payments;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/pay", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerPaymentController {
    @Autowired
    private CustomerPaymentService paymentService;

    @PutMapping("/payBy/{id}")
    public ResponseEntity<Payments> payService(@PathVariable (name= "id") Long id, @RequestBody Payments update) {
        try {
            Payments payment= paymentService.payInvoice(id, update.getPayment_method());
            return ResponseEntity.ok(payment);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/payPending")
    public List<Payments> getAllPaymentsByStatus() {
        return paymentService.getAllPayPending();
    }
    
}
