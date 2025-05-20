package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.PaymentsService;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Domain.dto.PaymentsDto;
import com.toolshare.toolshare.Infraestructure.Repository.PaymentsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
@Service
public class PaymentsImpl implements PaymentsService{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Payments newPayment(PaymentsDto dto) {
        Reservations reservation= reservationsRepository.findById(dto.getIdReservation()).orElseThrow(() -> new RuntimeException("Reservation not found"));
        if(reservation.getStatus() != StatusReservations.Approved){
            throw new RuntimeException("Cannot generate payment: Reservation has not been Approved");
        }

        if(reservation.getToolsECList()== null || reservation.getToolsECList().isEmpty()){
            throw new RuntimeException("No tools found for this reservation");
        }
        Payments payment= new Payments();
        payment.setId_reservations(reservation);
        payment.setPayment_date(LocalDate.now());
        payment.setPayment_method(dto.getPaymentMethod());
        payment.setStatus(dto.getStatus());
        
        double total= 0;
        for(ToolsEquipmentConstruction tool: reservation.getToolsECList()){
            Long daysPrice= ChronoUnit.DAYS.between(reservation.getStart_date(), reservation.getEnd_date());
            // number of days
            int quantity= (int) (daysPrice >0 ? daysPrice:1);
            double unitV= tool.getPriceDay();
            double totalValue= unitV * quantity;

            total += totalValue;

        }
        payment.setPrice_total(total);
        
        return paymentsRepository.save(payment);
    }

}
