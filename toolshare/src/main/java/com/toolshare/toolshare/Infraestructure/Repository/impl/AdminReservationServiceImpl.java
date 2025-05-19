package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.AdminReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminReservationServiceImpl implements AdminReservationService {
    private final ReservationsRepository reservationsRepository;

    @Override
    public List<RentalHistoryResponse> getRentalHistory() {
        List<Reservations> reservations = reservationsRepository.findAll();
        List<RentalHistoryResponse> rentalHistoryResponse = new ArrayList<>();
        for (Reservations r : reservations) {
            rentalHistoryResponse.add(RentalHistoryResponse.builder()
            .id(r.getId())
            .requestDate(r.getRequest_date().toString())
            .startDate(r.getStart_date().toString())
            .endDate(r.getEnd_date().toString())
            .status(r.getStatus().toString())
            .person(PersonResponse.builder()
                .id(r.getId_user_client().getId())
                .name(r.getId_user_client().getName())
                .lastName(r.getId_user_client().getLast_name())
                .email(r.getId_user_client().getEmail())
                .dateRegister(r.getId_user_client().getDate_register().toString())
                .cellphone(r.getId_user_client().getCellphone())
                .userId(r.getId_user_client().getId_user().getId())
                .build()
            )
            .tools(r.getToolsECList())
            .build()
            );
        }
        return rentalHistoryResponse;
    }
    
}
