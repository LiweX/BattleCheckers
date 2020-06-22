package codebusters;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Juego implements SujetoObservable {

    Estadisticas estadisticas;
    Tablero tablero;
    ArrayList<Celda> adyacentes;
    ArrayList<Celda> eliminar;
    int fichasJ1,fichasJ2;
    ArrayList<Observador> observadores;
    Celda celdaSeleccionada;

    public Juego(Tablero tablero,Estadisticas estadisticas) {
        this.tablero = tablero;
        this.estadisticas = estadisticas;
        adyacentes = new ArrayList<Celda>();
        eliminar = new ArrayList<Celda>();
    }

    //Setters
    /**
     *  @param  o: Observador a agregar.
     */
    public void addObserver(Observador o) {
        observadores.add(o);
    }

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
    
    public ArrayList<Celda> celdasEliminar(Celda celda) {
        eliminar.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(celda.getColumna()==0) {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);                                   //Primero: Me fijo si border mode (Columna 0)
                }
                return eliminar;
            } else if(celda.getColumna()==7) {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);                                   //Segundo: Me fijo si border mode (Columna 7)
                }
                return eliminar;
            } else {
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);
                }
                            
                if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);
                }
                return eliminar;
            }
        } else {
            if(celda.getColumna()==0) {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2]);                                 //Primero: Me fijo si border mode (Columna 0)
                }
                return eliminar;
            } else if(celda.getColumna()==7) {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2]);                                 //Segundo: Me fijo si border mode (Columna 7)
                }
                return eliminar;
            } else {
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()-2]);
                }
    
                if(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2].hayFicha()) {
                    eliminar.add(tablero.getCeldas()[celda.getFila()-2][celda.getColumna()+2]);
                }
                return eliminar;
            }
        }
    }
    
    public void seleccionarFicha(Celda celda) {
        ArrayList<Celda> contiguas = celdasContiguas(celda);
        ArrayList<Celda> eliminaciones = celdasEliminar(celda);
        
        if(celda.equals(celdaSeleccionada)) {
            for(Celda casilla : contiguas)
                notificarPintarMover(casilla);
                
            for(Celda casilla : eliminaciones)
                notificarPintarComer(casilla);
        } else {
            celdaSeleccionada = celda;

            if(contiguas.isEmpty() && eliminaciones.isEmpty()) {
                tablero.toggleMoviendo();
            } else {
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

    public void moverFicha(Celda celda) {
        for(Celda casilla : adyacentes)
            notificarPintarMover(casilla);

        for(Celda casilla : eliminar)
            notificarPintarComer(casilla);

        notificarMover(celda);

        String movimiento = Integer.toString(celdaSeleccionada.getFila()) + "," + Integer.toString(celdaSeleccionada.getColumna()) + " >> " + Integer.toString(celda.getFila()) + "," + Integer.toString(celda.getColumna())+"\n";
        
        notificarHistorial(movimiento);
    }

    public void comerFicha(Celda celda) {
        for(Celda casilla : eliminar)
            notificarPintarComer(casilla);

        for(Celda casilla : adyacentes)
            notificarPintarMover(casilla);
        
        notificarComer(celda);
    }

    public Celda getCeldaAnterior() {
        return celdaSeleccionada;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }
}