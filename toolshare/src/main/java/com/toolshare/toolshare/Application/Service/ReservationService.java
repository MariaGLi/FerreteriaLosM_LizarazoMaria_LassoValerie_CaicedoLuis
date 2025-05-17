package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;

public interface ReservationService {
    Reservations acceptReservations(Long id);
    Reservations rejectReservations(Long id);
    List<Reservations> getAllStatusPending();
    List<Reservations> getAllStatusCompleted();
}
