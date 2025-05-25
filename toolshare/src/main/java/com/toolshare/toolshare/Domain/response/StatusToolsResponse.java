package com.toolshare.toolshare.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusToolsResponse {
    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private String status;
}
