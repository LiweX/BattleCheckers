/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 */

package codebusters;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Juego implements SujetoObservable {

    Estadisticas estadisticas;
    Tablero tablero;
    ArrayList<Celda> adyacentes;
    ArrayList<Celda> eliminar;
    int fichasJ1,fichasJ2;
    Celda celdaSeleccionada;
    
    /**
     * @param   tablero: Tablero de juego a asociar.
     * @param   estadisticas: Estadísticas del juego.
     */
    public Juego(Tablero tablero, Estadisticas estadisticas) {
        this.tablero = tablero;
        this.estadisticas = estadisticas;
        adyacentes = new ArrayList<Celda>();
        eliminar = new ArrayList<Celda>();
        fichasJ1 = 0;
        fichasJ2 = 0;
    }

    //Setters
  
    //Overrides
    /**
     *  @param celda: Celda que debe ser pintada.
     */
    @Override
    public void notificarPintarMover(Celda celda) {
        tablero.updatePintarMover(celda);
    }

    @Override
    public void notificarPintarComer(Celda celda) {
        tablero.updatePintarComer(celda);
    }

    @Override
    public void notificarMover(Celda destino) {
        tablero.updateMover(celdaSeleccionada, destino);
    }

    @Override
    public void notificarComer(Celda destino) {
        tablero.updateComer(celdaSeleccionada, destino);
    }

    @Override
    public void notificarHistorial(String movimiento) {
        estadisticas.updateHistorial(movimiento);
    }

    @Override
    public void notificarComidas(int fichas1, int fichas2) {
        estadisticas.updateComidas(fichas1,fichas2);
    }
    
    /**
     * @param   celda: Celda que se toma como referencia para obtener sus celdas contiguas según el color de la ficha que tenga.
     * @return  adyacentes: Lista de celdas contiguas.
     */
    public ArrayList<Celda> celdasContiguas(Celda celda) {
        adyacentes.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(celda.getColumna()==0) {
                if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha()) {  //Primero: Me fijo si estoy en el borde izquierdo (Columna 0)
                    adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1]);
                }
                return adyacentes;
            } else if(celda.getColumna()==7) {
                if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {  //Segundo: Me fijo si estoy en el borde derecho (Columna 7)
                    adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1]);
                }
                return adyacentes;
            } else {
                if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {  //Corroboración celda adyacente abajo a la izquierda.
                    adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1]);
                }
    
                if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente abajo a la derecha.
                    adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1]);
                }
                return adyacentes;
            }
        } else {
            if(celda.getColumna()==0) {
                if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha()) {  //Primero: Me fijo si estoy en el borde izquierdo (Columna 0)
                    adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1]);
                }
                return adyacentes;
            } else if(celda.getColumna()==7) {
                if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha()) {  //Segundo: Me fijo si estoy en el borde derecho (Columna 7)
                    adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1]);
                }
                return adyacentes;
            } else {
                if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha()) {  //Corroboración celda adyacente abajo a la izquierda.
                    adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1]);
                }
    
                if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente abajo a la derecha.
                    adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1]);
                }
                return adyacentes;
            }
        }
    }
    
    /**
     * @param   celda: Celda que se toma como referencia para obtener las celdas posibles donde podemos movernos para comer una pieza enemiga.
     * @return  eliminar: Lista de celdas para moverse y comer pieza enemiga.
     */
    public ArrayList<Celda> celdasEliminar(Celda celda) {
        eliminar.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(celda.getColumna()==0 || celda.getColumna()==1) {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha() && tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);                                   //Primero: Me fijo si border mode (Columna 0)
                }
                return eliminar;
            } else if(celda.getColumna()==7 || celda.getColumna()==6) {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha() && tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);                                   //Segundo: Me fijo si border mode (Columna 7)
                }
                return eliminar;
            } else {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha() && tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);
                }
                            
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha() && tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.BLANCA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);
                }
                return eliminar;
            }
        } else {
            if(celda.getColumna()==0 || celda.getColumna()==1) {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2].hayFicha() && tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.ROJA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2]);                                 //Primero: Me fijo si border mode (Columna 0)
                }
                return eliminar;
            } else if(celda.getColumna()==7 || celda.getColumna()==6) {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2].hayFicha() && tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.ROJA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2]);                                 //Segundo: Me fijo si border mode (Columna 7)
                }
                return eliminar;
            } else {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2].hayFicha() && tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].getFicha().getColor()!=ColorFicha.ROJA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2]);
                }
    
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2].hayFicha() && tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].getFicha().getColor()!=ColorFicha.ROJA) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2]);
                }
                return eliminar;
            }
        }
    }
    
    /**
     * @param   celda: Celda seleccionada. Se pintarán las casillas para moverse o comer desde esta celda.
     */
    public void seleccionarFicha(Celda celda) {
        ArrayList<Celda> contiguas = celdasContiguas(celda);
        ArrayList<Celda> eliminaciones = celdasEliminar(celda);

        if(celda.equals(celdaSeleccionada)) {        //Despintar y deseleccionar.
            for(Celda casilla : contiguas)
                notificarPintarMover(casilla);
                
            for(Celda casilla : eliminaciones)
                notificarPintarComer(casilla);
            
            tablero.toggleMoviendo();

            celdaSeleccionada = null;
        } else {
            celdaSeleccionada = celda;

            if(!contiguas.isEmpty() || !eliminaciones.isEmpty()) { //Si hay casillas para mover o comer, pongo porMover en true y pinto las celdas.
                tablero.toggleMoviendo();

                if(!contiguas.isEmpty()) {
                    for(Celda casilla : contiguas)
                        notificarPintarMover(casilla);
                }
                
                if(!eliminaciones.isEmpty()) {
                    for(Celda casilla : eliminaciones)
                        notificarPintarComer(casilla);
                }
            }
        }
    }

    /**
     * @param   celda: Celda donde está la ficha que queremos mover.
     */
    public void moverFicha(Celda celda) {
        for(Celda casilla : adyacentes)
            notificarPintarMover(casilla);

        for(Celda casilla : eliminar)
            notificarPintarComer(casilla);

        notificarMover(celda);

        String movimiento = Integer.toString(celdaSeleccionada.getFila()) + "," + Integer.toString(celdaSeleccionada.getColumna()) + " >> " + Integer.toString(celda.getFila()) + "," + Integer.toString(celda.getColumna())+"\n";
        
        notificarHistorial(movimiento);
    }

    /**
     * @param   celda: Celda donde está la ficha que quiere moverse y comer una ficha enemiga.
     */
    public void comerFicha(Celda celda) {
        for(Celda casilla : eliminar)
            notificarPintarComer(casilla);

        for(Celda casilla : adyacentes)
            notificarPintarMover(casilla);
  
        notificarComer(celda);

        if(tablero.getTurno()) {
            fichasJ2++;
        } else {
            fichasJ1++;
        }

        notificarComidas(fichasJ1,fichasJ2);
    }

    //Getters
    /**
     * @return  celdaSeleccionada: Celda seleccionada en el click anterior.
     */
    public Celda getCeldaAnterior() {
        return celdaSeleccionada;
    }

    /**
     * @return estadisticas: Objeto estadísticas del juego.
     */
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }
}