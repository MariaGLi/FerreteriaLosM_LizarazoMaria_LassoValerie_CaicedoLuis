package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.CustomerInvoiceService;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;

@Service
public class CustomerInvoiceImpl implements CustomerInvoiceService{

    @Autowired
    private InvoicesRepository invoicesRepository;
    
    @Override
    public List<Invoices> getAllInvoice() {
        return invoicesRepository.findAll();
    }
    
}
