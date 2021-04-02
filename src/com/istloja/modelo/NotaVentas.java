package com.istloja.modelo;

import java.sql.Date;

public class NotaVentas {

    private int idNotaVenta;
    private String numeroNotaVenta;
    private int personaIdPersona;
    private Date fechaVenta;
    private Double subTotal;
    private Double iva;
    private Double totalVenta;
    private int tipoPago;

    public NotaVentas(int idNotaVenta, String numeroNotaVenta, int personaIdPersona, Date fechaVenta, Double subTotal, Double iva, Double totalVenta, int tipoPago) {
        this.idNotaVenta = idNotaVenta;
        this.numeroNotaVenta = numeroNotaVenta;
        this.personaIdPersona = personaIdPersona;
        this.fechaVenta = fechaVenta;
        this.subTotal = subTotal;
        this.iva = iva;
        this.totalVenta = totalVenta;
        this.tipoPago = tipoPago;
    }

    public int getIdNotaVenta() {
        return idNotaVenta;
    }

    public void setIdNotaVenta(int idNotaVenta) {
        this.idNotaVenta = idNotaVenta;
    }

    public String getNumeroNotaVenta() {
        return numeroNotaVenta;
    }

    public void setNumeroNotaVenta(String numeroNotaVenta) {
        this.numeroNotaVenta = numeroNotaVenta;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "NotaVentas{" + "idNotaVenta=" + idNotaVenta + ", numeroNotaVenta=" + numeroNotaVenta + ", personaIdPersona=" + personaIdPersona + ", fechaVenta=" + fechaVenta + ", subTotal=" + subTotal + ", iva=" + iva + ", totalVenta=" + totalVenta + ", tipoPago=" + tipoPago + '}';
    }

}
