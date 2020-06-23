/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

public interface SujetoObservable {

    /**
     *  @param  celda   Celda a pintar (moverse).
     */
    public void notificarPintarMover(Celda celda);

    /**
     *  @param  celda   Celda a pintar (moverse y comer).
     */
    public void notificarPintarComer(Celda celda);

    /**
     * @param   celda   Celda cuya ficha se va a mover.
     */
    public void notificarMover(Celda celda);

    /**
     * @param   celda   Celda cuya ficha va a moverse y comer.
     */
    public void notificarComer(Celda celda);

    /**
     * @param   movimiento  Movimiento a desplegar en el historial de movimientos.
     */
    public void notificarHistorial(String movimiento);

    /**
     * @param   fichasJ1    Fichas comidas por el jugador 2.
     * @param   fichasJ2    Fichas comidas por el jugador 1.
     */
    public void notificarComidas(int fichasJ1, int fichasJ2);
}