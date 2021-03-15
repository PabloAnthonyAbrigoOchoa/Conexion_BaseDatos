package com.istloja.modelo;

import java.sql.Date;

public class Proveedores {

    private int idProveedores;
    private String ruc;
    private String razonSocial;
    private String tipoActividad;
    private String nombreRepresentanteLegal;
    private String ApellidoRepresentanteLegal;
    private String telefono;
    private String correo;
    private String direccion;
    private Date fecha_registro;

    public Proveedores(int idProveedores, String ruc, String razonSocial, String tipoActividad, String nombreRepresentanteLegal, String ApellidoRepresentanteLegal, String telefono, String correo, String direccion, Date fecha_registro) {
        this.idProveedores = idProveedores;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.tipoActividad = tipoActividad;
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
        this.ApellidoRepresentanteLegal = ApellidoRepresentanteLegal;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fecha_registro = fecha_registro;
    }

    public Proveedores() {
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getApellidoRepresentanteLegal() {
        return ApellidoRepresentanteLegal;
    }

    public void setApellidoRepresentanteLegal(String ApellidoRepresentanteLegal) {
        this.ApellidoRepresentanteLegal = ApellidoRepresentanteLegal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "idProveedores=" + idProveedores + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", tipoActividad=" + tipoActividad + ", nombreRepresentanteLegal=" + nombreRepresentanteLegal + ", ApellidoRepresentanteLegal=" + ApellidoRepresentanteLegal + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", fecha_registro=" + fecha_registro + '}';
    }

}
