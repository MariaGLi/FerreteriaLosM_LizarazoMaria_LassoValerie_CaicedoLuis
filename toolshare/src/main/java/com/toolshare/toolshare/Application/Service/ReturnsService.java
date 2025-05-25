package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.ReturnsDeliveries;
import com.toolshare.toolshare.Domain.dto.ReturnsDeliveriesDto;

public interface ReturnsService {
    ReturnsDeliveries acceptReturn(ReturnsDeliveriesDto dto);
}
