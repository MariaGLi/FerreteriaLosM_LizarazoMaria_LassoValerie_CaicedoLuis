package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.dto.ReservationDto;

public interface custReservationService {
    Reservations newReservations(ReservationDto reservDto);
}
