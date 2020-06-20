package CodeBusters;

import javax.swing.JButton;

public class Celda extends JButton {

    private boolean hayFicha;
    private int coordenadaX, coordenadaY;
    
    /*
        @param  x, y: Coordenadas de la celda.
                hayFicha: Estado inicial de ocupación de la celda.
    */
    public Celda(int x, int y, boolean hayFicha){
        super();
        
        coordenadaX = x;
        coordenadaY = y;

        setFicha(hayFicha);
    }

    //Setters
    /*
        @param  hayFicha: Indica si hay ficha en la celda.
    */
    public void setFicha(boolean hayFicha) {
        this.hayFicha = hayFicha;
    }

    //Getters
    public int getColumna(){
        return coordenadaX;
    }

    public int getFila(){
        return coordenadaY;
    }

    public boolean hayFicha() {
        return hayFicha;
    }
}