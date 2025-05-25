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

    //SUM(COUNT(*)) OVER () calcula el total de todas las filas
    @Query(value = """
        SELECT t.id, t.name, t.description, COUNT(*),
        SUM(t.price_day * (r.end_date - r.start_date)),
        ROUND(COUNT(*) * 100.0 / SUM(COUNT(*)) OVER (),2)
        FROM tools_equipment_construction t
        INNER JOIN reservations_tools_equipment_constructions rt
        ON t.id = rt.id_tools_equipment_contruction
        INNER JOIN reservations r
        ON rt.id_reservation = r.id
        WHERE r.status = 'Completed'
        AND r.start_date BETWEEN :startDate AND :endDate
        GROUP BY 1
        ORDER BY 4 DESC;
    """,
    nativeQuery = true)
    List<MostRentedResponse> findMostRentedByDate(@Param("startDate") LocalDate starDate,@Param("endDate") LocalDate endDate);

    @Query(value = """
        SELECT t.id, t.name, t.description, COUNT(*),
        SUM(t.price_day * (r.end_date - r.start_date)),
        ROUND(COUNT(*) * 100.0 / SUM(COUNT(*)) OVER (),2)
        FROM tools_equipment_construction t
        INNER JOIN reservations_tools_equipment_constructions rt
        ON t.id = rt.id_tools_equipment_contruction
        INNER JOIN reservations r
        ON rt.id_reservation = r.id
        WHERE r.status = 'Completed'
        GROUP BY 1
        ORDER BY 4 DESC;
    """,
    nativeQuery = true)
    List<MostRentedResponse> findMostRented();
}
