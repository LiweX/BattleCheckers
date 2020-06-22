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
    public void notificarPintar(Celda celda) {
        tablero.updatePintar(celda);
    }

    @Override
    public void notificarMover(Celda destino) {
        tablero.updateMover(celdaSeleccionada, destino);
    }

    @Override
    public void notificarHistorial(String movimiento) {
        estadisticas.updateHistorial(movimiento);
    }
    
    public ArrayList<Celda> celdasContiguas(Celda celda) {
        adyacentes.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {  //Corroboración celda adyacente abajo a la izquierda.
                adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1]);
            }

            if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente abajo a la derecha.
                adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1]);
            }
            
            return adyacentes;
        } else {
            if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha()) { //Corroboración celda adyacente arriba a la izquierda.
                adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1]);
            }
    
            if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha()) { //Corroboración celda adyacente arriba a la derecha.
                adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1]);
            }
            
            return adyacentes;
        }
    }
    
    /*public ArrayList<Celda> celdasEliminar(Celda celda){
        eliminar.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha()) {
                eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);
            }
                        
            if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha()) {
                eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);
            }

            return eliminar;
        } else {
            if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha()) {
                eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2]);
            }

            if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2].hayFicha()) {
                eliminar.add(tablero.getCeldas()[celda.getFila()+2][celda.getColumna()+2]);
            }
        }
        
        return eliminar;
    }*/
    
    public void seleccionarFicha(Celda celda) {
        ArrayList<Celda> contiguas = celdasContiguas(celda);
        
        if(celda.equals(celdaSeleccionada)) {
            System.out.println("Las celdas son las mismas che");
            for(Celda casilla : contiguas)
                notificarPintar(casilla);
        } else {
            
            //ArrayList<Celda> eliminaciones = celdasEliminar(celda);
            
            celdaSeleccionada = celda;

            if(contiguas.isEmpty()) { //&& eliminaciones.isEmpty()
                tablero.toggleMoviendo();
            } else {
                if(!contiguas.isEmpty()) {
                    for(Celda casilla : contiguas)
                        notificarPintar(casilla);
                }
                
                /*if(!eliminaciones.isEmpty()) {
                    //TODO comer
                }*/
            }
        }
    }

    public void moverFicha(Celda celda) {
        for(Celda casilla : adyacentes)
            notificarPintar(casilla);

        notificarMover(celda);

        String movimiento = Integer.toString(celdaSeleccionada.getFila()) + "," + Integer.toString(celdaSeleccionada.getColumna()) + " >> " + Integer.toString(celda.getFila()) + "," + Integer.toString(celda.getColumna())+"\n";
        
        notificarHistorial(movimiento);
    }

    public Celda getCeldaAnterior() {
        return celdaSeleccionada;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }
}