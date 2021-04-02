package com.istloja.modelTablas;

import com.istloja.modelo.Persona;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTablePersona extends AbstractTableModel {

    //Arreglo con el nombre de las columnas.
    private String[] m_colNames = {"CÉDULA", "NOMBRES", "APELLIDOS", "DIRECCIÓN", "CORREO", "TELÉFONO", "FECHA REGISTRO", "GENERO"};
    private List<Persona> personas;
    private GestionContable gContable;
    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;

    public ModelTablePersona(List<Persona> personas, GestionContable gContable) {
        this.personas = personas;
        this.gContable = gContable;
    }

    //Determina el numero de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return personas.size();
    }

    //Determina el numero de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = personas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return persona.getCedula();
            case 1:
                return persona.getNombres();
            case 2:
                return persona.getApellidos();
            case 3:
                return persona.getDireccion();
            case 4:
                return persona.getCorreo();
            case 5:
                return persona.getTelefono();
            case 6:
                return persona.getFecha_registro();
            case 7:
                return persona.getGenero();
            case 8:
                return persona.getFecha_nacimiento();
        }
        return new String();
    }

    //Metodo que sirve para definir los nombres de las columnas.
    @Override
    public String getColumnName(int column) {
        return m_colNames[column];

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickPersona(personas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

}
