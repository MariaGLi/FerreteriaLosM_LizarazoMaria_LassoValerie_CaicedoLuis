package com.toolshare.toolshare.Infraestructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.Payments;
import com.toolshare.toolshare.Domain.Enum.StatusPayments;


@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long>{
    List<Payments>findByStatus(StatusPayments status);
}
