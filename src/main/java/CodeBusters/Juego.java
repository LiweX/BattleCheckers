package CodeBusters;

import java.util.ArrayList;

public class Juego implements SujetoObservable {

    Estadisticas estadisticas;
    Tablero tablero;
    ArrayList<Celda> adyacentes;
    int fichasJ1,fichasJ2;
    ArrayList<Observador> observadores;

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    //Setters
    /*
        @param  o: Observador a agregar.
    */
    // public void moverFicha(int x,int y){
    //       celdasContiguas(x,y)
    //       for(celda : adyacentes)
    //           notificarPintar(celda)
    // }
    public void addObserver(Observador o) {
        observadores.add(o);
    }

    @Override
    public void notificarPintar(Celda celda) {
        observadores.get(1).updatePintar(celda);
    }

    public ArrayList<Celda> celdasContiguas(int x, int y) {
           
    }
  
}