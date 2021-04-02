package com.istloja.modelTablas;

import com.istloja.modelo.Inventario;
import com.istloja.modelo.Persona;
import com.istloja.modelo.Proveedores;
import com.istloja.modelo.TipoUsuario;

public interface ComunicacionVistaModelosTablas {

    void clickPersona(Persona p); 
    void clickProveedores(Proveedores p);
    void clickInventario(Inventario p);
    void clickTipoUsuario(TipoUsuario p);
    void clickVentas(Inventario p);
}
