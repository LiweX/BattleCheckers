import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tablero extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JMenuBar menubar;
    private JMenu juego, ayuda;
    private JMenuItem nuevaPartida, salir, acercaDe, comoJugar;
    private JButton b1,d1,f1,h1,a2,c2,e2,g2,b3,d3,f3,h3,a4,c4,e4,g4,b5,d5,f5,h5,a6,c6,e6,g6,b7,d7,f7,h7,a8,c8,e8,g8;
    private ImageIcon fichaRoja, fichaBlanca; //vacio;

    public Tablero() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fichaRoja = new ImageIcon("images/fichaRoja.png");
        fichaBlanca = new ImageIcon("images/fichaBlanca.png");
        //vacio = new ImageIcon();
        new ImageIcon();
        
    	setLayout(null);
        
        menubar = new JMenuBar();
        
        setJMenuBar(menubar);

        juego = new JMenu("Juego");
        menubar.add(juego);
        
        ayuda = new JMenu("Ayuda");
        menubar.add(ayuda);

        nuevaPartida = new JMenuItem("Nueva Partida");
        nuevaPartida.addActionListener(this);
        juego.add(nuevaPartida);

        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        juego.add(salir);

        comoJugar = new JMenuItem("Como Jugar");
        comoJugar.addActionListener(this);
        ayuda.add(comoJugar);

        acercaDe = new JMenuItem("Acerca de...");
        acercaDe.addActionListener(this);
        ayuda.add(acercaDe);

        b1 = new JButton();
        b1.setIcon(fichaBlanca);
        b1.setBounds(80,0,80,80);
        b1.setBackground(new Color(0,0,0));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        add(b1);
        b1.addActionListener(this);

        d1 = new JButton();
        d1.setIcon(fichaBlanca);
        d1.setBounds(240,0,80,80);
        d1.setBackground(new Color(0,0,0));
        d1.setBorderPainted(false);
        d1.setFocusPainted(false);
        add(d1);
        d1.addActionListener(this);

        f1 = new JButton();
        f1.setIcon(fichaBlanca);
        f1.setBounds(400,0,80,80);
        f1.setBackground(new Color(0,0,0));
        f1.setBorderPainted(false);
        f1.setFocusPainted(false);
        add(f1);
        f1.addActionListener(this);

        h1 = new JButton();
        h1.setIcon(fichaBlanca);
        h1.setBounds(560,0,80,80);
        h1.setBackground(new Color(0,0,0));
        h1.setBorderPainted(false);
        h1.setFocusPainted(false);
        add(h1);
        h1.addActionListener(this);

        a2 = new JButton();
        a2.setIcon(fichaBlanca);
        a2.setBounds(0,80,80,80);
        a2.setBackground(new Color(0,0,0));
        a2.setBorderPainted(false);
        a2.setFocusPainted(false);
        add(a2);
        a2.addActionListener(this);

        c2 = new JButton();
        c2.setIcon(fichaBlanca);
        c2.setBounds(160,80,80,80);
        c2.setBackground(new Color(0,0,0));
        c2.setBorderPainted(false);
        c2.setFocusPainted(false);
        add(c2);
        c2.addActionListener(this);

        e2 = new JButton();
        e2.setIcon(fichaBlanca);
        e2.setBounds(320,80,80,80);
        e2.setBackground(new Color(0,0,0));
        e2.setBorderPainted(false);
        e2.setFocusPainted(false);
        add(e2);
        e2.addActionListener(this);

        g2 = new JButton();
        g2.setIcon(fichaBlanca);
        g2.setBounds(480,80,80,80);
        g2.setBackground(new Color(0,0,0));
        g2.setBorderPainted(false);
        g2.setFocusPainted(false);
        add(g2);
        g2.addActionListener(this);

        b3 = new JButton();
        b3.setIcon(fichaBlanca);
        b3.setBounds(80,160,80,80);
        b3.setBackground(new Color(0,0,0));
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        add(b3);
        b3.addActionListener(this);

        d3 = new JButton();
        d3.setIcon(fichaBlanca);
        d3.setBounds(240,160,80,80);
        d3.setBackground(new Color(0,0,0));
        d3.setBorderPainted(false);
        d3.setFocusPainted(false);
        add(d3);
        d3.addActionListener(this);

        f3 = new JButton();
        f3.setIcon(fichaBlanca);
        f3.setBounds(400,160,80,80);
        f3.setBackground(new Color(0,0,0));
        f3.setBorderPainted(false);
        f3.setFocusPainted(false);
        add(f3);
        f3.addActionListener(this);

        h3 = new JButton();
        h3.setIcon(fichaBlanca);
        h3.setBounds(560,160,80,80);
        h3.setBackground(new Color(0,0,0));
        h3.setBorderPainted(false);
        h3.setFocusPainted(false);
        add(h3);
        h3.addActionListener(this);

        a4 = new JButton();
        a4.setBounds(0,240,80,80);
        a4.setBackground(new Color(0,0,0));
        a4.setBorderPainted(false);
        a4.setFocusPainted(false);
        add(a4);
        a4.addActionListener(this);

        c4 = new JButton();
        c4.setBounds(160,240,80,80);
        c4.setBackground(new Color(0,0,0));
        c4.setBorderPainted(false);
        c4.setFocusPainted(false);
        add(c4);
        c4.addActionListener(this);

        e4 = new JButton();
        e4.setBounds(320,240,80,80);
        e4.setBackground(new Color(0,0,0));
        e4.setBorderPainted(false);
        e4.setFocusPainted(false);
        add(e4);
        e4.addActionListener(this);

        g4 = new JButton();
        g4.setBounds(480,240,80,80);
        g4.setBackground(new Color(0,0,0));
        g4.setBorderPainted(false);
        g4.setFocusPainted(false);
        add(g4);
        g4.addActionListener(this);

        b5 = new JButton();
        b5.setBounds(80,320,80,80);
        b5.setBackground(new Color(0,0,0));
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        add(b5);
        b5.addActionListener(this);

        d5 = new JButton();
        d5.setBounds(240,320,80,80);
        d5.setBackground(new Color(0,0,0));
        d5.setBorderPainted(false);
        d5.setFocusPainted(false);
        add(d5);
        d5.addActionListener(this);

        f5 = new JButton();
        f5.setBounds(400,320,80,80);
        f5.setBackground(new Color(0,0,0));
        f5.setBorderPainted(false);
        f5.setFocusPainted(false);
        add(f5);
        f5.addActionListener(this);

        h5 = new JButton();
        h5.setBounds(560,320,80,80);
        h5.setBackground(new Color(0,0,0));
        h5.setBorderPainted(false);
        h5.setFocusPainted(false);
        add(h5);
        h5.addActionListener(this);

        a6 = new JButton();
        a6.setIcon(fichaRoja);
        a6.setBounds(0,400,80,80);
        a6.setBackground(new Color(0,0,0));
        a6.setBorderPainted(false);
        a6.setFocusPainted(false);
        add(a6);
        a6.addActionListener(this);

        c6 = new JButton();
        c6.setIcon(fichaRoja);
        c6.setBounds(160,400,80,80);
        c6.setBackground(new Color(0,0,0));
        c6.setBorderPainted(false);
        c6.setFocusPainted(false);
        add(c6);
        c6.addActionListener(this);

        e6 = new JButton();
        e6.setIcon(fichaRoja);
        e6.setBounds(320,400,80,80);
        e6.setBackground(new Color(0,0,0));
        e6.setBorderPainted(false);
        e6.setFocusPainted(false);
        add(e6);
        e6.addActionListener(this);

        g6 = new JButton();
        g6.setIcon(fichaRoja);
        g6.setBounds(480,400,80,80);
        g6.setBackground(new Color(0,0,0));
        g6.setBorderPainted(false);
        g6.setFocusPainted(false);
        add(g6);
        g6.addActionListener(this);

        b7 = new JButton();
        b7.setIcon(fichaRoja);
        b7.setBounds(80,480,80,80);
        b7.setBackground(new Color(0,0,0));
        b7.setBorderPainted(false);
        b7.setFocusPainted(false);
        add(b7);
        b7.addActionListener(this);

        d7 = new JButton();
        d7.setIcon(fichaRoja);
        d7.setIcon(fichaRoja);
        d7.setBounds(240,480,80,80);
        d7.setBackground(new Color(0,0,0));
        d7.setBorderPainted(false);
        d7.setFocusPainted(false);
        add(d7);
        d7.addActionListener(this);

        f7 = new JButton();
        f7.setIcon(fichaRoja);
        f7.setBounds(400,480,80,80);
        f7.setBackground(new Color(0,0,0));
        f7.setBorderPainted(false);
        f7.setFocusPainted(false);
        add(f7);
        f7.addActionListener(this);

        h7 = new JButton();
        h7.setIcon(fichaRoja);
        h7.setBounds(560,480,80,80);
        h7.setBackground(new Color(0,0,0));
        h7.setBorderPainted(false);
        h7.setFocusPainted(false);
        add(h7);
        h7.addActionListener(this);

        a8 = new JButton();
        a8.setIcon(fichaRoja);
        a8.setBounds(0,560,80,80);
        a8.setBackground(new Color(0,0,0));
        a8.setBorderPainted(false);
        a8.setFocusPainted(false);
        add(a8);
        a8.addActionListener(this);

        c8 = new JButton();
        c8.setIcon(fichaRoja);
        c8.setBounds(160,560,80,80);
        c8.setBackground(new Color(0,0,0));
        c8.setBorderPainted(false);
        c8.setFocusPainted(false);
        add(c8);
        c8.addActionListener(this);

        e8 = new JButton();
        e8.setIcon(fichaRoja);
        e8.setBounds(320,560,80,80);
        e8.setBackground(new Color(0,0,0));
        e8.setBorderPainted(false);
        e8.setFocusPainted(false);
        add(e8);
        e8.addActionListener(this);

        g8 = new JButton();
        g8.setIcon(fichaRoja);
        g8.setBounds(480,560,80,80);
        g8.setBackground(new Color(0,0,0));
        g8.setBorderPainted(false);
        g8.setFocusPainted(false);
        add(g8);
        g8.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == nuevaPartida) {
            PedirNombres pedirNombres = new PedirNombres();
            
            pedirNombres.setBounds(0,0,240,170);
            pedirNombres.setVisible(true);
            pedirNombres.setResizable(false);
            pedirNombres.setLocationRelativeTo(null);
            pedirNombres.setTitle("Ingresar nombres");
            
            this.setVisible(false);
        }
        
        if(e.getSource() == salir) System.exit(0);

        if(e.getSource() == comoJugar) {
            ComoJugar tutorial = new ComoJugar();
            
            tutorial.setBounds(0,0,640,450);
            tutorial.setVisible(true);
            tutorial.setResizable(false);
            tutorial.setLocationRelativeTo(null);
            tutorial.setTitle("Como Jugar");
        }

        if(e.getSource() == acercaDe) JOptionPane.showMessageDialog(null,"aca va info nuestra");

        if(e.getSource() == b1){

        }
        if(e.getSource() == d1){

        }
        if(e.getSource() == f1){

        }
        if(e.getSource() == h1){

        }
        if(e.getSource() == a2){

        }
        if(e.getSource() == c2){

        }
        if(e.getSource() == e2){

        }
        if(e.getSource() == g2){

        }
        if(e.getSource() == b3){

        }
        if(e.getSource() == d3){

        }
        if(e.getSource() == f3){

        }
        if(e.getSource() == h3){

        }
        if(e.getSource() == a4){

        }
        if(e.getSource() == c4){

        }
        if(e.getSource() == e4){

        }
        if(e.getSource() == g4){

        }
        if(e.getSource() == b5){

        }
        if(e.getSource() == d5){

        }
        if(e.getSource() == f5){

        }
        if(e.getSource() == h5){

        }
        if(e.getSource() == a6){

        }
        if(e.getSource() == c6){

        }
        if(e.getSource() == e6){

        }
        if(e.getSource() == g6){

        }
        if(e.getSource() == b7){

        }
        if(e.getSource() == d7){

        }
        if(e.getSource() == f7){

        }
        if(e.getSource() == h7){

        }
        if(e.getSource() == a8){

        }
        if(e.getSource() == c8){

        }
        if(e.getSource() == e8){

        }
        if(e.getSource() == g8){

        }
    }

    public void update(){
        //TODO
    }
}