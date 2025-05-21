package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.Reservations;

public interface ReservationService {
    Reservations acceptReservations(Long id);
    Reservations rejectReservations(Long id);
    Reservations returnAccept(Long id);
    Reservations returnReject(Long id);
    List<Reservations> getAllStatusPending();
    List<Reservations> getAllStatusCompleted();
    List<Reservations> getAllStatusReturn();
    List<Reservations> getAllStatusReturnAccept();
}
