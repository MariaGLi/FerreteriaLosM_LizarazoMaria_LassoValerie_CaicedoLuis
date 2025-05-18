package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.DamageReportService;
import com.toolshare.toolshare.Domain.DamageReport;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Users;
import com.toolshare.toolshare.Domain.dto.DamageReportDto;
import com.toolshare.toolshare.Infraestructure.Repository.DamagedReportRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;
import com.toolshare.toolshare.Infraestructure.Repository.UsersRepository;

@Service
public class DamageReportImpl implements DamageReportService{

    @Autowired
    private DamagedReportRepository dReportRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ToolsECRepository toolsECRepository;

    @Autowired
    private ReservationsRepository reservations;

    @Override
    public DamageReport newReport(DamageReportDto dReportDto) {
        if(dReportDto.getIdClient()==null || dReportDto.getIdReservation()==null|| dReportDto.getIdToolEC()==null || dReportDto.getStatus()==null){
            throw new IllegalArgumentException("ERROR: Client, Tool and reservation is mentory");
        }
        Users idClient= usersRepository.findById(dReportDto.getIdClient()).orElseThrow(()-> new RuntimeException("User not found"));
        ToolsEquipmentConstruction idTool= toolsECRepository.findById(dReportDto.getIdToolEC()).orElseThrow(()-> new RuntimeException("Product not found"));
        Reservations idReservation= reservations.findById(dReportDto.getIdReservation()).orElseThrow(()-> new RuntimeException("Reservation not fount"));
        
        DamageReport damageReport= new DamageReport();
        damageReport.setDescription(dReportDto.getDescription());
        damageReport.setIdToolsEC(idTool);
        damageReport.setId_reservation(idReservation);
        damageReport.setId_users_report(idClient);
        damageReport.setReport_date(dReportDto.getReporDate() != null ? dReportDto.getReporDate() : LocalDate.now());
        damageReport.setStatus(dReportDto.getStatus());
        
        return dReportRepository.save(damageReport);
    }

}
