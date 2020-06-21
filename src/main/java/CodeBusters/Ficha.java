package codebusters;

import javax.swing.ImageIcon;

public class Ficha {

    private boolean esRey;
    private ColorFicha color;
    private ImageIcon icono;
   
    /*
     *  @param  coordenada: Coordenada inicial de la ficha.
     */
    public Ficha(ColorFicha color, ImageIcon icono) {
        setRey(false);                  //Toda ficha comienza siendo peón.
        this.color = color;
        this.icono = icono;
    }

    //Getters
    public boolean esRey() {
        return esRey;
    }

    public ColorFicha getColor(){
        return color;
    }

    public ImageIcon getIcon() {
        return icono;
    }

    //Setters
    /*
     * @param  esRey: Indica si la ficha es rey o peón.
     */
    public void setRey(boolean esRey) {
        this.esRey = esRey;
    }
}