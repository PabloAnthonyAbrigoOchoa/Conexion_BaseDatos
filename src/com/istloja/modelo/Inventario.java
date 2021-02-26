package com.istloja.modelo;

public class Inventario {

    private int idInventario;
    private String códigoPro;
    private String descripción;
    private String preciosCompra;
    private String precioVenta;
    private String canProductos;

    public Inventario() {
    }

    public Inventario(int idInventario, String códigoPro, String descripción, String preciosCompra, String precioVenta, String canProductos) {
        this.idInventario = idInventario;
        this.códigoPro = códigoPro;
        this.descripción = descripción;
        this.preciosCompra = preciosCompra;
        this.precioVenta = precioVenta;
        this.canProductos = canProductos;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getCódigoPro() {
        return códigoPro;
    }

    public void setCódigoPro(String códigoPro) {
        this.códigoPro = códigoPro;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getPreciosCompra() {
        return preciosCompra;
    }

    public void setPreciosCompra(String preciosCompra) {
        this.preciosCompra = preciosCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCanProductos() {
        return canProductos;
    }

    public void setCanProductos(String canProductos) {
        this.canProductos = canProductos;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idInventario=" + idInventario + ", c\u00f3digoPro=" + códigoPro + ", descripci\u00f3n=" + descripción + ", preciosCompra=" + preciosCompra + ", precioVenta=" + precioVenta + ", canProductos=" + canProductos + '}';
    }

}
