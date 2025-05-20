package com.toolshare.toolshare.Domain.response;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolsInvoiceResponse {
    private Long id;
    private ToolsEquipmentConstruction toolsEquipmentConstruction;
    private Double unit_value;
    private Integer quantity;
    private Double total_value;
}
