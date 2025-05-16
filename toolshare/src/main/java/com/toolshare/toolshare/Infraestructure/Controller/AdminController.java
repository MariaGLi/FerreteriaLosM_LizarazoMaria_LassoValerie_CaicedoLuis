package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.PersonService;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.response.PersonResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PersonService personService;

    @PostMapping("/users")
    public ResponseEntity<List<PersonResponse>> getUsers(@RequestParam(required = false)String role) {
        if (role!=null) {
            
            if (role.equals("customer") || role.equals("supplier")) {
                return ResponseEntity.ok(personService.findPersonByRole(role));
            }
            
        }
        return ResponseEntity.ok(personService.findPersonCustomerSupplier());
    }
    
}
