package com.toolshare.toolshare.Infraestructure.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.ToolsEquipmentConstruction;
import com.toolshare.toolshare.Domain.Enum.StatusToolsEC;
import com.toolshare.toolshare.Domain.response.MostRentedResponse;


@Repository
public interface ToolsECRepository extends JpaRepository<ToolsEquipmentConstruction, Long>{
    List<ToolsEquipmentConstruction> findByStatus(StatusToolsEC status);
    List<ToolsEquipmentConstruction>findAllByOrderByPriceDayAsc();

    @Query(value = """
        SELECT t.id, t.name, t.description, count(*), sum(t.price_day*(r.end_date - r.start_date))
        FROM tools_equipment_construction t
        INNER JOIN reservations_tools_equipment_constructions rt
        ON t.id = rt.id_tools_equipment_contruction
        INNER JOIN reservations r
        ON rt.id_reservation = r.id
        WHERE r.status = 'Completed'
        AND r.start_date BETWEEN :date AND CURRENT_DATE GROUP BY 1
    """,
    nativeQuery = true)
    List<MostRentedResponse> findMostRented(@Param("date") LocalDate date);
}
