package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.Invoices;

public interface InvoicesRepository extends JpaRepository<Invoices, Long>{

}
