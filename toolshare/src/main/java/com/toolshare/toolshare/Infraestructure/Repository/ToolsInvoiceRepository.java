package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.ToolsInvoices;

@Repository
public interface ToolsInvoiceRepository extends JpaRepository<ToolsInvoices, Long>{

}
