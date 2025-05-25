package com.toolshare.toolshare.Infraestructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.ReturnsDeliveries;

@Repository
public interface ReturnsDeliveriesRepository extends JpaRepository<ReturnsDeliveries, Long>{

}
