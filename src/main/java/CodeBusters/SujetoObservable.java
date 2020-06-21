package codebusters;

public interface SujetoObservable {

    /*
     *  @param: celda: Celda a pintar.
     */
    public void notificarPintar(Celda celda);
    public void notificarMover(Celda celda);
}