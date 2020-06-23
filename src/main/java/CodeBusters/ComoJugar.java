import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ComoJugar extends JFrame implements ActionListener {

    private JButton atras, adelante, volver;
    private JLabel imagenTutorial;
    private ArrayList<Icon> tutoriales;
    private int numPagina = 0;

    public ComoJugar() {
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tutoriales = new ArrayList<>();
        Icon pagina1 = new ImageIcon(getClass().getResource("Pagina1.png"));
        Icon pagina2 = new ImageIcon(getClass().getResource("Pagina2.png"));
        Icon pagina3 = new ImageIcon(getClass().getResource("Pagina3.png"));
        Icon pagina4 = new ImageIcon(getClass().getResource("Pagina4.png"));
        Icon pagina5 = new ImageIcon(getClass().getResource("Pagina5.png"));
        Icon pagina6 = new ImageIcon(getClass().getResource("Pagina6.png"));
        Icon pagina7 = new ImageIcon(getClass().getResource("Pagina7.png"));
        tutoriales.add(pagina1);
        tutoriales.add(pagina2);
        tutoriales.add(pagina3);
        tutoriales.add(pagina4);
        tutoriales.add(pagina5);
        tutoriales.add(pagina6);
        tutoriales.add(pagina7);
        
        atras = new JButton("Atras");
        atras.setBounds(10,430,90,25);
        atras.setEnabled(false);
        atras.addActionListener(this);
        add(atras);


        adelante = new JButton("Adelante");
        adelante.setBounds(475,430,90,25);
        adelante.addActionListener(this);
        add(adelante);

        volver = new JButton("Volver");
        volver.setBounds(10,10,90,25);
        volver.addActionListener(this);
        add(volver);

        imagenTutorial = new JLabel("Pagina 0");
        imagenTutorial.setFont(new Font("Arial",3,18));
        imagenTutorial.setBounds(35,43,500,380);
        imagenTutorial.setIcon(tutoriales.get(0));
        add(imagenTutorial);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==atras) {
            if(numPagina==1) atras.setEnabled(false);
            else adelante.setEnabled(true);
            
            numPagina--;
            
            imagenTutorial.setIcon(tutoriales.get(numPagina));
        }
        if(e.getSource()==adelante) {
            if(numPagina==5) adelante.setEnabled(false);
            else atras.setEnabled(true);
            
            numPagina++;
            
            imagenTutorial.setIcon(tutoriales.get(numPagina));
        }
        if(e.getSource()==volver) {
            if(Main.jugando==false) {
                MenuPrincipal menu = new MenuPrincipal();
                
                menu.setBounds(0,0,300,600);
                menu.setVisible(true);
                menu.setResizable(false);
                menu.setLocationRelativeTo(null);
                menu.setTitle("BattleCheckers");
                
                this.setVisible(false);
            }
            else this.setVisible(false);
        }
    }
}
