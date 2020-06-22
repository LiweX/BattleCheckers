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

        String movimiento = Integer.toString(celdaSeleccionada.getFila()) + "," + Integer.toString(celdaSeleccionada.getColumna()) + " >> " + Integer.toString(celda.getFila()) + "," + Integer.toString(celda.getColumna())+"\n";
        
        notificarHistorial(movimiento);
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
