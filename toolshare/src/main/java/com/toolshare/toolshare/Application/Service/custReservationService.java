package com.toolshare.toolshare.Application.Service;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;

public interface custReservationService {

    public Reservations createReservation (LocalDate start_date, LocalDate end_date, LocalDate Request_date, StatusReservations status);
}
