package codebusters;

public class Jugador {

    private String nombre;
    private int fichasVivas, fichasComidas;

    /*
        @param  nombre: Nombre del jugador.
    */
    public Jugador(String nombre) {
        this.nombre = nombre;

        fichasVivas = 12;
        fichasComidas = 0;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getFichasVivas() {
        return fichasVivas;
    }

    public int getComidas() {
        return fichasComidas;
    }
}