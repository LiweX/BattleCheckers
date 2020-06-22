package codebusters;

public interface SujetoObservable {

    /*
     *  @param: celda: Celda a pintar.
     */
    public void notificarPintarMover(Celda celda);
    public void notificarPintarComer(Celda celda);
    public void notificarMover(Celda celda);
    public void notificarComer(Celda celda);
    public void notificarHistorial(String movimiento);
    public void notificarComidas(int fichasJ1,int fichasJ2);
}