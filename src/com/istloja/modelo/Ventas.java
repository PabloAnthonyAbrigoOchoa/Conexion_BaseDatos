package com.istloja.modelo;

import java.sql.Date;

public class Ventas {

    private int idVentas;
    private String cedula;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String cp;
    private int telefono;
    private Date fecha;
    private String condicionesPago;

    public Ventas(int idVentas, String cedula, String nombre, String direccion, String ciudad, String cp, int telefono, Date fecha, String condicionesPago) {
        this.idVentas = idVentas;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.telefono = telefono;
        this.fecha = fecha;
        this.condicionesPago = condicionesPago;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondicionesPago() {
        return condicionesPago;
    }

    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    @Override
    public String toString() {
        return "Ventas{" + "idVentas=" + idVentas + ", cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", cp=" + cp + ", telefono=" + telefono + ", fecha=" + fecha + ", condicionesPago=" + condicionesPago + '}';
    }

}
