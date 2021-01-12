package com.istloja.conexionbd;

import com.istloja.controlador.Personabd;
import java.sql.SQLException;
import com.istloja.modelo.Persona;
import com.istloja.vistas.GestionPersonas;

public class Main_Conexion {

    public static void main(String[] args) throws SQLException {
//        Personabd personabd = new Personabd();
//        System.out.println("PERSONAS: " +personabd.obtenerPersonas());
//        Persona persona = new Persona(6, "1103570485", "Maria", "Rocafuerte", "Argelia", "mari123@gmail.com", 997779409);
//        if (personabd.registrarPersona(persona)) {
//            System.out.println("Persona guardada en la base de datos");
//        } else {
//            System.out.println("Error al guardar los datos");
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if (personabd.actualizarPersona(persona)) {
//            System.out.println("Persona actualizada en la base de datos");
//        } else {
//            System.out.println("Error al actualizar los datos");
//        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//        if (personabd.eliminarPersona(persona)) {
//            System.out.println("Persona eliminada en la base de datos");
//        } else {
//            System.out.println("Error al eliminar los datos");
//        }
          GestionPersonas gestionPersona = new GestionPersonas();
    }
    

}
