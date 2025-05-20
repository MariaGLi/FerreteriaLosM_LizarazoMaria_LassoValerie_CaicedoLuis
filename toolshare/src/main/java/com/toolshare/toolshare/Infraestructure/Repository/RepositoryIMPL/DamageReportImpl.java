package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.DamageReportService;
import com.toolshare.toolshare.Domain.DamageReport;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.dto.DamageReportDto;
import com.toolshare.toolshare.Domain.request.DamageReportUpdateRequest;
import com.toolshare.toolshare.Domain.response.DamageReportResponse;
import com.toolshare.toolshare.Domain.response.DamageReportUpdateResponse;
import com.toolshare.toolshare.Domain.response.PersonResponse;
import com.toolshare.toolshare.Domain.response.ReservationResponse;
import com.toolshare.toolshare.Domain.response.TECResponse;
import com.toolshare.toolshare.Infraestructure.Repository.DamagedReportRepository;
import com.toolshare.toolshare.Infraestructure.Repository.PersonRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsECRepository;

@Service
public class DamageReportImpl implements DamageReportService{

    @Autowired
    private DamagedReportRepository dReportRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ToolsECRepository toolsECRepository;

    @Autowired
    private ReservationsRepository reservations;

    @Override
    public DamageReport newReport(DamageReportDto dReportDto) {
        if(dReportDto.getIdClient()==null || dReportDto.getIdReservation()==null|| dReportDto.getIdToolEC()==null || dReportDto.getStatus()==null){
            throw new IllegalArgumentException("ERROR: Client, Tool and reservation is mentory");
        }
        Persons idClient= personRepository.findById(dReportDto.getIdClient()).orElseThrow(()-> new RuntimeException("User not found"));
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

    @Override
    public List<DamageReportResponse> findAllReports() {
        List<DamageReport> damageReports = dReportRepository.findAll();
        List<DamageReportResponse> listDRR = new ArrayList<>();

        for (DamageReport d : damageReports) {
            listDRR.add(DamageReportResponse.builder()
            .id(d.getId())
            .description(d.getDescription())
            .reportDate(d.getReport_date())
            .solutionDate(d.getSolution_date())
            .status(d.getStatus().toString())
            .suplier(PersonResponse.builder()
                .id(d.getId_users_report().getId())
                .name(d.getId_users_report().getName())
                .lastName(d.getId_users_report().getLast_name())
                .email(d.getId_users_report().getEmail())
                .dateRegister(d.getId_users_report().getDate_register())
                .cellphone(d.getId_users_report().getCellphone())
                .userId(d.getId_users_report().getId_user().getId())
                .build()
                )
            .tool(TECResponse.builder()
                .id(d.getIdToolsEC().getId())
                .type(d.getIdToolsEC().getType().toString())
                .name(d.getIdToolsEC().getName())
                .category(d.getIdToolsEC().getCategory())
                .dateRegister(d.getIdToolsEC().getDate_register())
                .price(d.getIdToolsEC().getPriceDay())
                .description(d.getIdToolsEC().getDescription())
                .supplier_id(d.getIdToolsEC().getId_user_supplier().getId())
                .build()
                )
            .reservation(ReservationResponse.builder()
                .id(d.getId_reservation().getId())
                .start_date(d.getId_reservation().getStart_date())
                .end_date(d.getId_reservation().getEnd_date())
                .request_date(d.getId_reservation().getRequest_date())
                .status(d.getId_reservation().getStatus().toString())
                .build()
                )
            .build()
            );
        }

        return listDRR;
    }

    @Override
    public DamageReportUpdateResponse updateDamageReport(DamageReportUpdateRequest dr) {
        
        DamageReport damageReport = dReportRepository.findById(dr.getId()).orElseThrow(()-> new RuntimeException("Damage Report No found"));

        if (dr.getDescription()!=null) {
            damageReport.setDescription(dr.getDescription());
        }
        if (dr.getSolutionDate()!=null) {
            damageReport.setSolution_date(dr.getSolutionDate());
        }
        if (dr.getStatus()!=null) {
            damageReport.setStatus(dr.getStatus());
        }

        dReportRepository.save(damageReport);

        DamageReportUpdateResponse DRUResponse = DamageReportUpdateResponse.builder()
        .description(damageReport.getDescription())
        .solutionDate(damageReport.getSolution_date())
        .status(damageReport.getStatus())
        .build();

        return DRUResponse;
    }

}
