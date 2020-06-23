/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 * @since   22/06/2020
 */

import java.util.ArrayList;

public class FichaRey implements Algoritmo {

    private int v1;

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

    @Override
    public ArrayList<Celda> celdasEliminar(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> eliminar = new ArrayList<>();

        v1 = 1;

        //Diagonal arriba a la izquierda.
        while(celda.getFila()-v1>=1 && celda.getColumna()-v1>=1) {
            if(matriz[celda.getFila()-v1][celda.getColumna()-v1].hayFicha()) {
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
            if(matriz[celda.getFila()-v1][celda.getColumna()+v1].hayFicha()) {
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
            if(matriz[celda.getFila()+v1][celda.getColumna()-v1].hayFicha()) {
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
            if(matriz[celda.getFila()+v1][celda.getColumna()+v1].hayFicha()) {
                if(!matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1].hayFicha()) {
                    eliminar.add(matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1]);
                    break;
                } else break;
            } else {
                v1++;
            }
        }

        // //Diagonal arriba a la derecha.
        // while(celda.getFila()-v1>=1 && celda.getColumna()+v1<=7) {
        //     if(!matriz[celda.getFila()-v1][celda.getColumna()+v1].hayFicha()) {
        //         v1++;
        //     } else {
        //         if(!matriz[celda.getFila()-v1-1][celda.getColumna()+v1+1].hayFicha()) {
        //             eliminar.add(matriz[celda.getFila()-v1-1][celda.getColumna()+v1+1]);
        //         }
        //     }
        // }

        // v1 = 1;

        // //Diagonal abajo a la izquierda.
        // while(celda.getFila()+v1<=7 && celda.getColumna()-v1>=1) {
        //     if(!matriz[celda.getFila()+v1][celda.getColumna()-v1].hayFicha()) {
        //         v1++;
        //     } else {
        //         if(!matriz[celda.getFila()+v1+1][celda.getColumna()-v1-1].hayFicha()) {
        //             eliminar.add(matriz[celda.getFila()+v1-1][celda.getColumna()-v1-1]);
        //         }
        //     }
        // }

        // v1 = 1;

        // //Diagonal abajo a la derecha.
        // while(celda.getFila()+v1<=7 && celda.getColumna()+v1<=7) {
        //     if(!matriz[celda.getFila()+v1][celda.getColumna()+v1].hayFicha()) {
        //         v1++;
        //     } else {
        //         if(!matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1].hayFicha()) {
        //             eliminar.add(matriz[celda.getFila()+v1+1][celda.getColumna()+v1+1]);
        //         }
        //     }
        // }

        return eliminar;
    }
}