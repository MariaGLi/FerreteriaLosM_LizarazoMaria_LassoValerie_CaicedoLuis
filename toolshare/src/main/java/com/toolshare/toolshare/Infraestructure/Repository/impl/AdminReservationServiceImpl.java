package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.AdminReservationService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.request.DateRentRequest;
import com.toolshare.toolshare.Domain.response.MostRentedResponse;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.RentalHistoryResponse;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminReservationServiceImpl implements AdminReservationService {
    private final ReservationsRepository reservationsRepository;
    private final ToolsECRepository toolsECRepository;

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
                .dateRegister(r.getId_user_client().getDate_register())
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

    @Override
    public List<MostRentedResponse> getMostRented(DateRentRequest dateRent) {
        List<MostRentedResponse> mostRented ;
        if (dateRent.getStartDate()!=null && dateRent.getEndDate()!=null) {
            mostRented = toolsECRepository.findMostRentedByDate(dateRent.getStartDate(),dateRent.getEndDate());
        }
        else{
            mostRented = toolsECRepository.findMostRented();
        }
        return mostRented;
    }
    
}
