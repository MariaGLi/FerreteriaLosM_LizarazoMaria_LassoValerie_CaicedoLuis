package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.AdminToolsService;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Domain.response.StatusToolsResponse;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AdminToolsServiceImpl implements AdminToolsService {

    private final ReservationsRepository reservationsRepository;

    @Override
    public List<StatusToolsResponse> findStatusTools() {
        List<Reservations> reservations = reservationsRepository.findByStatus(StatusReservations.Completed);
        List<ToolsEquipmentConstruction> toolsReservation = new ArrayList<>();

        for (Reservations r : reservations) {
            if (!r.getToolsECList().isEmpty()) {

                List<ToolsEquipmentConstruction> tools = r.getToolsECList();

                for (ToolsEquipmentConstruction t : tools) {
                    if (!toolsReservation.contains(t)) {
                        toolsReservation.add(t);
                    }
                }
            }
            
        }

        List<StatusToolsResponse> statusToolsResponse = new ArrayList<>();

        for (ToolsEquipmentConstruction t : toolsReservation) {
            statusToolsResponse.add(StatusToolsResponse.builder()
            .id(t.getId())
            .name(t.getName())
            .category(t.getCategory())
            .description(t.getDescription())
            .price(t.getPriceDay())
            .status(t.getStatus().toString())
            .build()
            );
        }

        return statusToolsResponse;
    }
    
}
