/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

import javax.swing.JButton;

public class Celda extends JButton{

    private boolean hayFicha;
    private int fila, columna;
    private Ficha ficha;
    
    /**
     * Constructor de celda que posee una ficha en sí.
     * @param x,y Coordenadas de la celda en el tablero.  
     * @param hayFicha Indica si hay una ficha o no en la celda.
     * @param ficha Ficha que hay en la celda ('null' si no hay).
     */
    public Celda(int x, int y, boolean hayFicha, Ficha ficha) {
        super();
        
        fila = x;
        columna = y;

        hayFicha(hayFicha);
        setFicha(ficha);
    }

    /**
     * Constructor de celda que no posee una ficha.
     * @param x,y Coordenadas de la celda en el tablero.
     */
    public Celda(int x, int y) {
        super();
        
        fila = x;
        columna = y;

        hayFicha(false);
    }

    //-------------------Setters-------------------

    /**
     *  @param hayFicha Indica si hay ficha en la celda.
     */
    public void hayFicha(boolean hayFicha) {
        this.hayFicha = hayFicha;
    }

    /**
     *  @param ficha Ficha a setear en esta celda.
     */
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    //-------------------Getters-------------------

    /**
     * @return Número de columna de la celda.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return Número de fila de la celda.
     */
    public int getFila() {
        return fila;
    }

    /**
     * @return Si hay ficha o no en la celda.
     */
    public boolean hayFicha() {
        return hayFicha;
    }

    /**
     * @return Ficha que está en la celda.
     */
    public Ficha getFicha() {
        return ficha;
    }
}