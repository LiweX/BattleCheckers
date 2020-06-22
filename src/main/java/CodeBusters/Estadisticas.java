package codebusters;

import java.awt.*;

import javax.swing.*;

public class Estadisticas extends JFrame implements ObservadorEstadisticas {

    private JLabel jugador1, jugador2, piezasComidas, tituloHistorial,comidasJ1,comidasJ2;
    private JScrollPane scrollPane;
    private JTextArea historial;
    private int cantidadMovimientos, cantidadEliminaciones;

    public Estadisticas() {
        setLayout(null);

        comidasJ1 = new JLabel("0");
        comidasJ1.setFont(new Font("Arial",3,16));
        comidasJ1.setBounds(50,85,200,20);
        add(comidasJ1);

        comidasJ2 = new JLabel("0");
        comidasJ2.setFont(new Font("Arial",3,16));
        comidasJ2.setBounds(50,135,200,20);
        add(comidasJ2);

        piezasComidas = new JLabel("Piezas comidas");
        piezasComidas.setFont(new Font("Arial",3,18));
        piezasComidas.setBounds(60,20,200,20);
        add(piezasComidas);

        jugador1 = new JLabel(PedirNombres.nombre1 + ":");
        jugador1.setFont(new Font("Arial",3,18));
        jugador1.setBounds(25,60,200,20);
        add(jugador1);

        jugador2 = new JLabel(PedirNombres.nombre2 + ":");
        jugador2.setFont(new Font("Arial",3,18));
        jugador2.setBounds(25,110,200,20);
        add(jugador2);

        tituloHistorial = new JLabel("Historial de movimientos");
        tituloHistorial.setFont(new Font("Arial",3,18));
        tituloHistorial.setBounds(20,170,300,20);
        add(tituloHistorial);

        historial = new JTextArea();
        historial.setEditable(false);
        historial.setLineWrap(true);
        historial.setWrapStyleWord(true);
        scrollPane = new JScrollPane(historial);
        scrollPane.setBounds(10,200,266,400);
        add(scrollPane);
    }

    public void addEliminacion() {
        cantidadEliminaciones++;
    }

    public void addMovimiento() {
        cantidadMovimientos++;
    }

    @Override
    public void updateHistorial(String movimiento) {
        historial.append(movimiento);
    }

    @Override
    public void updateComidas(int fichasJ1, int fichasJ2) {
        comidasJ1.setText(Integer.toString(fichasJ2));
        comidasJ2.setText(Integer.toString(fichasJ1));

        if(fichasJ1==12) {
            JOptionPane.showMessageDialog(null,"Ganó el jugador de las fichas ROJAS!");
        } else if(fichasJ2==12) {
            JOptionPane.showMessageDialog(null,"Ganó el jugador de las fichas BLANCAS!");
        }
    }
}