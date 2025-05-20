package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.dto.PaymentsDto;

public interface PaymentsService {
    Payments newPayment(PaymentsDto dto);
}
