package com.istloja.modelTablas;

import com.istloja.vistas.GestionContable;
import com.istloja.modelo.NotaVentas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableNotaVentas extends AbstractTableModel {

    private String[] m_colNames = {"CANTIDAD", "DESCRIPCIÓN", "SUBTOTAL", "TOTAL"};
    public List<NotaVentas> productoP;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;

    public ModelTableNotaVentas(List<NotaVentas> productosv, GestionContable gestionContable) {
        this.productoP = productosv;
        this.gestionContable = gestionContable;
    }

    @Override
    public int getRowCount() {
        return productoP.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NotaVentas p = productoP.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCantidadProducto();
            case 1:
                return p.getDescripcion();
            case 2:
                return p.getSubTotal();
            case 3:
                return p.getTotal();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gestionContable.clickProductoEnVentas(productoP.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
    }

    public List<NotaVentas> getProductov() {
        return productoP;
    }

    public void setProductov(List<NotaVentas> productov) {
        this.productoP = productov;
    }
}
