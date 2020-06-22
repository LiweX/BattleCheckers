package codebusters;

import java.awt.event.*;

import javax.swing.*;

public class PedirNombres extends JFrame implements ActionListener {

    private JTextField cuadroTexto1, cuadroTexto2;
    private JButton aceptar;
    private JLabel jugador1, jugador2;

    public static String nombre1, nombre2;

    public PedirNombres() {
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugador1 = new JLabel("Nombre Blancas:");
        jugador1.setBounds(10,10,120,30);
        add(jugador1);

        jugador2 = new JLabel("Nombre Rojas:");
        jugador2.setBounds(10,42,120,30);
        add(jugador2);

        cuadroTexto1 = new JTextField();
        cuadroTexto1.setBounds(130,15,150,25);
        add(cuadroTexto1);

        cuadroTexto2 = new JTextField();
        cuadroTexto2.setBounds(130,45,150,25);
        add(cuadroTexto2);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10,90,100,30);
        aceptar.addActionListener(this);
        add(aceptar);
    }

    /*
     *  @param  n1, n2: Nombres a comparar.
     */
    public boolean chequearNombres(String n1, String n2) {
        if(n1.equals("") || n2.equals("") || n1.equals(n2)) return false;
        else return true;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aceptar) {
            nombre1 = cuadroTexto1.getText().trim();
            nombre2 = cuadroTexto2.getText().trim();
            
            if(!chequearNombres(nombre1,nombre2)) JOptionPane.showMessageDialog(null,"Ambos jugadores deben tener nombres y deben ser distintos");
            else {
                Tablero tablero = new Tablero();
                
                tablero.setBounds(0,0,656,702);
                tablero.setVisible(true);
                tablero.setResizable(false);

                this.setVisible(false);
                Estadisticas estadisticas = new Estadisticas();
                
                estadisticas.setBounds(650,0,300,650);
                estadisticas.setVisible(true);
                estadisticas.setResizable(false);

                Main.jugando = true;
                Juego juego = new Juego(tablero,estadisticas);
                tablero.setJuego(juego);
            }
        }
    }
}