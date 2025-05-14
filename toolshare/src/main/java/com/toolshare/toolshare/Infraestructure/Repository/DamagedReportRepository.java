package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.DamageReport;

@Repository
public interface DamagedReportRepository extends JpaRepository<DamageReport, Long>{

}
