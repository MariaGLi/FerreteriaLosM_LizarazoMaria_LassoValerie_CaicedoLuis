package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.ReservationService;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Reservations;
import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.ToolsInvoices;
import com.toolshare.toolshare.Domain.Enum.StatusPayments;
import com.toolshare.toolshare.Domain.Enum.StatusReservations;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;
import com.toolshare.toolshare.Infraestructure.Repository.PaymentsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ReservationsRepository;
import com.toolshare.toolshare.Infraestructure.Repository.ToolsInvoiceRepository;

@Service
public class ReservationImpl implements ReservationService{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private ToolsInvoiceRepository tInvoiceRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;
    
    @Autowired
    private InvoicesRepository invoicesRepository;
    @Override
    public Reservations acceptReservations(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.Approved);
        
        Reservations reservationApproved= reservationsRepository.save(reservation);
        autoGenerateInvoiceFromReservation(reservationApproved);
        return reservationApproved;
    }
    @Override
    public Reservations rejectReservations(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(()-> new RuntimeException("Reservation not found"));
        reservation.setStatus(StatusReservations.Rejected);
        
        return reservationsRepository.save(reservation);
    }
    @Override
    public List<Reservations> getAllStatusPending() {
        return reservationsRepository.findByStatus(StatusReservations.Pending);
    }

    @Override
    public List<Reservations> getAllStatusCompleted() {
        return reservationsRepository.findByStatus(StatusReservations.Completed);
    }
    @Override
    public List<Reservations> getAllStatusReturn() {
        return reservationsRepository.findByStatus(StatusReservations.Return);
    }
    @Override
    public Reservations returnAccept(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.ReturnAccept);

        return reservationsRepository.save(reservation);
    }
    @Override
    public Reservations returnReject(Long id) {
        Reservations reservation= reservationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation: Not found"));
        reservation.setStatus(StatusReservations.ReturnReject);

        return reservationsRepository.save(reservation);
    }
    @Override
    public List<Reservations> getAllStatusReturnAccept() {
        return reservationsRepository.findByStatus(StatusReservations.ReturnAccept);
    }
    @Override
    public Invoices autoGenerateInvoiceFromReservation(Reservations reservation) {
        if(reservation== null || reservation.getToolsECList()== null){
            throw new RuntimeException("No tools found for this reservation");
        }
        // payment
        Payments payment= new Payments();
        payment.setId_reservations(reservation);
        payment.setPayment_date(LocalDate.now());
        payment.setStatus(StatusPayments.Pending);
        payment.setPayment_method("method");
        payment.setPrice_total(0.0);

        Payments SavedPayment= paymentsRepository.save(payment);
        System.out.println("pay" + SavedPayment);
        // invoice
        Long NumbreInvoice= invoicesRepository.findLastInvoiceNumber() + 1;

        Invoices invoice= new Invoices();
        invoice.setAddress("Calle 123 #45-67, Bogotá");
        invoice.setCellphone("302456780");
        invoice.setExpiration_date(LocalDate.now().plusDays(20));
        invoice.setInvoice_generation_date(LocalDate.now());
        invoice.setName_tool_share("ToolShare SAS");
        invoice.setNit("900123-7");
        invoice.setUrl_signature("https://firma.toolshare.com/1001");
        invoice.setRegistration_date(LocalDate.now());
        invoice.setNumber_invoice(NumbreInvoice);
        invoice.setId_payments(SavedPayment);
        invoice.setId_client(reservation.getId_user_client());

        Invoices savedInvoices=  invoicesRepository.save(invoice);

        List<ToolsInvoices> toolsList= new ArrayList<>();
        double total= 0;
        for(ToolsEquipmentConstruction tool: reservation.getToolsECList()){
            ToolsInvoices toolsInvoices= new ToolsInvoices();
            toolsInvoices.setInvoices(savedInvoices);
            toolsInvoices.setToolsEquipmentConstruction(tool);

            Long days= ChronoUnit.DAYS.between(reservation.getStart_date(), reservation.getEnd_date());
            int quantity= (int)(days >0 ? days: 1);

            double unitV= tool.getPriceDay();
            double totalValue = unitV * quantity;

            toolsInvoices.setUnit_value(unitV);
            toolsInvoices.setTotal_value(totalValue);
            toolsInvoices.setQuantity(quantity);

            total += totalValue;
            toolsList.add(toolsInvoices);
        }
        tInvoiceRepository.saveAll(toolsList);
        payment.setPrice_total(total);
        savedInvoices.setAnd_total(total);
        System.out.println("facturaaaaaaaaaa" +invoice);
        System.out.println("pagooooo" + payment);
        return invoicesRepository.save(invoice);
    }
    

}
