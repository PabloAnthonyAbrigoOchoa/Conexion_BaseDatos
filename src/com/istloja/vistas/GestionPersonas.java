package com.istloja.vistas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestionPersonas extends JFrame {

    private JPanel Panel = new JPanel();

    private JPanel PanelTitulo = new JPanel();
    private JPanel PanelCuerpo = new JPanel();
    private JPanel PanelBotones = new JPanel();

    public GestionPersonas() {
        this.show();//Mostrar pantalla
        this.setTitle("FORMULARIO");//Titulo de la pantalla
        this.setSize(470, 350);//Tamaño inicial de la pantalla
        Panel.setLayout(new FlowLayout());//Se agrego un Layout encargado de distribuir los componentes
        JLabel Tlabel = new JLabel("REGISTRO DE PERSONAS");
        PanelTitulo.add(Tlabel);
        Panel.add(PanelTitulo);
        Panel.add(Tlabel);
        PanelCuerpo.setLayout(new GridLayout(6, 2));
        PanelCuerpo.add(new JLabel("Cédula  : "));
        PanelCuerpo.add(new JTextField("1106049925"));
        PanelCuerpo.add(new JLabel("Nombres  :"));
        PanelCuerpo.add(new JTextField("Pablo Anthony"));
        PanelCuerpo.add(new JLabel("Apellidos  :"));
        PanelCuerpo.add(new JTextField("Abrigo Ochoa"));
        PanelCuerpo.add(new JLabel("Dirección  :"));
        PanelCuerpo.add(new JTextField("Ciudad Victoria"));
        PanelCuerpo.add(new JLabel("Correo  :"));
        PanelCuerpo.add(new JTextField("pabloochoa518@gmail.com"));
        PanelCuerpo.add(new JLabel("Teléfono  :"));
        PanelCuerpo.add(new JTextField("0994941403"));
        Panel.add(PanelCuerpo);
        this.add(PanelCuerpo);
        PanelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        PanelBotones.add(new JButton("ACEPTAR"));
        PanelBotones.add(new JButton("EDITAR"));
        PanelBotones.add(new JButton("ELIMINAR"));
        PanelBotones.add(new JButton("TRAER ÚLTIMO REGISTRO"));
        Panel.add(PanelBotones);
        this.add(PanelBotones);
        this.setLocationRelativeTo(null);//Centrar la Pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar o dar fin al Programa
    }
//////////INTENTE VARIAS MANERAS DE RESOLVER EL PROBLEMA Y PERSISTE INGENIERO AHI ME MUESTRA SOLO LOS BOTONES Y ESTAN TODOS AGREGADOS CON SUS PANELES NO ENTIENDO POR QUE NO SE PRESENTAN EN PANTALLA EL RESTO 
    
    
}
