package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.ReturnsService;
import com.toolshare.toolshare.Domain.ReturnsDeliveries;
import com.toolshare.toolshare.Domain.dto.ReturnsDeliveriesDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/return", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReturnsController {

    @Autowired
    private ReturnsService returnsService;

    @PostMapping("/add")
    public ResponseEntity<ReturnsDeliveries> addNewReturn(@RequestBody ReturnsDeliveriesDto deliveriesDto) {
        ReturnsDeliveries rDeliveries= returnsService.acceptReturn(deliveriesDto);
        return new ResponseEntity<>(rDeliveries, HttpStatus.CREATED);
    }
    
    
}
