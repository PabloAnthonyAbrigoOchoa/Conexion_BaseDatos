package com.istloja.modelo;

public class TipoUsuario {

    private int tipoUsuario;
    private int tipoUsuarioSistema;
    private int idPersonaSistema;
    private String contraseña;

    public TipoUsuario(int tipoUsuario, int tipoUsuarioSistema, int idPersonaSistema, String contraseña) {
        this.tipoUsuario = tipoUsuario;
        this.tipoUsuarioSistema = tipoUsuarioSistema;
        this.idPersonaSistema = idPersonaSistema;
        this.contraseña = contraseña;
    }

    public TipoUsuario() {
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoUsuarioSistema() {
        return tipoUsuarioSistema;
    }

    public void setTipoUsuarioSistema(int tipoUsuarioSistema) {
        this.tipoUsuarioSistema = tipoUsuarioSistema;
    }

    public int getIdPersonaSistema() {
        return idPersonaSistema;
    }

    public void setIdPersonaSistema(int idPersonaSistema) {
        this.idPersonaSistema = idPersonaSistema;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "tipoUsuario=" + tipoUsuario + ", tipoUsuarioSistema=" + tipoUsuarioSistema + ", idPersonaSistema=" + idPersonaSistema + ", contrase\u00f1a=" + contraseña + '}';
    }

}
