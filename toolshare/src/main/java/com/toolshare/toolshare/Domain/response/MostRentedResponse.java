package com.toolshare.toolshare.Domain.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MostRentedResponse {
    private long id;
    private String name;
    private String description;
    private Long quantity;
    private Double total;
    private BigDecimal percentage;
}
