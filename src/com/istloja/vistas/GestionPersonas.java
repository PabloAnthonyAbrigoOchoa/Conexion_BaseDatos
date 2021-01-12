package com.istloja.vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GestionPersonas extends JFrame {

    private JPanel Panel = new JPanel();

    public GestionPersonas() {
        this.show();//Mostrar pantalla
        this.setTitle("VENTANA");//Titulo de la pantalla
        this.setSize(500, 650);//Tamaño inicial de la pantalla
        Panel.setLayout(new FlowLayout());//Se agrego un Layout encargado de distribuir los componentes
        JLabel label = new JLabel("VENTANA DE REGISTRO DE PERSONAS");
        JButton boton = new JButton("REGISTRAR");
        JButton boton1 = new JButton("ELIMINAR");
        JButton boton2 = new JButton("ACTUALIZAR");
//        boton.setText("REGISTRAR");
        Panel.add(label);
        Panel.add(boton);
        Panel.add(boton1);
        Panel.add(boton2);
        this.add(Panel);//Agrege el Panel al JFrame
        this.setLocationRelativeTo(null);//Centrar la Pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar o dar fin al Programa
    }
}
