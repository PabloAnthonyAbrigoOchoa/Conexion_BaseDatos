package com.istloja.controlador;

import com.istloja.modelo.Inventario;
import conexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventariobd {
    //Crear producto en la Base de Datos
    public boolean crearProducto(Inventario inventario) {
        boolean crear = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `bdejercicio1`.`inventario` (`código_pro`, `descripción`, `precios_compra`, `precio_venta`, `can_productos`) VALUES ('"+inventario.getCódigoPro()+"', '"+inventario.getDescripción()+"', '"+inventario.getPreciosCompra()+"', '"+inventario.getPrecioVenta()+"', '"+inventario.getCanProductos()+"');";
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
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `código_pro` = '"+inventario.getCódigoPro()+"', `descripción` = '"+inventario.getDescripción()+"', `precios_compra` = '"+inventario.getPreciosCompra()+"', `precio_venta` = '"+inventario.getPrecioVenta()+"', `can_productos` = '"+inventario.getCanProductos()+"' WHERE (`idinventario` = '"+inventario.getIdInventario()+"');";
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
        //String.valueOf para hacer castin de un valor Entero a un String
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

//    public List<Proveedores> obtenerProveedores() {
//        Connection con = null;
//        Statement stm = null;
//        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
//        String sql = "SELECT * FROM bdejercicio1.proveedores;";
//        List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
//        try {
//            con = new Conexion().conectarBaseDatos();
//            stm = con.createStatement();
//            rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Proveedores c = new Proveedores();
//                c.setIdProveedores(rs.getInt(1));
//                c.setRuc(rs.getString(2));
//                c.setRazonSocial(rs.getString(3));
//                c.setTipoActividad(rs.getString(4));
//                c.setNombreRepresentanteLegal(rs.getString(5));
//                c.setApellidoRepresentanteLegal(rs.getString(6));
//                c.setTelefono(rs.getString(7));
//                c.setCorreo(rs.getString(8));
//                listaProveedores.add(c);
//            }
//            stm.close();
//            rs.close();
//            con.close();
//        } catch (Exception e) {
//            System.out.println("Error:" + e.getMessage());
//        }
//
//        return listaProveedores;
//
//    }

    

}
