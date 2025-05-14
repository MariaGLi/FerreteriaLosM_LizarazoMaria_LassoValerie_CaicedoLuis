package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.DamageReport;

public interface DamagedReportRepository extends JpaRepository<DamageReport, Long>{

}
