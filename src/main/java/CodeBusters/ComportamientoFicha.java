/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

import java.util.ArrayList;

public abstract class ComportamientoFicha {
    
    private Algoritmo comportamiento;

    /**
     * @param comportamiento Comportamiento que tendrá la ficha para moverse y comer.
     */
    public void setComportamiento(Algoritmo comportamiento) {
        this.comportamiento = comportamiento;
    }

    /**
     * @param celda Celda a la que se le calcularán sus celdas contiguas para moverse.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas contiguas para moverse.
     */
    public ArrayList<Celda> celdasContiguas(Celda celda,Celda[][] matriz) {
        return this.comportamiento.celdasContiguas(celda,matriz);
    }

    /**
     * @param celda Celda a la que se le calcularán las celdas para moverse y eliminar pieza enemiga.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas para moverse y eliminar ficha enemiga.
     */
    public ArrayList<Celda> celdasEliminar(Celda celda,Celda[][] matriz) {
        return this.comportamiento.celdasEliminar(celda,matriz);
    }
}