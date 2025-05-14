package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.Persons;

public interface PersonRepository extends JpaRepository<Persons, Long>{

}
