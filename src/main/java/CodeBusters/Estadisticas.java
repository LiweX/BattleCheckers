package codebusters;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Estadisticas extends JFrame implements ActionListener {

    private JLabel jugador1, jugador2, piezasComidas, tituloHistorial;
    private JScrollPane scrollPane;
    private JTextArea historial;
    private int cantidadMovimientos;
    private int cantidadEliminaciones;

    public Estadisticas() {
        setLayout(null);

        piezasComidas = new JLabel("Piezas comidas");
        piezasComidas.setFont(new Font("Arial",3,18));
        piezasComidas.setBounds(60,20,200,20);
        add(piezasComidas);

        jugador1 = new JLabel(PedirNombres.nombre1 + ":");
        jugador1.setFont(new Font("Arial",3,15));
        jugador1.setBounds(25,60,200,20);
        add(jugador1);

        jugador2 = new JLabel(PedirNombres.nombre2 + ":");
        jugador2.setFont(new Font("Arial",3,15));
        jugador2.setBounds(25,110,200,20);
        add(jugador2);

        tituloHistorial = new JLabel("Historial de movimientos");
        tituloHistorial.setFont(new Font("Arial",3,18));
        tituloHistorial.setBounds(20,170,300,20);
        add(tituloHistorial);

        historial = new JTextArea();
        historial.setEditable(false);
        scrollPane = new JScrollPane(historial);
        scrollPane.setBounds(10,200,266,400);
        add(scrollPane);
    }

    public void actionPerformed(ActionEvent e) {
        //TODO
    }

    public void addEliminacion(){
        cantidadEliminaciones++;
    }

    public void addMovimiento(){
        cantidadMovimientos++;
    }
    @Override
    public void updateHistorial(String movimiento){
        historial.setText(movimiento);

    }


}