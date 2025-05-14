package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Long>{

}
