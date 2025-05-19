package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.custReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;

@Service
public class custReservImpl implements custReservationService{

    private final ReservationsRepository reservRepository;

    public custReservImpl(ReservationsRepository reservRepository) {
        this.reservRepository = reservRepository;
    }

    @Override
    public Reservations createReservation(LocalDate start_date, LocalDate end_date, LocalDate Reques_date,
            StatusReservations status) {
        
        Reservations newReservations = new Reservations();

        newReservations.setStart_date(start_date);
        newReservations.setEnd_date(end_date);
        newReservations.setRequest_date(Reques_date);
        newReservations.setStatus(status);

        return reservRepository.save(newReservations);
    }
}
