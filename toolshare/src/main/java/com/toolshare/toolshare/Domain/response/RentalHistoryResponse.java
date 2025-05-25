package com.toolshare.toolshare.Domain.response;

import java.util.List;

import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalHistoryResponse {
    private Long id;
    private String requestDate;
    private String startDate;
    private String endDate;
    private String status;
    private PersonResponse person;
    private List<ToolsEquipmentConstruction> tools;
}
