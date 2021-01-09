package com.istloja.conexionbd;

import com.istloja.controlador.Personabd;
import java.sql.SQLException;
import com.istloja.modelo.Persona;

public class Main_Conexion {

    public static void main(String[] args) throws SQLException {
        Personabd personabd = new Personabd();
        Persona persona = new Persona();
        persona.setIdPersona(3);
        persona.setCedula("1106049925");
        persona.setNombres("Anthony");
        persona.setApellidos("Ochoa");
        persona.setDireccion("Ciudad Victoria");
        persona.setCorreo("anthochoa69@gmail.com");
        persona.setTelefono(994941403);
        if (personabd.registrarPersona(persona)) {
            System.out.println("Persona guardada en la base de datos");

        } else {
            System.out.println("Error al guardar los datos");

        }
////////////////////////////////////////////////////////////////////////////////
        Personabd personabd1 = new Personabd();
        Persona persona1 = new Persona();
        persona1.setIdPersona(4);
        persona1.setCedula("1106049925");
        persona1.setNombres("Anthony");
        persona1.setApellidos("Ochoa");
        persona1.setDireccion("Ciudad Victoria");
        persona1.setCorreo("anthochoa69@gmail.com");
        persona1.setTelefono(994941404);
        if (personabd1.actualizarPersona(persona1)) {
            System.out.println("Persona actualizada en la base de datos");

        } else {
            System.out.println("Error al actualizar los datos");

        }
////////////////////////////////////////////////////////////////////////////////        
        Personabd personabd2 = new Personabd();
        Persona persona2 = new Persona();
        persona2.setIdPersona(2);
        persona2.setCedula("1106049925");
        persona2.setNombres("Karen");
        persona2.setApellidos("Ochoa");
        persona2.setDireccion("Ciudad Victoria");
        persona2.setCorreo("anthochoa69@gmail.com");
        persona2.setTelefono(998756224);
        if (personabd2.eliminarPersona(persona2)) {
            System.out.println("Persona eliminada en la base de datos");

        } else {
            System.out.println("Error al eliminar los datos");

        }

    }
}
