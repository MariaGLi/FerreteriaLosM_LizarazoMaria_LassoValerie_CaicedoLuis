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
public class TECResponse {
    private Long id;
    private String type;
    private String name;
    private String category;
    private LocalDate dateRegister;
    private Double price;
    private String description;
    private Long supplier_id;
}
