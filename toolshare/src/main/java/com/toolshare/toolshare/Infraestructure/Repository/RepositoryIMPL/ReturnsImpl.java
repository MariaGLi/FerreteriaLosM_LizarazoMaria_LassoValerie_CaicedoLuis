package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.ReturnsService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ReturnsDeliveries;
import com.toolshare.toolshare.Domain.dto.ReturnsDeliveriesDto;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReturnsDeliveriesRepository;

@Service
public class ReturnsImpl implements ReturnsService{

    @Autowired
    private ReturnsDeliveriesRepository returnRepository;
    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public ReturnsDeliveries acceptReturn(ReturnsDeliveriesDto dto) {
    
        Reservations reservation= reservationsRepository.findById(dto.getReservationId()).orElseThrow(()-> new RuntimeException("not found"));
        ReturnsDeliveries returnD= new ReturnsDeliveries();

        returnD.setId_reservations(reservation);
        returnD.setCommentary(dto.getCommentary());
        returnD.setReturn_date(dto.getReturnDate() != null ? dto.getReturnDate() : LocalDate.now());
        returnD.setStatus(dto.getStatus());
        return returnRepository.save(returnD);
    }

}
