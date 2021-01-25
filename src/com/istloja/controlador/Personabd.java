package com.istloja.controlador;

import com.istloja.modelo.Persona;
import java.sql.Connection;
import java.sql.Statement;
import conexionBaseDatos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personabd {

    public boolean registrarPersona(Persona persona) {
        boolean registrar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = "INSERT INTO `bdejercicio1`.`persona` (`idpersona`, `cedula`, `nombres`, `apellidos`, `direccion`, `correo`, `telefono`)VALUES ('" + String.valueOf(persona.getIdPersona()) + "', '" + persona.getCedula() + "', '" + persona.getNombres() + "', '" + persona.getApellidos() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "');";
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

    public boolean actualizarPersona(Persona persona) {
        boolean actualizar = false;//Retorno del metodo cuando se realice la actualizacion
        Statement stm = null;//Interfaz de acceso a la BD
        Connection con = null;//Conexion con la BD
        //Concatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`persona` SET `cedula` = '" + persona.getCedula() + "', `nombres` = '" + persona.getNombres() + "', `apellidos` = '" + persona.getApellidos() + "', `direccion` = '" + persona.getDireccion() + "', `correo` = '" + persona.getCorreo() + "', `telefono` = '" + persona.getTelefono() + "' WHERE (`idpersona` = '" + persona.getIdPersona() + "');";
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

    public boolean eliminarPersona(Persona persona) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `bdejercicio1`.`persona` WHERE (`idpersona` = '" + String.valueOf(persona.getIdPersona()) + "');";
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

    public List<Persona> obtenerPersonas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        String sql = "SELECT * FROM bdejercicio1.persona;";
        List<Persona> listaPersonas = new ArrayList<Persona>();
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPersonas;

    }
}
