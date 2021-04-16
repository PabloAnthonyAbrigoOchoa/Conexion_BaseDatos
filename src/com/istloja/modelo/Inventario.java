package com.istloja.modelo;

import java.sql.Date;

public class Inventario {

    public static Inventario get(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private int idInventario;
    private String codProducto;
    private String canProductos;
    private String descripcion;
    private double precio_compra_sin_iva;
    private double precio_compra_con_iva;
    private double precio_mayorista;
    private double precio_cliente_fijo;
    private double precio_cliente_normal;
    private Date fecha_caducidad;
    private Date fecha_registro;
    private Date fecha_actualizacion;

    private int cantidadDeProductoParaVenta;

    public int getCantidadDeProductoParaVenta() {
        return cantidadDeProductoParaVenta;
    }

    public void setCantidadDeProductoParaVenta(int cantidadDeProductoParaVenta) {
        this.cantidadDeProductoParaVenta = cantidadDeProductoParaVenta;
    }

    public Inventario(int idInventario, String codProducto, String canProductos, String descripcion, double precio_compra_sin_iva, double precio_compra_con_iva, double precio_mayorista, double precio_cliente_fijo, double precio_cliente_normal, Date fecha_caducidad, Date fecha_registro, Date fecha_actualizacion) {
        this.idInventario = idInventario;
        this.codProducto = codProducto;
        this.canProductos = canProductos;
        this.descripcion = descripcion;
        this.precio_compra_sin_iva = precio_compra_sin_iva;
        this.precio_compra_con_iva = precio_compra_con_iva;
        this.precio_mayorista = precio_mayorista;
        this.precio_cliente_fijo = precio_cliente_fijo;
        this.precio_cliente_normal = precio_cliente_normal;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_registro = fecha_registro;
        this.fecha_actualizacion = fecha_actualizacion;

    }

    public Inventario() {
    }

    public Date fechaderegistro() {
        fecha_registro = new Date(fecha_registro.getYear(), fecha_registro.getMonth(), fecha_registro.getDay());
        return fecha_registro;
    }

    public Date fechadeActualizacion() {
        fecha_actualizacion = new Date(fecha_actualizacion.getYear(), fecha_actualizacion.getMonth(), fecha_actualizacion.getDay());
        return fecha_actualizacion;
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

    public String getCanProductos() {
        return canProductos;
    }

    public void setCanProductos(String canProductos) {
        this.canProductos = canProductos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_compra_sin_iva() {
        return precio_compra_sin_iva;
    }

    public void setPrecio_compra_sin_iva(double precio_compra_sin_iva) {
        this.precio_compra_sin_iva = precio_compra_sin_iva;
    }

    public double getPrecio_compra_con_iva() {
        return precio_compra_con_iva;
    }

    public void setPrecio_compra_con_iva(double precio_compra_con_iva) {
        this.precio_compra_con_iva = precio_compra_con_iva;
    }

    public double getPrecio_mayorista() {
        return precio_mayorista;
    }

    public void setPrecio_mayorista(double precio_mayorista) {
        this.precio_mayorista = precio_mayorista;
    }

    public double getPrecio_cliente_fijo() {
        return precio_cliente_fijo;
    }

    public void setPrecio_cliente_fijo(double precio_cliente_fijo) {
        this.precio_cliente_fijo = precio_cliente_fijo;
    }

    public double getPrecio_cliente_normal() {
        return precio_cliente_normal;
    }

    public void setPrecio_cliente_normal(double precio_cliente_normal) {
        this.precio_cliente_normal = precio_cliente_normal;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idInventario=" + idInventario + ", codProducto=" + codProducto + ", canProductos=" + canProductos + ", descripcion=" + descripcion + ", precio_compra_sin_iva=" + precio_compra_sin_iva + ", precio_compra_con_iva=" + precio_compra_con_iva + ", precio_mayorista=" + precio_mayorista + ", precio_cliente_fijo=" + precio_cliente_fijo + ", precio_cliente_normal=" + precio_cliente_normal + ", fecha_caducidad=" + fecha_caducidad + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }

}
