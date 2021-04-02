package com.istloja.controlador;

import com.istloja.modelo.Proveedores;
import com.istloja.utilidad.Utilidades;
import conexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Proveedoresdb {

    public Utilidades utilidades;

    public Proveedoresdb() {
        utilidades = new Utilidades();
    }

    public boolean registrarProveedor(Proveedores proveedor) {
        boolean registrar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = "INSERT INTO `bdejercicio1`.`proveedores` (`ruc`, `razon_social`, `tipo_actividad`, `nombre_representante_legal`, `apellido_representante_legal`, `telefono`, `correo`,`direccion`,`fecha_registro`,`fecha_vencimiento_deuda`) VALUES ('" + proveedor.getRuc() + "', '" + proveedor.getRazonSocial() + "', '" + proveedor.getTipoActividad() + "', '" + proveedor.getNombreRepresentanteLegal() + "', '" + proveedor.getApellidoRepresentanteLegal() + "', '" + proveedor.getTelefono() + "', '" + proveedor.getCorreo() + "','" + proveedor.getDireccion() + "','" + proveedor.getFecha_registro() + "','" + proveedor.getFechaVencimientoDeuda() + "')";
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

    //Actualizar proveedor en la Base de Datos
    public boolean actualizarProveedor(Proveedores proveedor) {
        boolean actualizar = false;//Retorno del metodo cuando se realice la actualizacion
        Statement stm = null;//Interfaz de acceso a la BD
        Connection con = null;//Conexion con la BD
        //Concatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`proveedores` SET `ruc` = '" + proveedor.getRuc() + "', `razon_social` = '" + proveedor.getRazonSocial() + "', `tipo_actividad` = '" + proveedor.getTipoActividad() + "', `nombre_representante_legal` = '" + proveedor.getNombreRepresentanteLegal() + "', `apellido_representante_legal` = '" + proveedor.getApellidoRepresentanteLegal() + "', `telefono` = '" + proveedor.getTelefono() + "', `correo` = '" + proveedor.getCorreo() + "',`direccion` = '" + proveedor.getDireccion() + "',`fecha_registro` = '" + proveedor.getFecha_registro() + "',`fecha_vencimiento_deuda` = '" + proveedor.getFechaVencimientoDeuda() + "' WHERE (`idproveedores` = '" + proveedor.getIdProveedores() + "');";
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

    //Eliminar una proveedor en al ID de la persona seleccionada de la Base de Datos
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
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaVencimientoDeuda(rs.getDate(11));
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

    public List<Proveedores> ObtenerProveedoresRucLista(String ruc) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.proveedores where ruc like '%" + ruc + "%';";
        List<Proveedores> listaProveedores = new ArrayList<>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
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
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaVencimientoDeuda(rs.getDate(11));
                listaProveedores.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaProveedores;
    }

    public List<Proveedores> ObtenerProveedoresTelefono(String telefono) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.proveedores where telefono like '%" + telefono + "%';";
        List<Proveedores> listaProveedores = new ArrayList<>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
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
                c.setDireccion(rs.getString(9));
                c.setFecha_registro(rs.getDate(10));
                c.setFechaVencimientoDeuda(rs.getDate(11));
                listaProveedores.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaProveedores;
    }

}
