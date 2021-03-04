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
        String sql = "INSERT INTO `bdejercicio1`.`inventario` (`cod_producto`, `descripcion`, `precio_compra`, `precio_venta`, `can_producto`) VALUES ('"+inventario.getCodProducto()+"', '"+inventario.getDescripcion()+"', '"+inventario.getPrecioCompra()+"', '"+inventario.getPrecioVenta()+"', '"+inventario.getCanProductos()+"');";
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
        System.out.println("Actualizar:" +inventario);
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `cod_producto` = '"+inventario.getCodProducto()+"', `descripcion` = '"+inventario.getDescripcion()+"', `precio_compra` = '"+inventario.getPrecioCompra()+"', `precio_venta` = '"+inventario.getPrecioVenta()+"', `can_producto` = '"+inventario.getCanProductos()+"' WHERE (`idinventario` = '"+inventario.getIdInventario()+"');";
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
        String sql = "DELETE FROM `bdejercicio1`.`inventario` WHERE (`idinventario` = '"+inventario.getIdInventario()+"');";
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
                c.setDescripcion(rs.getString(3));
                c.setPrecioCompra(rs.getString(4));
                c.setPrecioVenta(rs.getString(5));
                c.setCanProductos(rs.getString(6));
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
        List<Inventario> listaInventario= new ArrayList<Inventario>();
        String sql = "SELECT * FROM bdejercicio1.inventario where cod_producto like '"+codigo+"';";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               Inventario c = new Inventario();
                c.setIdInventario(rs.getInt(1));
                c.setCodProducto(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecioCompra(rs.getString(4));
                c.setPrecioVenta(rs.getString(5));
                c.setCanProductos(rs.getString(6));
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
        List<Inventario> listaInventario= new ArrayList<Inventario>();
        String sql = "SELECT * FROM bdejercicio1.inventario where descripcion like \"%"+descripcion+"%\"";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               Inventario c = new Inventario();
                c.setIdInventario(rs.getInt(1));
                c.setCodProducto(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecioCompra(rs.getString(4));
                c.setPrecioVenta(rs.getString(5));
                c.setCanProductos(rs.getString(6));
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
