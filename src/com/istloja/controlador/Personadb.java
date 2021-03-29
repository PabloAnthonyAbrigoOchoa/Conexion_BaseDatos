package com.istloja.controlador;

import com.istloja.modelo.Persona;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.Statement;
import conexionBaseDatos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Gestion entre la base de datos y el modelo que se tiene implentado en java
public class Personadb {

    public Utilidades utilidades;

    public Personadb() {
        utilidades = new Utilidades();
    }

    //Registrar persona en la Base de Datos
    public boolean registrarPersona(Persona persona) {
        boolean registrar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql;
        if (persona.getFecha_nacimiento() == null) {
            sql = "INSERT INTO `bdejercicio1`.`persona` (`idpersona`, `cedula`, `nombres`, `apellidos`, `direccion`, `correo`, `telefono`,`fecha_registro`,`genero`)VALUES ('" + String.valueOf(persona.getIdPersona()) + "', '" + persona.getCedula() + "', '" + persona.getNombres() + "', '" + persona.getApellidos() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "','" + utilidades.devolverFecha(persona.getFecha_registro()) + "','" + persona.getGenero() + "';";
        } else {
            sql = "INSERT INTO `bdejercicio1`.`persona` (`idpersona`, `cedula`, `nombres`, `apellidos`, `direccion`, `correo`, `telefono`,`fecha_registro`,`genero`,`fecha_nacimiento`)VALUES ('" + String.valueOf(persona.getIdPersona()) + "', '" + persona.getCedula() + "', '" + persona.getNombres() + "', '" + persona.getApellidos() + "', '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "','" + utilidades.devolverFecha(persona.getFecha_registro()) + "','" + persona.getGenero() + "','" + utilidades.devolverFecha(persona.getFecha_nacimiento()) + "');";
        }
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
    public boolean actualizarPersona(Persona persona) {
        boolean actualizar = false;//Retorno del metodo cuando se realice la actualizacion
        Statement stm = null;//Interfaz de acceso a la BD
        Connection con = null;//Conexion con la BD
        //Concatenando la opcion de actualizacion
        String sql = "UPDATE `bdejercicio1`.`persona` SET `cedula` = '" + persona.getCedula() + "', `nombres` = '" + persona.getNombres() + "', `apellidos` = '" + persona.getApellidos() + "', `direccion` = '" + persona.getDireccion() + "', `correo` = '" + persona.getCorreo() + "', `telefono` = '" + persona.getTelefono() + "',`fecha_registro` = '" + persona.getFecha_registro() + "',`genero` = '" + persona.getGenero() + "', `fecha_actualizacion` = '" + utilidades.devolverFecha(persona.getFecha_actualizacion()) + "' WHERE (`idpersona` = '" + persona.getIdPersona() + "');";
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

    //Sirve para traer todos los registros de las personas de la Base de Datos
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
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFecha_actualizacion(rs.getDate(10));
                c.setFecha_nacimiento(rs.getDate(11));
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

    //Metodo para buscar personas por cedula
    public Persona getPersonaCedula(String cedula) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona where cedula like " + cedula + "";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFecha_actualizacion(rs.getDate(10));
                c.setFecha_nacimiento(rs.getDate(11));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
    }

    //Metodo para buscar personas por apellidos
    public Persona getBuscarApellido(String apellidos) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        Persona a = null;
        String sql = "SELECT * FROM bdejercicio1.persona where apellidos like '" + apellidos + "';";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                a = new Persona();
                a.setIdPersona(rs.getInt(1));
                a.setCedula(rs.getString(2));
                a.setNombres(rs.getString(3));
                a.setApellidos(rs.getString(4));
                a.setDireccion(rs.getString(5));
                a.setCorreo(rs.getString(6));
                a.setTelefono(rs.getString(7));
                a.setFecha_registro(rs.getDate(8));
                a.setGenero(rs.getInt(9));
                a.setFecha_actualizacion(rs.getDate(10));
                a.setFecha_nacimiento(rs.getDate(11));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return a;
    }

    //Metodo para buscar personas por numero de telefono
    public Persona getBuscarTelefono(String telefono) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        Persona t = null;
        String sql = "SELECT * FROM bdejercicio1.persona where telefono like " + telefono + "";
        try {
            con = new Conexion().conectarBaseDatos();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                t = new Persona();
                t.setIdPersona(rs.getInt(1));
                t.setCedula(rs.getString(2));
                t.setNombres(rs.getString(3));
                t.setApellidos(rs.getString(4));
                t.setDireccion(rs.getString(5));
                t.setCorreo(rs.getString(6));
                t.setTelefono(rs.getString(7));
                t.setFecha_registro(rs.getDate(8));
                t.setGenero(rs.getInt(9));
                t.setFecha_actualizacion(rs.getDate(10));
                t.setFecha_nacimiento(rs.getDate(11));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return t;
    }

    //Metodo para buscar personas por nombre
    public List<Persona> getPersonaNombre(String nombre) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;//Sentencia del JDBC para obtener valores de la BD
        List<Persona> personasEncontradas = new ArrayList<>();
        String parametroBusqueda = "%" + nombre + "%";
        String sql = "SELECT * FROM bdejercicio1.persona where nombres like \"%" + nombre + "%\"";
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
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getInt(9));
                c.setFecha_actualizacion(rs.getDate(10));
                c.setFecha_nacimiento(rs.getDate(11));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }
}
