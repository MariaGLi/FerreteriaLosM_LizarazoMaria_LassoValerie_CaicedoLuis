package com.toolshare.toolshare.Infraestructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long>{
    List<Reservations> findByStatus(StatusReservations status);
}
