package com.istloja.modelTablas;

import com.istloja.modelo.Inventario;
import com.istloja.modelo.Proveedores;
import com.istloja.vistas.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableInventario extends AbstractTableModel {

    //Arreglo con el nombre de las columnas.
    private String[] m_colNames = {"CÓDIGO PRO", "DESCRIPCIÓN", "PRECIOS COMPRA", "PRECIO VENTA", "CAN PRODUCTOS"};
    private List<Inventario> inventario;
    private GestionContable gContable;

    public ModelTableInventario(List<Inventario> inventario, GestionContable gContable) {
        this.inventario = inventario;
        this.gContable = gContable;
    }

    //Determina el numero de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return inventario.size();
    }

    //Determina el numero de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario producto = inventario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getCódigoPro();
            case 1:
                return producto.getDescripción();
            case 2:
                return producto.getPreciosCompra();
            case 3:
                return producto.getPrecioVenta();
            case 4:
                return producto.getCanProductos();
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
        gContable.clickInventario(inventario.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Inventario> getInventario() {
        return inventario;
    }

    public void setInventario(List<Inventario> inventario) {
        this.inventario = inventario;
    }

}
