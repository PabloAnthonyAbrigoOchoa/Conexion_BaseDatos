package com.istloja.modelTablas;

import com.istloja.vistas.GestionContable;
import java.util.List;
import com.istloja.modelo.Ventas;
import javax.swing.table.AbstractTableModel;

public class ModelTableVentas extends AbstractTableModel {

    private String[] m_colNames = {"CANTIDAD", "CODIGO", "DESCRIPCIÓN", "PRECIO UNITARIO", "TOTAL"};
    private List<Ventas> ventas;
    private GestionContable gContable;

    @Override
    public int getRowCount() {
        return ventas.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ventas ventas = this.ventas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ventas.getIdVentas();
            case 1:
                return ventas.getCedula();
            case 2:
                return ventas.getNombre();
            case 3:
                return ventas.getDireccion();
            case 4:
                return ventas.getCiudad();
            case 5:
                return ventas.getCp();
            case 6:
                return ventas.getTelefono();
            case 7:
                return ventas.getFecha();
            case 8:
                return ventas.getCondicionesPago();

        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];

    }
}
