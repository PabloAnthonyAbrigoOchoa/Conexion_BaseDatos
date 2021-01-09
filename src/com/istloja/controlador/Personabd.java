package com.istloja.controlador;

import com.istloja.modelo.Persona;
import java.sql.Connection;
import java.sql.Statement;
import conexionBaseDatos.Conexion;
import java.sql.SQLException;

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
        boolean actualizar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `bdejercicio1`.`persona` SET `nombres` = 'Karen', `apellidos` = 'Ochoa', `telefono` = '998756224' WHERE (`idpersona` = '2');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            actualizar = true;
            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    public boolean eliminarPersona(Persona persona) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `bdejercicio1`.`persona` WHERE (`idpersona` = '2');";
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
}
