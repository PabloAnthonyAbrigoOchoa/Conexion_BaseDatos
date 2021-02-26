package com.istloja.modelTablas;

import com.istloja.modelo.Inventario;
import com.istloja.modelo.Persona;
import com.istloja.modelo.Proveedores;

public interface ComunicacionVistaModelosTablas {

    void clickPersona(Persona p); 
    void clickProveedores(Proveedores p);
    void clickInventario(Inventario p);
}
