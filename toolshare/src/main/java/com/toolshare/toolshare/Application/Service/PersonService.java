package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.response.PersonResponse;


public interface PersonService {
    List<PersonResponse> findPersonByRole(String role);
    List<PersonResponse> findPersonCustomerSupplier();
}
