package com.istloja.controlador;

import com.istloja.modelo.Proveedores;
import conexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Proveedoresdb {

    public boolean registrarProveedor(Proveedores proveedor) {
        boolean registrar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = "INSERT INTO `bdejercicio1`.`proveedores` (`ruc`, `razon_social`, `tipo_actividad`, `nombre_representante_legal`, `apellido_representante_legal`, `telefono`, `correo`) VALUES ('" + proveedor.getRuc() + "', '" + proveedor.getRazonSocial() + "', '" + proveedor.getTipoActividad() + "', '" + proveedor.getNombreRepresentanteLegal() + "', '" + proveedor.getApellidoRepresentanteLegal() + "', '" + proveedor.getTelefono() + "', '" + proveedor.getCorreo() + "')";
        try {
            //Instancia de la conexion previamente creada
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;

    }

    //Actualizar persona en la Base de Datos
    public boolean actualizarProveedor(Proveedores proveedor) {
        boolean actualizar = false;//Retorno del metodo cuando se realice la actualizacion
        Statement stm = null;//Interfaz de acceso a la BD
        Connection con = null;//Conexion con la BD
        //Concatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`proveedores` SET `ruc` = '" + proveedor.getRuc() + "', `razon_social` = '" + proveedor.getRazonSocial() + "', `tipo_actividad` = '" + proveedor.getTipoActividad() + "', `nombre_representante_legal` = '" + proveedor.getNombreRepresentanteLegal() + "', `apellido_representante_legal` = '" + proveedor.getApellidoRepresentanteLegal() + "', `telefono` = '" + proveedor.getTelefono() + "', `correo` = '" + proveedor.getCorreo() + "' WHERE (`idproveedores` = '" + proveedor.getIdProveedores() + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();//Puente entre la conexion y el codigo
            stm.execute(sql);
            actualizar = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    //Eliminar una persona en al ID de la persona seleccionada de la Base de Datos
    public boolean eliminarProveedor(Proveedores proveedor) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `bdejercicio1`.`proveedores` WHERE (`idproveedores` = '" + proveedor.getIdProveedores() + "');";
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

    public List<Proveedores> obtenerProveedores() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        String sql = "SELECT * FROM bdejercicio1.proveedores;";
        List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedores c = new Proveedores();
                c.setIdProveedores(rs.getInt(1));
                c.setRuc(rs.getString(2));
                c.setRazonSocial(rs.getString(3));
                c.setTipoActividad(rs.getString(4));
                c.setNombreRepresentanteLegal(rs.getString(5));
                c.setApellidoRepresentanteLegal(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
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

}
