package com.toolshare.toolshare.Infraestructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.CustomerInvoiceService;
import com.toolshare.toolshare.Domain.Invoices;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/invoices", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerInvoiceController {

    @Autowired
    private CustomerInvoiceService customerInvoiceService;

    @GetMapping("/all")
    public List<Invoices> getAll() {
        return customerInvoiceService.getAllInvoice();
    }
    
}
