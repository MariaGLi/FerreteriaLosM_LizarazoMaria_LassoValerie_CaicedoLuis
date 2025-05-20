package com.toolshare.toolshare.Domain.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DamageReportResponse {
    private Long id;
    private String description;
    private LocalDate reportDate;
    private LocalDate solutionDate;
    private String status;
    private PersonResponse suplier;
    private TECResponse tool;
    private ReservationResponse reservation;
}
