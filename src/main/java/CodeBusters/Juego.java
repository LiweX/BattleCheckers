/**
 * @author  Luna, Lihué Leandro
 *          Merino, Mateo
 *          Bonino, Francisco Ignacio
 */
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
     * @param   celda:  Celda seleccionada. Se pintarán las casillas para moverse o comer desde esta celda.
     */
    public void seleccionarFicha(Celda celda) {
        adyacentes = celda.getFicha().celdasContiguas(celda, tablero.getCeldas());
        eliminar = celda.getFicha().celdasEliminar(celda, tablero.getCeldas());

        if(celda.equals(celdaSeleccionada)) {        //Despintar y deseleccionar.
            for(Celda casilla : adyacentes)
                notificarPintarMover(casilla);
                
            for(Celda casilla : eliminar)
                notificarPintarComer(casilla);
            
            if(tablero.getMoviendo()) {
                tablero.toggleMoviendo();
            }
        } else {
            celdaSeleccionada = celda;

            if(!adyacentes.isEmpty() || !eliminar.isEmpty()) { //Si hay casillas para mover o comer, pongo porMover en true y pinto las celdas.
                tablero.toggleMoviendo();

                if(!adyacentes.isEmpty()) {
                    for(Celda casilla : adyacentes)
                        notificarPintarMover(casilla);
                }
                
                if(!eliminar.isEmpty()) {
                    for(Celda casilla : eliminar)
                        notificarPintarComer(casilla);
                }
            }
        }
    }

    /**
     * @param   celda:  Celda donde está la ficha que queremos mover.
     */
    public void moverFicha(Celda celda) {
        for(Celda casilla : adyacentes)
            notificarPintarMover(casilla);

        for(Celda casilla : eliminar)
            notificarPintarComer(casilla);

        notificarMover(celda);

        String nombreJugador;

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            nombreJugador = estadisticas.getNombreJugador1();
        } else {
            nombreJugador = estadisticas.getNombreJugador2();
        }

        String movimiento = nombreJugador + " movió: " + getLetra(celdaSeleccionada.getFila()) +
                            Integer.toString(celdaSeleccionada.getColumna()+1) + " >> " +
                            getLetra(celda.getFila()) +
                            Integer.toString(celda.getColumna()+1)+"\n";
        
        notificarHistorial(movimiento);
    }

    /**
     * @param   num Número de fila. Será cambiado por su letra correspondiente.
     * @return  Letra correspondiente a la fila.
     */
    public String getLetra(int num) {
        switch(num) {
            case 0: {
                return "A";
            }
            case 1: {
                return "B";
            }
            case 2: {
                return "C";
            }
            case 3: {
                return "D";
            }
            case 4: {
                return "E";
            }
            case 5: {
                return "F";
            }
            case 6: {
                return "G";
            }
            default: {
                return "H";
            }
        }
    }

    /**
     * @param   celda:  Celda donde está la ficha que quiere moverse y comer una ficha enemiga.
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

        String nombreJugador;

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            nombreJugador = estadisticas.getNombreJugador1();
        } else {
            nombreJugador = estadisticas.getNombreJugador2();
        }

        String movimiento = nombreJugador + " eliminó: " + getLetra(celdaSeleccionada.getFila()) +
                            Integer.toString(celdaSeleccionada.getColumna()+1) + " >> " +
                            getLetra(celda.getFila()) +
                            Integer.toString(celda.getColumna()+1)+"\n";
        
        notificarHistorial(movimiento);

        if(fichasJ2==12) {
            PartidaFin fin = new PartidaFin("¡Ganó el jugador " + estadisticas.getNombreJugador1() + "!",estadisticas,tablero);
        } else if(fichasJ1==12) {
            PartidaFin fin = new PartidaFin("¡Ganó el jugador " + estadisticas.getNombreJugador2() + "!",estadisticas,tablero);
        }
    }

    //Getters
    /**
     * @return  Celda seleccionada en el click anterior.
     */
    public Celda getCeldaAnterior() {
        return celdaSeleccionada;
    }

    /**
     * @return  Objeto estadísticas del juego.
     */
    public Estadisticas getEstadisticas() {
        return estadisticas;
    }
}
