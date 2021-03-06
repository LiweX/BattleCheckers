/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

import java.awt.*;

import javax.swing.*;

public class Estadisticas extends JFrame implements ObservadorEstadisticas {

    private JLabel jugador1, jugador2, piezasComidas, tituloHistorial, comidasJ1, comidasJ2;
    private JScrollPane scrollPane;
    private JTextArea historial;

    public Estadisticas() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        comidasJ1 = new JLabel("0");
        comidasJ1.setFont(new Font("Arial",3,16));
        comidasJ1.setBounds(50,85,200,20);
        add(comidasJ1);

        comidasJ2 = new JLabel("0");
        comidasJ2.setFont(new Font("Arial",3,16));
        comidasJ2.setBounds(50,135,200,20);
        add(comidasJ2);

        piezasComidas = new JLabel("Piezas eliminadas");
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

    //-------------------Getters-------------------

    /**
     * @return Nombre del jugador de piezas blancas.
     */
    public String getNombreJugador1() {
        return jugador1.getText().replace(":","");
    }

    /**
     * @return Nombre del jugador de piezas rojas.
     */
    public String getNombreJugador2() {
        return jugador2.getText().replace(":","");
    }

    //-------------------Overrides-------------------

    /**
     * @param movimiento Movimiento a agregar al historial.
     */
    @Override
    public void updateHistorial(String movimiento) {
        historial.append(movimiento);
    }

    /**
     * @param fichasJ1 Fichas comidas por el jugador de fichas rojas.
     * @param fichasJ2 Fichas comidas por el jugador de fichas blancas
     */
    @Override
    public void updateComidas(int fichasJ1, int fichasJ2) {
        comidasJ1.setText(Integer.toString(fichasJ2));
        comidasJ2.setText(Integer.toString(fichasJ1));
    }
}