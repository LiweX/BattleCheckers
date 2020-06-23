import java.util.ArrayList;

public class FichaPeon implements Algoritmo {

    /**
     * @param celda Celda a la que se le calcularán sus celdas contiguas para moverse.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas contiguas para moverse.
     */
    @Override
    public ArrayList<Celda> celdasContiguas(Celda celda, Celda[][] matriz) {
        ArrayList<Celda> adyacentes = new ArrayList<>();
        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(celda.getColumna()==0) {
                if(!matriz[celda.getFila()+1][celda.getColumna()+1].hayFicha()) {  //Primero: Me fijo si estoy en el borde izquierdo (Columna 0)
                    adyacentes.add(matriz[celda.getFila()+1][celda.getColumna()+1]);
                }
                return adyacentes;
            } else if(celda.getColumna()==7) {
                if(!matriz[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {  //Segundo: Me fijo si estoy en el borde derecho (Columna 7)
                    adyacentes.add(matriz[celda.getFila()+1][celda.getColumna()-1]);
                }
                return adyacentes;
            } else {
                if(!matriz[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {  //Corroboración celda adyacente abajo a la izquierda.
                    adyacentes.add(matriz[celda.getFila()+1][celda.getColumna()-1]);
                }
    
                if(!matriz[celda.getFila()+1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente abajo a la derecha.
                    adyacentes.add(matriz[celda.getFila()+1][celda.getColumna()+1]);
                }
                return adyacentes;
            }
        } else {
            if(celda.getColumna()==0) {
                if(!matriz[celda.getFila()-1][celda.getColumna()+1].hayFicha()) {  //Primero: Me fijo si estoy en el borde izquierdo (Columna 0)
                    adyacentes.add(matriz[celda.getFila()-1][celda.getColumna()+1]);
                }
                return adyacentes;
            } else if(celda.getColumna()==7) {
                if(!matriz[celda.getFila()-1][celda.getColumna()-1].hayFicha()) {  //Segundo: Me fijo si estoy en el borde derecho (Columna 7)
                    adyacentes.add(matriz[celda.getFila()-1][celda.getColumna()-1]);
                }
                return adyacentes;
            } else {
                if(!matriz[celda.getFila()-1][celda.getColumna()-1].hayFicha()) {  //Corroboración celda adyacente abajo a la izquierda.
                    adyacentes.add(matriz[celda.getFila()-1][celda.getColumna()-1]);
                }
    
                if(!matriz[celda.getFila()-1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente abajo a la derecha.
                    adyacentes.add(matriz[celda.getFila()-1][celda.getColumna()+1]);
                }
                return adyacentes;
            }
        }
    }

    /**
     * @param celda Celda a la que se le calcularán las celdas para moverse y eliminar pieza enemiga.
     * @param matriz Matriz que representa el tablero.
     * @return Arreglo de celdas para moverse y eliminar ficha enemiga.
     */
    @Override
    public ArrayList<Celda> celdasEliminar(Celda celda, Celda[][] matriz){
        ArrayList<Celda> eliminar = new ArrayList<>();
        if(celda.getFicha().getColor()==ColorFicha.BLANCA && celda.getFila()<6) {
            if(celda.getColumna()==0 || celda.getColumna()==1) {
                if(matriz[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !matriz[celda.getFila()+2][celda.getColumna()+2].hayFicha() && matriz[celda.getFila()+1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(matriz[celda.getFila()+2][celda.getColumna()+2]);                                   //Primero: Me fijo si border mode (Columna 0)
                }
                return eliminar;
            } else if(celda.getColumna()==7 || celda.getColumna()==6) {
                if(matriz[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !matriz[celda.getFila()+2][celda.getColumna()-2].hayFicha() && matriz[celda.getFila()+1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(matriz[celda.getFila()+2][celda.getColumna()-2]);                                   //Segundo: Me fijo si border mode (Columna 7)
                }
                return eliminar;
            } else {
                if(matriz[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !matriz[celda.getFila()+2][celda.getColumna()-2].hayFicha() && matriz[celda.getFila()+1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(matriz[celda.getFila()+2][celda.getColumna()-2]);
                }                        
                if(matriz[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !matriz[celda.getFila()+2][celda.getColumna()+2].hayFicha() && matriz[celda.getFila()+1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(matriz[celda.getFila()+2][celda.getColumna()+2]);
                }
                return eliminar;
            }
        } else {
            if(celda.getFila()>1) {
                if(celda.getColumna()==0 || celda.getColumna()==1) {
                    if(matriz[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !matriz[celda.getFila()-2][celda.getColumna()+2].hayFicha() && matriz[celda.getFila()-1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.ROJA) {
                        eliminar.add(matriz[celda.getFila()-2][celda.getColumna()+2]);                                 //Primero: Me fijo si border mode (Columna 0)
                    }
                    return eliminar;
                } else if(celda.getColumna()==7 || celda.getColumna()==6) {
                    if(matriz[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !matriz[celda.getFila()-2][celda.getColumna()-2].hayFicha() && matriz[celda.getFila()-1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.ROJA) {
                        eliminar.add(matriz[celda.getFila()-2][celda.getColumna()-2]);                                 //Segundo: Me fijo si border mode (Columna 7)
                    }
                    return eliminar;
                } else {
                    if(matriz[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !matriz[celda.getFila()-2][celda.getColumna()-2].hayFicha() && matriz[celda.getFila()-1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.ROJA) {
                        eliminar.add(matriz[celda.getFila()-2][celda.getColumna()-2]);
                    }
                    if(matriz[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !matriz[celda.getFila()-2][celda.getColumna()+2].hayFicha() && matriz[celda.getFila()-1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.ROJA) {
                        eliminar.add(matriz[celda.getFila()-2][celda.getColumna()+2]);
                    }
                    return eliminar;
                }
            }
            return eliminar;
        }
    }
}