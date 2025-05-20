package com.toolshare.toolshare.Domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Invoices {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name_tool_share;

    @Column(length = 15 ,nullable = false)
    private String nit;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 20, unique = true)
    private Long number_invoice;

    @Column(length = 30)
    private String cellphone;

    @Column(nullable = false)
    private LocalDate registration_date;

    @Column(nullable = false)
    private LocalDate invoice_generation_date;

    @Column(nullable = false)
    private LocalDate expiration_date;

    @Column(nullable = false)
    private String url_signature;

    @Column(nullable = false)
    private double and_total;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(nullable = false)
    private Persons id_client;

    @OneToOne
    @JsonIgnore
    @JoinColumn(nullable = false)
    private Payments id_payments;

    @OneToMany(mappedBy = "invoices")
    @JsonIgnore
    private List<ToolsInvoices> tool_invoice_list;

    public Invoices() {
    }

    public Invoices(Long id, String name_tool_share, String nit, String address, Long number_invoice, String cellphone,
            LocalDate registration_date, LocalDate invoice_generation_date, LocalDate expiration_date,
            String url_signature, double and_total, Persons id_client, Payments id_payments,
            List<ToolsInvoices> tool_invoice_list) {
        this.id = id;
        this.name_tool_share = name_tool_share;
        this.nit = nit;
        this.address = address;
        this.number_invoice = number_invoice;
        this.cellphone = cellphone;
        this.registration_date = registration_date;
        this.invoice_generation_date = invoice_generation_date;
        this.expiration_date = expiration_date;
        this.url_signature = url_signature;
        this.and_total = and_total;
        this.id_client = id_client;
        this.id_payments = id_payments;
        this.tool_invoice_list = tool_invoice_list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_tool_share() {
        return name_tool_share;
    }

    public void setName_tool_share(String name_tool_share) {
        this.name_tool_share = name_tool_share;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber_invoice() {
        return number_invoice;
    }

    public void setNumber_invoice(Long number_invoice) {
        this.number_invoice = number_invoice;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public LocalDate getInvoice_generation_date() {
        return invoice_generation_date;
    }

    public void setInvoice_generation_date(LocalDate invoice_generation_date) {
        this.invoice_generation_date = invoice_generation_date;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getUrl_signature() {
        return url_signature;
    }

    public void setUrl_signature(String url_signature) {
        this.url_signature = url_signature;
    }

    public double getAnd_total() {
        return and_total;
    }

    public void setAnd_total(double and_total) {
        this.and_total = and_total;
    }

    public Persons getId_client() {
        return id_client;
    }

    public void setId_client(Persons id_client) {
        this.id_client = id_client;
    }

    public Payments getId_payments() {
        return id_payments;
    }

    public void setId_payments(Payments id_payments) {
        this.id_payments = id_payments;
    }

    public List<ToolsInvoices> getTool_invoice_list() {
        return tool_invoice_list;
    }

    public void setTool_invoice_list(List<ToolsInvoices> tool_invoice_list) {
        this.tool_invoice_list = tool_invoice_list;
    }

    

}
