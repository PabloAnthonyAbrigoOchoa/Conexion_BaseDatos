package com.istloja.modelTablas;

import com.istloja.modelo.Inventario;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableInventario extends AbstractTableModel {

    //Arreglo con el nombre de las columnas.
    private String[] m_colNames = {"COD PRODUCTO", "CAN PRODUCTO", "DESCRIPCIÓN", "PRECIO COMPRA SIN IVA", "PRECIO COMPRA CON IVA", "PRECIO MAYORISTA", "PRECIO CLIENTE FIJO", "PRECIO CLIENTE NORMAL", "FECHA CADUCIDAD", "FECHA REGISTRO", "FECHA ACTUALIZACION",};
    private List<Inventario> inventarios;
    private GestionContable gContable;

    public ModelTableInventario(List<Inventario> inventarios, GestionContable gContable) {
        this.inventarios = inventarios;
        this.gContable = gContable;
    }

    //Determina el numero de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return inventarios.size();
    }

    //Determina el numero de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario producto = inventarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getCodProducto();
            case 1:
                return producto.getCanProductos();
            case 2:
                return producto.getDescripcion();
            case 3:
                return producto.getPrecio_compra_sin_iva();
            case 4:
                return producto.getPrecio_compra_con_iva();
            case 5:
                return producto.getPrecio_mayorista();
            case 6:
                return producto.getPrecio_cliente_fijo();
            case 7:
                return producto.getPrecio_cliente_normal();
            case 8:
                return producto.getFecha_caducidad();
            case 9:
                return producto.getFecha_registro();
            case 10:
                return producto.getFecha_actualizacion();
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
        gContable.clickInventario(inventarios.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Inventario> getInventario() {
        return inventarios;
    }

    public void setInventario(List<Inventario> inventario) {
        this.inventarios = inventario;
    }

}
