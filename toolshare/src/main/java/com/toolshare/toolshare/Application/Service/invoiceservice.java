package com.toolshare.toolshare.Application.Service;

import java.io.IOException;

import com.toolshare.toolshare.Domain.Invoices;

public interface invoiceservice {
    byte[] pdf(Long id) throws IOException;
    Invoices getInvoiceById(Long id);
}
