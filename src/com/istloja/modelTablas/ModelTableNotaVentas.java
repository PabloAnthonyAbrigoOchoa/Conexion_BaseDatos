package com.istloja.modelTablas;

import com.istloja.modelo.Inventario;
import com.istloja.vistas.GestionContable;
import java.util.List;
import com.istloja.modelo.NotaVentas;
import javax.swing.table.AbstractTableModel;

public class ModelTableNotaVentas extends AbstractTableModel {

    private String[] m_colNames = {"CANTIDAD", "DESCRIPCIÓN", "SUBTOTAL", "TOTAL"};
    private List<NotaVentas> ventas;
    private GestionContable gContable;
    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;

    public ModelTableNotaVentas(List<Inventario> obtenerProductosInventario, GestionContable aThis) {

    }

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
        Inventario inventarios = Inventario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gestionContable.cantidadproductoVenta();
            case 1:
                return inventarios.getDescripcion();
            case 2:
                return inventarios.getPrecio_cliente_normal();
            case 3:
                return gestionContable.cantidadproductoVenta() * inventarios.getPrecio_cliente_normal();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];

    }
}
