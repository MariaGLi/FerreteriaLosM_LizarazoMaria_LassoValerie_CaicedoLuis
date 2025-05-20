package com.toolshare.toolshare.Domain.response;

import java.time.LocalDate;

import com.toolshare.toolshare.Domain.Enum.StatusPayments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private String payment_method;
    private Double price_total;
    private LocalDate payment_date;
    private StatusPayments status;
    private ReservationResponse reservation;
}
