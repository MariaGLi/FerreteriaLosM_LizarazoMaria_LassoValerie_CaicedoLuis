package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.RentalInvoiceService;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.dto.RentalInvoiceDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/invoice", produces = MediaType.APPLICATION_JSON_VALUE)
public class RentalInvoiceController {

    private RentalInvoiceService rService;

    @PostMapping("/add")
    public ResponseEntity<Invoices> newInvoice(@RequestBody RentalInvoiceDto dto) {
        Invoices invoices= rService.newInvoice(dto);
        return new ResponseEntity<>(invoices, HttpStatus.CREATED);
    }
    
}
