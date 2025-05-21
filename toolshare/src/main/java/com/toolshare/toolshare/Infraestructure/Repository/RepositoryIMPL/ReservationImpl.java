package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.ReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;

@Service
public class ReservationImpl implements ReservationService{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public Reservations acceptReservations(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.Approved);

        return reservationsRepository.save(reservation);
    }
    @Override
    public Reservations rejectReservations(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(()-> new RuntimeException("Reservation not found"));
        reservation.setStatus(StatusReservations.Rejected);

        return reservationsRepository.save(reservation);
    }
    @Override
    public List<Reservations> getAllStatusPending() {
        return reservationsRepository.findByStatus(StatusReservations.Pending);
    }

    @Override
    public List<Reservations> getAllStatusCompleted() {
        return reservationsRepository.findByStatus(StatusReservations.Completed);
    }
    @Override
    public List<Reservations> getAllStatusReturn() {
        return reservationsRepository.findByStatus(StatusReservations.Return);
    }
    @Override
    public Reservations returnAccept(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.ReturnAccept);

        return reservationsRepository.save(reservation);
    }
    @Override
    public Reservations returnReject(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.ReturnReject);

        return reservationsRepository.save(reservation);
    }
    @Override
    public List<Reservations> getAllStatusReturnAccept() {
        return reservationsRepository.findByStatus(StatusReservations.ReturnAccept);
    }
    

}
