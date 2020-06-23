import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PartidaFin extends JFrame implements ActionListener {

    private JLabel mensaje;
    private JButton boton;
    private Estadisticas estadisticas;
    private Tablero tablero;

    public PartidaFin(String mensaje, Estadisticas estadisticas, Tablero tablero) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        this.setBounds(0,0,300,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Partida finalizada");

        this.mensaje = new JLabel(mensaje);
        this.mensaje.setBounds(70,0,200,50);
        add(this.mensaje);

        boton = new JButton("Volver al menú");
        boton.setBounds(70, 70, 150, 30);
        boton.addActionListener(this);
        add(boton);

        this.estadisticas = estadisticas;
        this.tablero = tablero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton) {
        boton.addActionListener(this);
        add(boton);

        this.estadisticas = estadisticas;
        this.tablero = tablero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton) {
        boton.addActionListener(this);
        add(boton);

        this.estadisticas = estadisticas;
        this.tablero = tablero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton) {
            this.setVisible(false);
            
            estadisticas.setVisible(false);
            tablero.setVisible(false);
            
            MenuPrincipal menu = new MenuPrincipal();
            
            menu.setBounds(0,0,300,600);
            menu.setVisible(true);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.setTitle("BattleCheckers");
        }
    }
}