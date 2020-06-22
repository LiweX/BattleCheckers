/**
 * @author  Luna, Lihué Leandro
 * @author  Merino, Mateo
 * @author  Bonino, Francisco Ignacio
 */

public interface ObservadorTablero {

    /**
     *  @param  celda   Celda a pintar para moverse.
     */
    public void updatePintarMover(Celda celda);

    /**
     * @param   celda   Celda a pintar para moverse y comer.
     */
    public void updatePintarComer(Celda celda);

    /**
     * @param   origen  Celda origen cuya ficha se va a mover.
     * @param   destino Celda destino donde va a caer la ficha de la celda 'origen'.
     */
    public void updateMover(Celda origen, Celda destino);

    /**
     * @param   origen  Celda origen cuya ficha va a moverse y comer.
     * @param   destino Celda destino donde va a caer la ficha de la celda 'origen'.
     */
    public void updateComer(Celda origen, Celda destino);
}