package com.toolshare.toolshare.Domain.request;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusDamageReport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DamageReportUpdateRequest {
    private long id;
    private String description;
    private LocalDate solutionDate;
    private StatusDamageReport status;
}
