/**
 * @author Luna, Lihué Leandro
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 */

public interface ObservadorEstadisticas {

    /**
     * @param movimiento Movimiento a desplegar en el historial.
     */
    public void updateHistorial(String movimiento);

    /**
     * @param fichasJ1 Cantidad de fichas comidas por el jugador de fichas rojas.
     * @param fichasJ2 Cantidad de fichas comidas por el jugador de fichas blancas.
     */
    public void updateComidas(int fichasJ1, int fichasJ2);
}