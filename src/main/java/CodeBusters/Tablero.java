/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tablero extends JFrame implements ActionListener,ObservadorTablero {

    private JMenuBar menubar;
    private JMenu juego, ayuda;
    private JMenuItem nuevaPartida, salir, acercaDe, comoJugar;
    private Color black,red,green;
    private ImageIcon fichaRoja, fichaBlanca, vacio;
    private boolean porMover = false;
    private boolean turnoBlancas = true;
    private Celda[][] celdas = new Celda[8][8];
    private Juego game;

    public Tablero() {
        black = new Color(0,0,0);
        red = new Color(255,0,0);
        green = new Color(0,255,0);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fichaRoja = new ImageIcon(getClass().getResource("fichaRoja.png"));
        fichaBlanca = new ImageIcon(getClass().getResource("fichaBlanca.png"));
        vacio = new ImageIcon();
        
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

        int contadorColumnas;

        for(int i=0; i<8; i++) {
            contadorColumnas = 0;

            for(int j=0; j<8; j++) {
                if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)) {
                    Celda celda;
                    
                    if(i<3) {
                        Ficha ficha = new Ficha(ColorFicha.BLANCA,fichaBlanca);

                        celda = new Celda(i,j,true,ficha);
                        celda.setIcon(ficha.getIcon());
                    } else if(i>4) {
                        Ficha ficha = new Ficha(ColorFicha.ROJA,fichaRoja);

                        celda = new Celda(i,j,true,ficha);
                        celda.setIcon(ficha.getIcon());
                    } else {
                        celda = new Celda(i,j,false);
                        celda.setIcon(vacio);
                    }

                    celda.setBounds((80*((i+1)%2) + 160*contadorColumnas),(80*i),80,80);
                    celda.setBackground(black);
                    celda.setBorderPainted(false);
                    celda.setFocusPainted(false);
                    celda.addActionListener(this);
                    add(celda);

                    celdas[i][j] = celda;

                    contadorColumnas++;
                }
            }
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==nuevaPartida) {
            PedirNombres pedirNombres = new PedirNombres();
            
            pedirNombres.setBounds(0,0,300,170);
            pedirNombres.setVisible(true);
            pedirNombres.setResizable(false);
            pedirNombres.setLocationRelativeTo(null);
            pedirNombres.setTitle("Ingresar nombres");
            
            this.setVisible(false);
            game.getEstadisticas().setVisible(false);
        } else if(e.getSource()==salir) {
            System.exit(0);
        } else if(e.getSource()==comoJugar) {
            ComoJugar tutorial = new ComoJugar();
            
            tutorial.setBounds(0,0,640,450);
            tutorial.setVisible(true);
            tutorial.setResizable(false);
            tutorial.setLocationRelativeTo(null);
            tutorial.setTitle("Como Jugar");
        } else if(e.getSource()==acercaDe) {
            JOptionPane.showMessageDialog(null,"aca va info nuestra");
        }
        else {
            for(int i=0; i<8; i++)
                for(int j=0; j<8; j++)
                    if(((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)) && e.getSource()==celdas[i][j]) {
                        if(celdas[i][j].hayFicha()) {
                            if((turnoBlancas && celdas[i][j].getFicha().getColor()==ColorFicha.BLANCA) || (!turnoBlancas && celdas[i][j].getFicha().getColor()==ColorFicha.ROJA)) {
                                if((porMover && game.getCeldaAnterior().equals(celdas[i][j]))) {
                                    game.seleccionarFicha(celdas[i][j]);
                                } else if(celdas[i][j].hayFicha() && !porMover) {
                                    //toggleMoviendo();
                                    game.seleccionarFicha(celdas[i][j]);
                                }
                            } else {
                                if(turnoBlancas) {
                                    JOptionPane.showMessageDialog(null,"Es el turno de las blancas");
                                } else {
                                    JOptionPane.showMessageDialog(null,"Es el turno de las rojas");
                                }
                            }
                        } else {
                            if(porMover && celdas[i][j].getBackground()==green) {
                                toggleMoviendo();
                                game.moverFicha(celdas[i][j]);
                                toggleTurno();
                            } else if(porMover && celdas[i][j].getBackground()==red){
                                toggleMoviendo();
                                game.comerFicha(celdas[i][j]);
                                toggleTurno();
                            }
                        }
                    }
        }
    }

    //Getters
    public Celda[][] getCeldas() {
        return celdas;
    }

    /**
     *  @param  celda: Celda a pintar.
     */
    @Override
    public void updatePintarMover(Celda celda) {
        if(celda.getBackground().equals(green)) {
            celda.setBackground(black);
          
        }
        else celda.setBackground(green);
    }
    
    @Override
    public void updatePintarComer(Celda celda) {
        if(celda.getBackground().equals(red)) {
            celda.setBackground(black);
           
        }
        else celda.setBackground(red);
    }

    @Override
    public void updateMover(Celda origen, Celda destino) {
        destino.setIcon(origen.getIcon());
        destino.hayFicha(true);
        destino.setFicha(origen.getFicha());
        origen.setIcon(vacio);
        origen.hayFicha(false);
        origen.setFicha(null);
    }

    @Override
    public void updateComer(Celda origen, Celda destino) {
        if(origen.getFicha().getColor()==ColorFicha.BLANCA) {
            if(destino.getColumna()==origen.getColumna()+2) { //Ficha blanca que come abajo a la derecha
                celdas[origen.getFila()+1][origen.getColumna()+1].setFicha(null);
                celdas[origen.getFila()+1][origen.getColumna()+1].hayFicha(false);
                celdas[origen.getFila()+1][origen.getColumna()+1].setIcon(vacio);

                
            } else {    //Ficha blanca que come abajo a la izquierda
                celdas[origen.getFila()+1][origen.getColumna()-1].setFicha(null);
                celdas[origen.getFila()+1][origen.getColumna()-1].hayFicha(false);
                celdas[origen.getFila()+1][origen.getColumna()-1].setIcon(vacio);
            }
            
        } else {
            if(destino.getColumna()==origen.getColumna()+2) { //Ficha roja que come arriba a la derecha
                celdas[origen.getFila()-1][origen.getColumna()+1].setFicha(null);
                celdas[origen.getFila()-1][origen.getColumna()+1].hayFicha(false);
                celdas[origen.getFila()-1][origen.getColumna()+1].setIcon(vacio);

                
            } else {    //Ficha roja que come arriba a la izquierda
                celdas[origen.getFila()-1][origen.getColumna()-1].setFicha(null);
                celdas[origen.getFila()-1][origen.getColumna()-1].hayFicha(false);
                celdas[origen.getFila()-1][origen.getColumna()-1].setIcon(vacio);
            }
        }
        
        destino.setIcon(origen.getIcon());
        destino.hayFicha(true);
        destino.setFicha(origen.getFicha());
        origen.setIcon(vacio);
        origen.hayFicha(false);
        origen.setFicha(null);
    }

    //Setters
    /**
     *  @param  porMover: Indica si se está por efectuar un movimiento o no.
     */
    public void toggleMoviendo() {
        if(porMover) porMover = false;
        else porMover = true;
    }

    public boolean getMoviendo() {
        return porMover;
    }

    public void toggleTurno() {
        if(turnoBlancas) turnoBlancas = false;
        else turnoBlancas = true;
    }

    public void setJuego(Juego juego) {
        game = juego;
    }

    public boolean getTurno() {
        return turnoBlancas;
    }
}
