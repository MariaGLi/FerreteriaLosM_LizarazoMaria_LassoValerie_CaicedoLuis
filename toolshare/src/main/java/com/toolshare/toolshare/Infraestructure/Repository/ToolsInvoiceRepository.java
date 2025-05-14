package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.ToolsInvoices;

public interface ToolsInvoiceRepository extends JpaRepository<ToolsInvoices, Long>{

}
