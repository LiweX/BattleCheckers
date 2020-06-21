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

    /*
     *  @param: tablero: Tablero asignado al juego.
     */
    public Juego(Tablero tablero,Estadisticas estadisticas) {
        this.tablero = tablero;
        this.estadisticas = estadisticas;
        adyacentes = new ArrayList<Celda>();
    }

    //Setters
    /*
     *  @param  o: Observador a agregar.
     */
    
    public void addObserver(Observador o) {
        observadores.add(o);
    }

    /*
     *  @param celda: Celda que debe ser pintada.
     */
    @Override
    public void notificarPintar(Celda celda) {
        tablero.updatePintar(celda);
    }
    @Override
    public void notificarMover(Celda destino){
        tablero.updateMover(celdaSeleccionada, destino);
    }
    @Override
    public void notificarHistorial(String movimiento){
        estadisticas.updateHistorial(movimiento);
    }
    /*
    */
    public ArrayList<Celda> celdasContiguas(Celda celda) {
        adyacentes.clear();

        if(celda.getFicha().getColor()==ColorFicha.BLANCA) {
            if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha()) {
                adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1]);
            }

            if(!tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1].hayFicha()) {
                adyacentes.add(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()+1]);
            }
            
            return adyacentes;
            
        } else {
            if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1].hayFicha()) {
                adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()-1]);
            }
    
            if(!tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1].hayFicha()) {
                adyacentes.add(tablero.getCeldas()[celda.getFila()-1][celda.getColumna()+1]);
            }
            
            return adyacentes;
        }
     
            //    if(tablero.getCeldas()[celda.getFila()+1][celda.getColumna()-1].hayFicha() && !tablero.getCeldas()[celda.getFila()+2][celda.getColumna()-2].hayFicha()){
        //        eliminar.add   }
    }
    }
    public ArrayList<Celda> celdasEliminar(Celda celda){
       eliminar.clear();
       if(celda.getFicha().getColor()==ColorFicha.BLANCA){}

   }
    
    public void seleccionarFicha(Celda celda) {
        ArrayList<Celda> contiguas = celdasContiguas(celda);
        celdaSeleccionada=celda;


        for(Celda casilla : contiguas)
            notificarPintar(casilla);
    }
    public void moverFicha(Celda celda){
     //   if(celda.getBackground().equals(new Color(0,0,0))){
    //        JOptionPane.showMessageDialog(null, "No puedes moverte ahi");
     //   }
        for(Celda casilla : adyacentes){
            notificarPintar(casilla);
        }
        notificarMover(celda);
        String movimiento = "Hubo Mooving/n";
        notificarHistorial(movimiento);
        
    }
    
