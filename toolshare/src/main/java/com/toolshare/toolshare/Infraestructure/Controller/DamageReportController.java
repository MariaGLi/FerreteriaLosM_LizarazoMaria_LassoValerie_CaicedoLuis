package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.DamageReportService;
import com.toolshare.toolshare.Domain.DamageReport;
import com.toolshare.toolshare.Domain.dto.DamageReportDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/damagedReport", produces = MediaType.APPLICATION_JSON_VALUE)
public class DamageReportController {

    @Autowired
    private DamageReportService sReportService;
    
    @PostMapping("/report")
    public ResponseEntity<DamageReport> newReport(@RequestBody DamageReportDto dReportDto){
        DamageReport damageReport= sReportService.newReport(dReportDto);
        return new ResponseEntity<DamageReport>(damageReport, HttpStatus.CREATED);
    }
}
