package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.custReservationService;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Domain.dto.ReservationDto;
import com.toolshare.toolshare.Infraestructure.Repository.PersonRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;

@Service
public class custReservImpl implements custReservationService{

    @Autowired
    private ReservationsRepository reservRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ToolsECRepository toolsRepository;

    @Override
    public Reservations newReservations(ReservationDto reservDto) {

        Persons idClient= personRepository.findById(reservDto.getIdClient()).orElseThrow(()-> new RuntimeException("User not found"));

        List<ToolsEquipmentConstruction> idTool = toolsRepository.findAllById(reservDto.getIdToolEC());
        
        Reservations newReservations = new Reservations();
        newReservations.setStart_date(reservDto.getStartDate());
        newReservations.setEnd_date(reservDto.getEndDate());
        newReservations.setRequest_date(reservDto.getRequestDate());
        newReservations.setStatus(StatusReservations.Pending);

        newReservations.setId_user_client(idClient);
        newReservations.setToolsECList(idTool);

        return reservRepository.save(newReservations);
    } 
}
