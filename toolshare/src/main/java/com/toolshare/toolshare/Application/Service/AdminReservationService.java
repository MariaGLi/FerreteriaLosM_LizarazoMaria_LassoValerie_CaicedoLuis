package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;

public interface AdminReservationService {
    List<RentalHistoryResponse> getRentalHistory();
}
