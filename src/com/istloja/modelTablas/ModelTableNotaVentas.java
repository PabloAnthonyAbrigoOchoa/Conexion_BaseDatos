package com.istloja.modelTablas;

import com.istloja.vistas.GestionContable;
import java.util.List;
import com.istloja.modelo.NotaVentas;
import javax.swing.table.AbstractTableModel;

public class ModelTableNotaVentas extends AbstractTableModel {

    private String[] m_colNames = {"CANTIDAD", "DESCRIPCIÓN", "SUBTOTAL", "TOTAL"};
    private List<NotaVentas> ventas;
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
        NotaVentas ventas = this.ventas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ventas.getIdNotaVenta();
            case 1:
                return ventas.getNumeroNotaVenta();
            case 2:
                return ventas.getPersonaIdPersona();
            case 3:
                return ventas.getFechaVenta();
            case 4:
                return ventas.getSubTotal();
            case 5:
                return ventas.getIva();
            case 6:
                return ventas.getTotalVenta();
            case 7:
                return ventas.getTipoPago();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];

    }
}
