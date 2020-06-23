/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

import java.util.ArrayList;

public interface Algoritmo {

    /**
     * @param celda Celda a la que se le calcularán las casillas contiguas para moverse.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas contiguas para moverse.
     */
    public ArrayList<Celda> celdasContiguas(Celda celda, Celda[][] matriz);

    /**
     * @param celda Celda a la que se le calcularán las casillas para eliminar pieza contraria.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas contiguas para moverse y eliminar pieza contraria.
     */
    public ArrayList<Celda> celdasEliminar(Celda celda, Celda[][] matriz);
}