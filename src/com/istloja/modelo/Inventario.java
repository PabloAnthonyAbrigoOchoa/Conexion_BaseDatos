package com.istloja.modelo;

public class Inventario {

    private int idInventario;
    private String codProducto;
    private String descripcion;
    private String precioCompra;
    private String precioVenta;
    private String canProductos;

    public Inventario() {
    }

    public Inventario(int idInventario, String codProducto, String descripcion, String precioCompra, String precioVenta, String canProductos) {
        this.idInventario = idInventario;
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.canProductos = canProductos;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
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
        return "Inventario{" + "idInventario=" + idInventario + ", codProducto=" + codProducto + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", canProductos=" + canProductos + '}';
    }

}
