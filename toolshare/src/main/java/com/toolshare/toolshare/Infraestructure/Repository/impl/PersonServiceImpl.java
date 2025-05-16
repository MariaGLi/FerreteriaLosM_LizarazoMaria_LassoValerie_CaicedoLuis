package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.PersonService;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Infraestructure.Repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<PersonResponse> findPersonCustomerSupplier() {
        List<Persons> persons = personRepository.findAll();
        List<PersonResponse> personResponse = new ArrayList<>();

        for (Persons p : persons) {
            if (p.getId_user().getType().toString().equals("Customer") || p.getId_user().getType().toString().equals("Supplier")) {
                personResponse.add(new PersonResponse().builder()
                .id(p.getId())
                .name(p.getName())
                .lastName(p.getLast_name())
                .email(p.getEmail())
                .dateRegister(p.getDate_register().toString())
                .userId(p.getId_user().getId())
                .cellphone(p.getCellphone())
                .build()
                );
            }
        }

        return personResponse;

    }

    @Override
    public List<PersonResponse> findPersonByRole(String role){
        List<Persons> persons = personRepository.findAll();
        List<PersonResponse> personResponse = new ArrayList<>();

        for (Persons p : persons) {
            if (p.getId_user().getType().toString().toLowerCase().equals(role)) {
                personResponse.add(new PersonResponse().builder()
                .id(p.getId())
                .name(p.getName())
                .lastName(p.getLast_name())
                .email(p.getEmail())
                .dateRegister(p.getDate_register().toString())
                .userId(p.getId_user().getId())
                .cellphone(p.getCellphone())
                .build()
                );
            }
        }

        return personResponse;

    }
    
}
