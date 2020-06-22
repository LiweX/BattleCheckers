public interface ObservadorTablero {

    /*
     *  @param: celda: Celda a pintar.
     */
    public void updatePintarMover(Celda celda);
    public void updatePintarComer(Celda celda);
    public void updateMover(Celda origen,Celda destino);
    public void updateComer(Celda origen, Celda destino);
}
