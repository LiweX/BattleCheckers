/**
 * @author  Luna, Lihué Leandro
 * @author  Merino, Mateo
 * @author  Bonino, Francisco Ignacio
 */

import javax.swing.ImageIcon;

public class Ficha extends ComportamientoFicha {

    private boolean esRey;
    private ColorFicha color;
    private ImageIcon icono;
   
    /**
     * @param   color   Color de la ficha.
     * @param   icono   Imagen representativa de la ficha.
     */
    public Ficha(ColorFicha color, ImageIcon icono) {
        setRey(false);                  //Toda ficha comienza siendo peón.
        this.color = color;
        this.icono = icono;
        this.setComportamiento(new FichaPeon());
    }

    //Setters
    /**
     * @param   esRey    Indica si la ficha es rey o peón.
     */
    public void setRey(boolean esRey) {
        this.esRey = esRey;
    }

    //Getters
    /**
     * @return  Booleano que indica si la ficha es rey o no.
     */
    public boolean esRey() {
        return esRey;
    }

    /**
     * @return  Color de la ficha.
     */
    public ColorFicha getColor(){
        return color;
    }

    /**
     * @return  Icono de la ficha.
     */
    public ImageIcon getIcon() {
        return icono;
    }
}