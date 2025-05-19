package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.dto.RentalInvoiceDto;

public interface RentalInvoiceService {
    Invoices newInvoice(RentalInvoiceDto dto);
}
