package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.CustomerPaymentService;
import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Enum.StatusPayments;
import com.toolshare.toolshare.Infraestructure.Repository.PaymentsRepository;

@Service
public class CustomerPaymentImpl implements CustomerPaymentService{

    @Autowired 
    private PaymentsRepository paymentsRepository;

    @Override
    public Payments payInvoice(Long id, String method) {
        Optional<Payments> findById= paymentsRepository.findById(id);
        Payments exist= findById.get();
        exist.setPayment_date(LocalDate.now());
        exist.setPayment_method(method);
        exist.setStatus(StatusPayments.Paid);

        return paymentsRepository.save(exist);
    }

    @Override
    public List<Payments> getAllPayPending() {
        return paymentsRepository.findByStatus(StatusPayments.Pending);
    }
    

}
