package com.toolshare.toolshare.Infraestructure.Controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.invoiceservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/invoiceDownloads")
public class InvoiceController {
    @Autowired
    private invoiceservice invoiceservice;
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downoadInvoice(@PathVariable Long id) {
        try {
            byte[] pdf= invoiceservice.pdf(id);
            org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("invoice_"+ id+".pdf")
                .build());

            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
