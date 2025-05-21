package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.dto.PaymentsDto;

public interface PaymentsService {
    Payments newPayment(PaymentsDto dto);
    List<Payments> getAllStatusPaid();
}
