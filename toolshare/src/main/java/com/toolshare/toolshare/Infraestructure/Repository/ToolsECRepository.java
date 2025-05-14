package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;

public interface ToolsECRepository extends JpaRepository<ToolsEquipmentConstruction, Long>{

}
