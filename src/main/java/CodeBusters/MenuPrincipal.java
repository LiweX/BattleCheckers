import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton nueva_partida, como_jugar, salir;
    private JLabel titulo, marca;

    public MenuPrincipal() {
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        nueva_partida = new JButton("Nueva Partida");
        nueva_partida.setBounds(80,300,120,20);
        nueva_partida.addActionListener(this);
        add(nueva_partida);

        como_jugar = new JButton("Como Jugar");
        como_jugar.setBounds(80,340,120,20);
        como_jugar.addActionListener(this);
        add(como_jugar);

        salir = new JButton("Salir");
        salir.setBounds(80,380,120,20);
        salir.addActionListener(this);
        add(salir);

        titulo = new JLabel("BattleCheckers");
        titulo.setFont(new Font("Arial",3,18));
        titulo.setBounds(75,100,300,30);
        add(titulo);

        marca = new JLabel("©2020 CodeBusters");
        marca.setFont(new Font("Arial",3,10));
        marca.setBounds(95,530,300,30);
        add(marca);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir) System.exit(0);

        if(e.getSource() == como_jugar) {
            ComoJugar tutorial = new ComoJugar();
            
            tutorial.setBounds(0,0,640,450);
            tutorial.setVisible(true);
            tutorial.setResizable(false);
            tutorial.setLocationRelativeTo(null);
            tutorial.setTitle("Como Jugar");
            
            this.setVisible(false);
        }

        if(e.getSource() == nueva_partida) {
            PedirNombres pedirNombres = new PedirNombres();
            
            pedirNombres.setBounds(0,0,300,170);
            pedirNombres.setVisible(true);
            pedirNombres.setResizable(false);
            pedirNombres.setLocationRelativeTo(null);
            pedirNombres.setTitle("Ingresar nombres");
            
            this.setVisible(false);
        }
    }
}