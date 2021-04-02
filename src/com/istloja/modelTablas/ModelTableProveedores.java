package com.istloja.modelTablas;

import com.istloja.modelo.Proveedores;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableProveedores extends AbstractTableModel {

    //Arreglo con el nombre de las columnas.
    private String[] m_colNames = {"RUC", "RAZON SOCIAL", "TIPO ACTIVIDAS", "NOMBRE REPRESENTANTE LEGAL", "APELLIDO REPRESENTANTE LEGAL", "TELEFONO", "CORREO", "DIRECCION", "FECHA_REGISTRO"};
    private List<Proveedores> proveedores;
    private GestionContable gContable;
    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestionContable gestionContable;

    public ModelTableProveedores(List<Proveedores> proveedores, GestionContable gContable) {
        this.proveedores = proveedores;
        this.gContable = gContable;
    }

    //Determina el numero de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return proveedores.size();
    }

    //Determina el numero de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedores proveedor = proveedores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return proveedor.getRuc();
            case 1:
                return proveedor.getRazonSocial();
            case 2:
                return proveedor.getTipoActividad();
            case 3:
                return proveedor.getNombreRepresentanteLegal();
            case 4:
                return proveedor.getApellidoRepresentanteLegal();
            case 5:
                return proveedor.getTelefono();
            case 6:
                return proveedor.getCorreo();
            case 7:
                return proveedor.getDireccion();
            case 8:
                return proveedor.getFechaVencimientoDeuda();
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
        gContable.clickProveedores(proveedores.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

}
