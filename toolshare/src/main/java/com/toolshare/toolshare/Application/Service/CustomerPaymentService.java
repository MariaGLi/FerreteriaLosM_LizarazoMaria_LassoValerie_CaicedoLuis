package com.toolshare.toolshare.Application.Service;

import java.time.LocalDate;
import java.util.List;

import com.toolshare.toolshare.Domain.Payments;

public interface CustomerPaymentService {
    Payments payInvoice(Long id, String method);
    List<Payments> getAllPayPending();
}
