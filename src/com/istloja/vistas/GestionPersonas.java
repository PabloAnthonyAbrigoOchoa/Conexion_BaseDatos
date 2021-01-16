package com.istloja.vistas;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestionPersonas extends JFrame {

    private JPanel PanelTitulo = new JPanel();
    private JPanel PanelCuerpo = new JPanel();

    public GestionPersonas() {
        this.show();//Mostrar pantalla
        this.setTitle("REGISTRO DE PERSONAS");//Titulo de la pantalla
        this.setSize(390, 600);//Tamaño inicial de la pantalla
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        PanelTitulo.setLayout(new FlowLayout());//Se agrego un Layout encargado de distribuir los componentes
        JLabel registroP = new JLabel("REGISTRO DE PERSONAS");
        JLabel registroP2 = new JLabel();
        PanelCuerpo.add(registroP);
        PanelCuerpo.add(registroP2);
        PanelCuerpo.setLayout(new GridLayout(9, 2));
        PanelCuerpo.add(new JLabel("Cedula  : "));
        PanelCuerpo.add(new JTextField(10));
        PanelCuerpo.add(new JLabel("Nombres  :"));
        PanelCuerpo.add(new JTextField(10));
        PanelCuerpo.add(new JLabel("Apellidos  :"));
        PanelCuerpo.add(new JTextField(10));
        PanelCuerpo.add(new JLabel("Direccion  :"));
        PanelCuerpo.add(new JTextField(10));
        PanelCuerpo.add(new JLabel("Correo  :"));
        PanelCuerpo.add(new JTextField(10));
        PanelCuerpo.add(new JLabel("Telefono  :"));
        PanelCuerpo.add(new JTextField(10));
        this.add(PanelCuerpo);
        GridLayout gBotones = new GridLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        JButton b_agregar = new JButton("AGREGAR");
        JButton b_editar = new JButton("EDITAR");
        JButton b_eliminar = new JButton("ELIMINAR");
        JButton b_ultimoRegistro = new JButton("TRAER ULTIMO REGISTRO");
        PanelCuerpo.add(b_agregar);
        PanelCuerpo.add(b_editar);
        PanelCuerpo.add(b_eliminar);
        PanelCuerpo.add(b_ultimoRegistro);
        this.setLocationRelativeTo(null);//Centrar la Pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar o dar fin al Programa
    }
}
