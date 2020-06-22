import javax.swing.JButton;

public class Celda extends JButton {

    private boolean hayFicha;
    private int fila, columna;
    private Ficha ficha;
    
    /*
     *  @param  x, y: Coordenadas de la celda.
     *          hayFicha: Estado inicial de ocupación de la celda.
     */
    public Celda(int x, int y, boolean hayFicha, Ficha ficha) {
        super();
        
        fila = x;
        columna = y;

        hayFicha(hayFicha);
        setFicha(ficha);
    }

    public Celda(int x, int y, boolean hayFicha) {
        super();
        
        fila = x;
        columna = y;

        hayFicha(hayFicha);
    }

    //Setters
    /*
     *  @param  hayFicha: Indica si hay ficha en la celda.
     */
    public void hayFicha(boolean hayFicha) {
        this.hayFicha = hayFicha;
    }

    /*
     *  @param  ficha: Ficha a setear en esta celda.
     */
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    //Getters
    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean hayFicha() {
        return hayFicha;
    }

    public Ficha getFicha() {
        return ficha;
    }
}
