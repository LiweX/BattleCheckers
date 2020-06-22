package codebusters;

public interface Observador {

    /*
     *  @param: celda: Celda a pintar.
     */
    public void updatePintar(Celda celda);
    public void updateMover(Celda origen,Celda destino);
    public void updateHistorial(String movimiento);
}