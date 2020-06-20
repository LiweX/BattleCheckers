package CodeBusters;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tablero extends JFrame implements ActionListener,Observador {

    private JMenuBar menubar;
    private JMenu juego, ayuda;
    private JMenuItem nuevaPartida, salir, acercaDe, comoJugar;
    private Celda b1,d1,f1,h1,a2,c2,e2,g2,b3,d3,f3,h3,a4,c4,e4,g4,b5,d5,f5,h5,a6,c6,e6,g6,b7,d7,f7,h7,a8,c8,e8,g8;
    private ImageIcon fichaRoja, fichaBlanca;
    private boolean porMover = false;
    private Celda[][] celdas = new Celda[8][8];

    public Tablero() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fichaRoja = new ImageIcon("src/main/resources/fichaRoja.png");
        fichaBlanca = new ImageIcon("src/main/resources/fichaBlanca.png");
        //vacio = new ImageIcon();
        
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

        b1 = new Celda(1,0,true);
        b1.setIcon(fichaBlanca);
        b1.setBounds(80,0,80,80);
        b1.setBackground(new Color(0,0,0));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        add(b1);
        b1.addActionListener(this);
        celdas[0][1]=b1;

        d1 = new Celda(3,0,true);
        d1.setIcon(fichaBlanca);
        d1.setBounds(240,0,80,80);
        d1.setBackground(new Color(0,0,0));
        d1.setBorderPainted(false);
        d1.setFocusPainted(false);
        add(d1);
        d1.addActionListener(this);
        celdas[0][3]=d1;

        f1 = new Celda(5,0,true);
        f1.setIcon(fichaBlanca);
        f1.setBounds(400,0,80,80);
        f1.setBackground(new Color(0,0,0));
        f1.setBorderPainted(false);
        f1.setFocusPainted(false);
        add(f1);
        f1.addActionListener(this);
        celdas[0][5]=f1;

        h1 = new Celda(7,0,true);
        h1.setIcon(fichaBlanca);
        h1.setBounds(560,0,80,80);
        h1.setBackground(new Color(0,0,0));
        h1.setBorderPainted(false);
        h1.setFocusPainted(false);
        add(h1);
        h1.addActionListener(this);
        celdas[0][7]=h1;

        a2 = new Celda(0,1,true);
        a2.setIcon(fichaBlanca);
        a2.setBounds(0,80,80,80);
        a2.setBackground(new Color(0,0,0));
        a2.setBorderPainted(false);
        a2.setFocusPainted(false);
        add(a2);
        a2.addActionListener(this);
        celdas[1][0] = a2;

        c2 = new Celda(2,1,true);
        c2.setIcon(fichaBlanca);
        c2.setBounds(160,80,80,80);
        c2.setBackground(new Color(0,0,0));
        c2.setBorderPainted(false);
        c2.setFocusPainted(false);
        add(c2);
        c2.addActionListener(this);
        celdas[1][2]=c2;
        
        e2 = new Celda(4,1,true);
        e2.setIcon(fichaBlanca);
        e2.setBounds(320,80,80,80);
        e2.setBackground(new Color(0,0,0));
        e2.setBorderPainted(false);
        e2.setFocusPainted(false);
        add(e2);
        e2.addActionListener(this);
        celdas[1][4] = e2;
        
        g2 = new Celda(6,1,true);
        g2.setIcon(fichaBlanca);
        g2.setBounds(480,80,80,80);
        g2.setBackground(new Color(0,0,0));
        g2.setBorderPainted(false);
        g2.setFocusPainted(false);
        add(g2);
        g2.addActionListener(this);
        celdas[1][6] = g2;

        b3 = new Celda(1,2,true);
        b3.setIcon(fichaBlanca);
        b3.setBounds(80,160,80,80);
        b3.setBackground(new Color(0,0,0));
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        add(b3);
        b3.addActionListener(this);
        celdas[2][1] = b3;

        d3 = new Celda(3,2,true);
        d3.setIcon(fichaBlanca);
        d3.setBounds(240,160,80,80);
        d3.setBackground(new Color(0,0,0));
        d3.setBorderPainted(false);
        d3.setFocusPainted(false);
        add(d3);
        d3.addActionListener(this);
        celdas[2][3]=d3;
        
        f3 = new Celda(5,2,true);
        f3.setIcon(fichaBlanca);
        f3.setBounds(400,160,80,80);
        f3.setBackground(new Color(0,0,0));
        f3.setBorderPainted(false);
        f3.setFocusPainted(false);
        add(f3);
        f3.addActionListener(this);
        celdas[2][5]=f3;

        h3 = new Celda(7,2,true);
        h3.setIcon(fichaBlanca);
        h3.setBounds(560,160,80,80);
        h3.setBackground(new Color(0,0,0));
        h3.setBorderPainted(false);
        h3.setFocusPainted(false);
        add(h3);
        h3.addActionListener(this);
        celdas[2][7] = h3;

        a4 = new Celda(0,3,false);
        a4.setBounds(0,240,80,80);
        a4.setBackground(new Color(0,0,0));
        a4.setBorderPainted(false);
        a4.setFocusPainted(false);
        add(a4);
        a4.addActionListener(this);
        celdas[3][0] = a4;

        c4 = new Celda(2,3,false);
        c4.setBounds(160,240,80,80);
        c4.setBackground(new Color(0,0,0));
        c4.setBorderPainted(false);
        c4.setFocusPainted(false);
        add(c4);
        c4.addActionListener(this);
        celdas[3][2] = c4;

        e4 = new Celda(4,3,false);
        e4.setBounds(320,240,80,80);
        e4.setBackground(new Color(0,0,0));
        e4.setBorderPainted(false);
        e4.setFocusPainted(false);
        add(e4);
        e4.addActionListener(this);
        celdas[3][4]=e4;

        g4 = new Celda(6,3,false);
        g4.setBounds(480,240,80,80);
        g4.setBackground(new Color(0,0,0));
        g4.setBorderPainted(false);
        g4.setFocusPainted(false);
        add(g4);
        g4.addActionListener(this);
        celdas[3][6] = g4;

        b5 = new Celda(1,4,false);
        b5.setBounds(80,320,80,80);
        b5.setBackground(new Color(0,0,0));
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        add(b5);
        b5.addActionListener(this);
        celdas[4][1] = b5;
        
        d5 = new Celda(3,4,false);
        d5.setBounds(240,320,80,80);
        d5.setBackground(new Color(0,0,0));
        d5.setBorderPainted(false);
        d5.setFocusPainted(false);
        add(d5);
        d5.addActionListener(this);
        celdas[4][3]=d5;
        
        f5 = new Celda(5,4,false);
        f5.setBounds(400,320,80,80);
        f5.setBackground(new Color(0,0,0));
        f5.setBorderPainted(false);
        f5.setFocusPainted(false);
        add(f5);
        f5.addActionListener(this);
        celdas[4][5] = f5;

        h5 = new Celda(7,4,false);
        h5.setBounds(560,320,80,80);
        h5.setBackground(new Color(0,0,0));
        h5.setBorderPainted(false);
        h5.setFocusPainted(false);
        add(h5);
        h5.addActionListener(this);
        celdas[4][7]=d1;
        
        a6 = new Celda(0,5,true);
        a6.setIcon(fichaRoja);
        a6.setBounds(0,400,80,80);
        a6.setBackground(new Color(0,0,0));
        a6.setBorderPainted(false);
        a6.setFocusPainted(false);
        add(a6);
        a6.addActionListener(this);
        celdas[5][0] = a6;

        c6 = new Celda(2,5,true);
        c6.setIcon(fichaRoja);
        c6.setBounds(160,400,80,80);
        c6.setBackground(new Color(0,0,0));
        c6.setBorderPainted(false);
        c6.setFocusPainted(false);
        add(c6);
        c6.addActionListener(this);
        celdas[5][2] = c6;

        e6 = new Celda(4,5,true);
        e6.setIcon(fichaRoja);
        e6.setBounds(320,400,80,80);
        e6.setBackground(new Color(0,0,0));
        e6.setBorderPainted(false);
        e6.setFocusPainted(false);
        add(e6);
        e6.addActionListener(this);
        celdas[5][4]=e6;

        g6 = new Celda(6,5,true);
        g6.setIcon(fichaRoja);
        g6.setBounds(480,400,80,80);
        g6.setBackground(new Color(0,0,0));
        g6.setBorderPainted(false);
        g6.setFocusPainted(false);
        add(g6);
        g6.addActionListener(this);
        celdas[5][6]=g6;

        b7 = new Celda(1,6,true);
        b7.setIcon(fichaRoja);
        b7.setBounds(80,480,80,80);
        b7.setBackground(new Color(0,0,0));
        b7.setBorderPainted(false);
        b7.setFocusPainted(false);
        add(b7);
        b7.addActionListener(this);
        celdas[6][1]=b7;

        d7 = new Celda(3,6,true);
        d7.setIcon(fichaRoja);
        d7.setBounds(240,480,80,80);
        d7.setBackground(new Color(0,0,0));
        d7.setBorderPainted(false);
        d7.setFocusPainted(false);
        add(d7);
        d7.addActionListener(this);
        celdas[6][3]=d7;

        f7 = new Celda(5,6,true);
        f7.setIcon(fichaRoja);
        f7.setBounds(400,480,80,80);
        f7.setBackground(new Color(0,0,0));
        f7.setBorderPainted(false);
        f7.setFocusPainted(false);
        add(f7);
        f7.addActionListener(this);
        celdas[6][5]=f7;

        h7 = new Celda(7,6,true);
        h7.setIcon(fichaRoja);
        h7.setBounds(560,480,80,80);
        h7.setBackground(new Color(0,0,0));
        h7.setBorderPainted(false);
        h7.setFocusPainted(false);
        add(h7);
        h7.addActionListener(this);
        celdas[6][7]=h7;

        a8 = new Celda(0,7,true);
        a8.setIcon(fichaRoja);
        a8.setBounds(0,560,80,80);
        a8.setBackground(new Color(0,0,0));
        a8.setBorderPainted(false);
        a8.setFocusPainted(false);
        add(a8);
        a8.addActionListener(this);
        celdas[7][0]=a8;

        c8 = new Celda(2,7,true);
        c8.setIcon(fichaRoja);
        c8.setBounds(160,560,80,80);
        c8.setBackground(new Color(0,0,0));
        c8.setBorderPainted(false);
        c8.setFocusPainted(false);
        add(c8);
        c8.addActionListener(this);
        celdas[7][2]=c8;

        e8 = new Celda(4,7,true);
        e8.setIcon(fichaRoja);
        e8.setBounds(320,560,80,80);
        e8.setBackground(new Color(0,0,0));
        e8.setBorderPainted(false);
        e8.setFocusPainted(false);
        add(e8);
        e8.addActionListener(this);
        celdas[7][4]=e8;

        g8 = new Celda(6,7,true);
        g8.setIcon(fichaRoja);
        g8.setBounds(480,560,80,80);
        g8.setBackground(new Color(0,0,0));
        g8.setBorderPainted(false);
        g8.setFocusPainted(false);
        add(g8);
        g8.addActionListener(this);
        celdas[7][6]=g8;
    }
    
    public void actionPerformed(ActionEvent e) {
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

        if(e.getSource() == b1) {
            if(b1.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
            else {} //PA MOVERSE A ESTA CELDA
        }
        if(e.getSource() == d1) {
            if(d1.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == f1) {
            if(f1.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == h1) {
            if(h1.hayFicha()) {
                
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == a2) {
            if(a2.hayFicha()) {
                
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == c2) {
            if(c2.hayFicha()) {
                //PA MOVÉ ESTA FICHA
                
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == e2) {
            if(e2.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == g2) {
            if(g2.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == b3) {
            if(b3.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == d3) {
            if(d3.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == f3) {
            if(f3.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == h3) {
            if(h3.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == a4) {
            if(a4.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == c4) {
            if(c4.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == e4) {
            if(e4.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == g4) {
            if(g4.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == b5) {
            if(b5.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == d5) {
            if(d5.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == f5) {
            if(f5.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == h5) {
            if(h5.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == a6) {
            if(a6.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == c6) {
            if(c6.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == e6) {
            if(e6.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == g6) {
            if(g6.hayFicha()) {
                //PA MOVÉ ESTA FICHA juego.moverficha(g6.getfila,g6.getcolumna)
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
            else{}//aca va el metodo para moverse a esa zelda
        }
        if(e.getSource() == b7) {
            if(b7.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == d7) {
            if(d7.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            }else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == f7) {
            if(f7.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }    
        if(e.getSource() == h7) {
            if(h7.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == a8) {
            if(a8.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == c8) {
            if(c8.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == e8) {
            if(e8.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
        if(e.getSource() == g8) {
            if(g8.hayFicha()) {
                //PA MOVÉ ESTA FICHA
            } else if(!porMover) { JOptionPane.showMessageDialog(null,"aca no hay ficha"); }
        }
    }

    //Getters
    public Celda[][] getCeldas() {
        return celdas;
    }

    @Override
    public void updatePintar(Celda celda) {
        //TODO celda.pintar();

    }

    //Setters
    /*
        @param  porMover: Indica si se está por efectuar un movimiento o no.
    */
    public void setMoviendo(boolean porMover) {
        this.porMover = porMover;
    }
}