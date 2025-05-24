package com.toolshare.toolshare.Domain.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateRentRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
