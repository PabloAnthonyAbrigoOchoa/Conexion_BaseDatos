package com.istloja.controlador;

import com.istloja.modelo.Inventario;
import conexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Inventariodb {

    //Crear producto en la Base de Datos
    public boolean crearProducto(Inventario inventario) {
        boolean crear = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `bdejercicio1`.`inventario` (`cod_producto`, `can_producto`, `descripcion`, `precio_compra_sin_iva`, `precio_compra_con_iva`, `precio_mayorita`, `precio_cliente_fijo`, `precio_cliente_normal`, `fecha_caducidad`, `fecha_registro`, `fecha_actualizacion`) VALUES ('" + String.valueOf(inventario.getIdInventario()) + "', '" + String.valueOf(inventario.getCanProductos()) + "', '" + String.valueOf(inventario.getDescripcion()) + "', '" + String.valueOf(inventario.getPrecio_compra_sin_iva()) + "', '" + String.valueOf(inventario.getPrecio_compra_con_iva()) + "', '" + String.valueOf(inventario.getPrecio_mayorista()) + "', '" + String.valueOf(inventario.getPrecio_cliente_fijo()) + "', '" + String.valueOf(inventario.getPrecio_cliente_normal()) + "', '" + String.valueOf(inventario.getFecha_caducidad()) + "', '" + String.valueOf(inventario.getFecha_registro()) + "', '" + String.valueOf(inventario.getFecha_actualizacion()) + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            crear = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return crear;

    }

    //Editar producto en la Base de Datos
    public boolean editarProducto(Inventario inventario) {
        System.out.println("Actualizar:" + inventario);
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `cod_producto` = '" + inventario.getCodProducto() + "', `can_producto` = '" + inventario.getCanProductos() + "', `descripcion` = '" + inventario.getDescripcion() + "', `precio_compra_sin_iva` = '" + inventario.getPrecio_compra_sin_iva() + "', `precio_compra_con_iva` = '" + inventario.getPrecio_compra_con_iva() + "', `precio_mayorita` = '" + inventario.getPrecio_mayorista() + "', `precio_cliente_fijo` = '" + inventario.getPrecio_cliente_fijo() + "', `precio_cliente_normal` = '" + inventario.getPrecio_cliente_normal() + "', `fecha_caducidad` = '" + inventario.getFecha_caducidad() + "', `fecha_registro` = '" + inventario.getFecha_registro() + "', `fecha_actualizacion` = '" + inventario.getFecha_actualizacion() + "' WHERE (`idinventario` = '" + inventario.getIdInventario() + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            editar = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return editar;
    }

    //Eliminar una producto de la Base de Datos
    public boolean eliminarProducto(Inventario inventario) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `bdejercicio1`.`inventario` WHERE (`idinventario` = '" + inventario.getIdInventario() + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            eliminar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }

    public List<Inventario> obtenerProductosInventario() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.inventario;";
        List<Inventario> listaProveedores = new ArrayList<Inventario>();
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setIdInventario(rs.getInt(1));
                c.setCodProducto(rs.getString(2));
                c.setCanProductos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                listaProveedores.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaProveedores;

    }

    public List<Inventario> obtenerProductosInventariosCodigo(String codigo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        String sql = "SELECT * FROM bdejercicio1.inventario where cod_producto like '" + codigo + "';";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setIdInventario(rs.getInt(1));
                c.setCodProducto(rs.getString(2));
                c.setCanProductos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                listaInventario.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaInventario;
    }

    public List<Inventario> obtenerProductosInventariosDescripcion(String descripcion) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        String sql = "SELECT * FROM bdejercicio1.inventario where descripcion like \"%" + descripcion + "%\"";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setIdInventario(rs.getInt(1));
                c.setCodProducto(rs.getString(2));
                c.setCanProductos(rs.getString(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio_compra_sin_iva(rs.getDouble(5));
                c.setPrecio_compra_con_iva(rs.getDouble(6));
                c.setPrecio_mayorista(rs.getDouble(7));
                c.setPrecio_cliente_fijo(rs.getDouble(8));
                c.setPrecio_cliente_normal(rs.getDouble(9));
                c.setFecha_caducidad(rs.getDate(10));
                c.setFecha_registro(rs.getDate(11));
                c.setFecha_actualizacion(rs.getDate(12));
                listaInventario.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaInventario;
    }
}
