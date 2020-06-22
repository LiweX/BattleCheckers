/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 * @since   22/06/2020
 */

import java.util.ArrayList;

public class FichaRey implements Algoritmo {

    @Override
    public ArrayList<Celda> celdasContiguas(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> adyacentes = new ArrayList<>();

        //Diagonal arriba a la izquierda.
        while(celda.getFila()!=-1 && celda.getColumna()!=-1) {

        }

        return adyacentes;
    }

    @Override
    public ArrayList<Celda> celdasEliminar(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> eliminar = new ArrayList<>();
        //aca va el algoritmo que hay que craftear de los reyes
        return eliminar;
    }
}