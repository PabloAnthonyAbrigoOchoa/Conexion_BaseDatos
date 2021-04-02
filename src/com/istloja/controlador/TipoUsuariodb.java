package com.istloja.controlador;

import com.istloja.modelo.TipoUsuario;
import conexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuariodb {

    //Registramos un tipoUsuario en la BD
    public boolean registrarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean registrar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = "INSERT INTO `bdejercicio1`.`tipo_usuario` (`tipo_usuario_sistema`, `id_persona_sistema`, `contraseña`) VALUES ('" + tipoUsuario.getIdPersonaSistema() + "', '" + tipoUsuario.getIdPersonaSistema() + "', '" + tipoUsuario.getIdPersonaSistema() + "');";
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
        return false;

    }
    //Editamos o actualizamos un tipoUsuario en la BD
    public boolean actualizarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean actualizar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = "UPDATE `bdejercicio1`.`tipo_usuario` SET `tipo_usuario_sistema` = '" + tipoUsuario.getTipoUsuarioSistema() + "', `id_persona_sistema` = '" + tipoUsuario.getIdPersonaSistema() + "', `contraseña` = '" + tipoUsuario.getContraseña() + "' WHERE (`idtipo_usuario` = '" + tipoUsuario.getTipoUsuario() + "');";
        try {
            //Instancia de la conexion previamente creada
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            actualizar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;

    }
    //Eliminamos un tipoUsuario en la BD
    public boolean eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean eliminar = false;
        Statement stm = null;//Interfaz de acceso a la base de datos
        Connection con = null;//COnexion con la base de datos
        String sql = " DELETE FROM `bdejercicio1`.`tipo_usuario` WHERE (`idtipo_usuario` = '" + tipoUsuario.getTipoUsuario() + "');";
        try {
            //Instancia de la conexion previamente creada
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            eliminar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;

    }
    public List<TipoUsuario> ObtenerUsuarios() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from bdejercicio1.tipo_usuario;";
        List<TipoUsuario> listaPersonas = new ArrayList<TipoUsuario>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                TipoUsuario c = new TipoUsuario();
                c.setTipoUsuarioSistema(rs.getInt(1));
                c.setTipoUsuarioSistema(rs.getInt(2));
                c.setIdPersonaSistema(rs.getInt(3));
                c.setContraseña(rs.getString(4));
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPersonas;
    }
}
