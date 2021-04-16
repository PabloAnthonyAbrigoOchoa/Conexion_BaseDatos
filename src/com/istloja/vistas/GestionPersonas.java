package com.istloja.vistas;

import com.istloja.modelo.Persona;
import com.istloja.utilidad.Utilidades;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionPersonas {

    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private Utilidades utilidades;
    private JFrame frameGestionContable;
    private JComboBox jcbGenero;

    public GestionPersonas(JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtDireccion, JTextField txtTelefono, JTextField txtCorreo, Utilidades utilidades, JFrame frameGestionContable, JComboBox jcbGenero) {
        this.txtCedula = txtCedula;
        this.txtNombres = txtNombres;
        this.txtApellidos = txtApellidos;
        this.txtDireccion = txtDireccion;
        this.txtTelefono = txtTelefono;
        this.txtCorreo = txtCorreo;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
        this.jcbGenero = jcbGenero;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public void limpiarCamposPersona() {
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtCedula.requestFocus();
        jcbGenero.setSelectedIndex(0);
    }

    public Persona guardarEditar(boolean isEditar) {
        if (txtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Cédula no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCedula.requestFocus();//Sirve para ubicar el cursor en un campo vacio
            return null;
        }
        if (!utilidades.validadorDeCedula(txtCedula.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "La cédula ingresada no es valida.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (txtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Nombres no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombres.requestFocus();
            return null;
        }
        if (txtApellidos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Apellidos no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtApellidos.requestFocus();
            return null;
        }
        if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Dirección no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDireccion.requestFocus();
            return null;
        }
        if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Telefono no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return null;
        }
        if (!utilidades.validarNumero(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "Los datos ingresados en el telefono no son validos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return null;

        }
        if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Correo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return null;
        }
        if (!utilidades.validarCorreo(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "El correo ingresado no es valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return null;
        }
        Persona persona = new Persona();
        persona.setCedula(txtCedula.getText());
        persona.setNombres(txtNombres.getText());
        persona.setApellidos(txtApellidos.getText());
        persona.setDireccion(txtDireccion.getText());
        persona.setCorreo(txtCorreo.getText());
        persona.setTelefono(Integer.parseInt(txtTelefono.getText()));
        persona.setGenero(jcbGenero.getSelectedIndex());

        if (isEditar) {
            persona.setFecha_actualizacion(new Date(0));
        } else {
            persona.setFecha_registro(new Date(0));
        }
        return persona;
    }
}
