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
public class ReservationResponse {
    private Long id;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalDate request_date;
    private String status;
}
