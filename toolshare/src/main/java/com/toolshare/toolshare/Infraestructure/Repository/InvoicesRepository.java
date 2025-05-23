package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.Persons;
@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long>{
    @Query("SELECT COALESCE(MAX(i.number_invoice), 0) FROM Invoices i")
    Long findLastInvoiceNumber();

    Invoices findByIdClient(Persons id);
}
