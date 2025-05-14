package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}
