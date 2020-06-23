/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 * @since 22/06/2020
 */

import java.util.ArrayList;

public class FichaRey implements Algoritmo {

    private int v1;

    /**
     * @param celda Celda a la que se le calcularán sus celdas contiguas para moverse.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas contiguas para moverse.
     */
    @Override
    public ArrayList<Celda> celdasContiguas(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> adyacentes = new ArrayList<>();

        v1 = 1;

        //Diagonal arriba a la izquierda.
        while(celda.getFila()-v1>=0 && celda.getColumna()-v1>=0 && !matriz[celda.getFila()-v1][celda.getColumna()-v1].hayFicha()) {
            adyacentes.add(matriz[celda.getFila()-v1][celda.getColumna()-v1]);
            v1++;
        }
        
        v1 = 1;

        //Diagonal abajo a la derecha.
        while(celda.getFila()+v1<=7 && celda.getColumna()+v1<=7 && !matriz[celda.getFila()+v1][celda.getColumna()+v1].hayFicha()) {
            adyacentes.add(matriz[celda.getFila()+v1][celda.getColumna()+v1]);
            v1++;
        }

        v1 = 1;

        //Diagonal arriba a la derecha.
        while(celda.getFila()-v1>=0 && celda.getColumna()+v1<=7 && !matriz[celda.getFila()-v1][celda.getColumna()+v1].hayFicha()) {
            adyacentes.add(matriz[celda.getFila()-v1][celda.getColumna()+v1]);
            v1++;
        }

        v1 = 1;

        //Diagonal abajo a la izquierda.
        while(celda.getFila()+v1<=7 && celda.getColumna()-v1>=0 && !matriz[celda.getFila()+v1][celda.getColumna()-v1].hayFicha()) {
            adyacentes.add(matriz[celda.getFila()+v1][celda.getColumna()-v1]);
            v1++;
        }

        return adyacentes;
    }

    /**
     * @param celda Celda a la que se le calcularán las celdas para moverse y eliminar pieza enemiga.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas para moverse y eliminar ficha enemiga.
     */
    @Override
    public ArrayList<Celda> celdasEliminar(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> eliminar = new ArrayList<>();

        v1 = 1;

        //Diagonal arriba a la izquierda.
        while(celda.getFila()-v1>=1 && celda.getColumna()-v1>=1) {
            if(matriz[celda.getFila()-v1][celda.getColumna()-v1].hayFicha() && matriz[celda.getFila()-v1][celda.getColumna()-v1].getFicha().getColor()!=celda.getFicha().getColor()) {
                if(!matriz[celda.getFila()-v1-1][celda.getColumna()-v1-1].hayFicha()) {
                    eliminar.add(matriz[celda.getFila()-v1-1][celda.getColumna()-v1-1]);
                    break;
                } else break;
            } else {
                v1++;
            }
        }

        v1 = 1;

        //Diagonal arriba a la derecha.
        while(celda.getFila()-v1>=1 && celda.getColumna()+v1<=6) {
            if(matriz[celda.getFila()-v1][celda.getColumna()+v1].hayFicha()  && matriz[celda.getFila()-v1][celda.getColumna()+v1].getFicha().getColor()!=celda.getFicha().getColor()) {
                if(!matriz[celda.getFila()-v1-1][celda.getColumna()+v1+1].hayFicha()) {
                    eliminar.add(matriz[celda.getFila()-v1-1][celda.getColumna()+v1+1]);
                    break;
                } else break;
            } else {
                v1++;
            }
        }

        v1 = 1;

        //Diagonal abajo a la izquierda.
        while(celda.getFila()+v1<=6 && celda.getColumna()-v1>=1) {
            if(matriz[celda.getFila()+v1][celda.getColumna()-v1].hayFicha()  && matriz[celda.getFila()+v1][celda.getColumna()-v1].getFicha().getColor()!=celda.getFicha().getColor()) {
                if(!matriz[celda.getFila()+v1+1][celda.getColumna()-v1-1].hayFicha()) {
                    eliminar.add(matriz[celda.getFila()+v1+1][celda.getColumna()-v1-1]);
                    break;
                } else break;
            } else {
                v1++;
            }
        }

        v1 = 1;

        //Diagonal abajo a la derecha.
        while(celda.getFila()+v1<=6 && celda.getColumna()+v1<=6) {
            if(matriz[celda.getFila()+v1][celda.getColumna()+v1].hayFicha()  && matriz[celda.getFila()+v1][celda.getColumna()+v1].getFicha().getColor()!=celda.getFicha().getColor()) {
                if(!matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1].hayFicha()) {
                    eliminar.add(matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1]);
                    break;
                } else break;
            } else {
                v1++;
            }
        }

        return eliminar;
    }
}