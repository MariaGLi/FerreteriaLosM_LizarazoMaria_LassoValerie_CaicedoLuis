package com.toolshare.toolshare.Domain;

import java.time.LocalDate;
import java.util.List;

import com.toolshare.toolshare.Domain.Enum.StatusReservations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date; 

    @Column(nullable = false)
    private LocalDate Request_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReservations status;

    @ManyToMany
    @JoinTable(
        name = "Reservations_ToolsEquipmentConstructions",
        joinColumns = @JoinColumn(name= "id_reservation"),
        inverseJoinColumns = @JoinColumn(name = "id_tools_equipmentContruction")
    )
    private List<ToolsEquipmentConstruction> toolsECList;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Users id_user_client;

    public Reservations(){}

    public Reservations(Long id, LocalDate start_date, LocalDate end_date, LocalDate request_date,
            StatusReservations status, List<ToolsEquipmentConstruction> toolsECList, Users id_user_client) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        Request_date = request_date;
        this.status = status;
        this.toolsECList = toolsECList;
        this.id_user_client = id_user_client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalDate getRequest_date() {
        return Request_date;
    }

    public void setRequest_date(LocalDate request_date) {
        Request_date = request_date;
    }

    public StatusReservations getStatus() {
        return status;
    }

    public void setStatus(StatusReservations status) {
        this.status = status;
    }

    public List<ToolsEquipmentConstruction> getToolsECList() {
        return toolsECList;
    }

    public void setToolsECList(List<ToolsEquipmentConstruction> toolsECList) {
        this.toolsECList = toolsECList;
    }

    public Users getId_user_client() {
        return id_user_client;
    }

    public void setId_user_client(Users id_user_client) {
        this.id_user_client = id_user_client;
    }

    
}
