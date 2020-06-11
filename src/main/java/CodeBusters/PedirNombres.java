import javax.swing.*;
import java.awt.event.*;

public class PedirNombres extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField cuadroTexto1, cuadroTexto2;
    private JButton aceptar;
    private JLabel jugador1, jugador2;

    public static String nombre1, nombre2; //¿Por qué son 'static'?

    public PedirNombres() {
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jugador1 = new JLabel("Nombre Jugador 1:");
        jugador1.setBounds(10,10,120,30);
        add(jugador1);

        jugador2 = new JLabel("Nombre Jugador 2:");
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
        add(aceptar);
        aceptar.addActionListener(this);
    }

    public boolean checkNames(String n1, String n2) {
        if(n1.equals(n2)) return true;
        else return false;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aceptar) {
            nombre1 = cuadroTexto1.getText().trim();
            nombre2 = cuadroTexto2.getText().trim();
            
            if(nombre1.equals("") || nombre2.equals("")) JOptionPane.showMessageDialog(null,"Ambos jugadores deben tener nombre");
            else if(nombre1.equals(nombre2)) JOptionPane.showMessageDialog(null, "Los jugadores no pueden tener el mismo nombre");
            else {
                Tablero tablero = new Tablero();
                
                tablero.setBounds(0,0,656,702);
                tablero.setVisible(true);
                tablero.setResizable(false);

                this.setVisible(false);

                Main.jugando = true;

                Estadisticas estadisticas = new Estadisticas();
                
                estadisticas.setBounds(650,0,300,650);
                estadisticas.setVisible(true);
                estadisticas.setResizable(false);
            }
        }
    }
}