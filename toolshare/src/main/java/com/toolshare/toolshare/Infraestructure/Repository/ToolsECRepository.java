package com.toolshare.toolshare.Infraestructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;


@Repository
public interface ToolsECRepository extends JpaRepository<ToolsEquipmentConstruction, Long>{
    List<ToolsEquipmentConstruction> findByStatus(StatusToolsEC status);
    List<ToolsEquipmentConstruction>findAllByOrderByPriceDayAsc();
}
