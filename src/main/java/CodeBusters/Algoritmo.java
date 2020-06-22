/**
 * @author  Luna, Lihué Leandro
 * @author  Merino, Mateo
 * @author  Bonino, Francisco Ignacio
 */

import java.util.ArrayList;

public interface Algoritmo {

    public ArrayList<Celda> celdasContiguas(Celda celda,Celda[][] matriz);
    public ArrayList<Celda> celdasEliminar(Celda celda,Celda[][] matriz);
}