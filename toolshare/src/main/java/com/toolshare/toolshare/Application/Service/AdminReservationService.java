package com.toolshare.toolshare.Application.Service;

import java.time.LocalDate;
import java.util.List;

import com.toolshare.toolshare.Domain.response.MostRentedResponse;
import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;

public interface AdminReservationService {
    List<RentalHistoryResponse> getRentalHistory();
    List<MostRentedResponse> getMostRented(LocalDate date);
}
