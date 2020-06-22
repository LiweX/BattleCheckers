import java.util.ArrayList;

public abstract class ComportamientoFicha {
    
    private Algoritmo comportamiento;

    public void setComportamiento(Algoritmo comportamiento) {
        this.comportamiento = comportamiento;
    }

    public ArrayList<Celda> celdasContiguas(Celda celda,Celda[][] matriz) {
        return this.comportamiento.celdasContiguas(celda,matriz);
    }

    public ArrayList<Celda> celdasEliminar(Celda celda,Celda[][] matriz) {
        return this.comportamiento.celdasEliminar(celda,matriz);
    }
}