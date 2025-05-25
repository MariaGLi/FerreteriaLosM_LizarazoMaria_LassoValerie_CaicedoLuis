package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.dto.RentalInvoiceDto;
import com.toolshare.toolshare.Domain.response.InvoiceResponse;

public interface RentalInvoiceService {
    Invoices newInvoice(RentalInvoiceDto dto);
    List<InvoiceResponse> findAllInvoice();
}
