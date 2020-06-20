package CodeBusters;

public class Ficha {

    private boolean esRey;
    private ColorFicha color;
    
    /*
        @param  coordenada: Coordenada inicial de la ficha.
    */
    public Ficha(ColorFicha color) {
        setCoordenada(coordenada);
        setRey(false);                  //Toda ficha comienza siendo peón.
        setColor(color);
    }

    public boolean esRey() {
        return esRey;
    }

    public ColorFicha getColor(){
        return color;
    }

    //Setters
    /*
        @param  c: Color de la ficha.
    */
    public void setColor(ColorFicha c){
        color = c;
    }

    /*
        @param  esRey: Indica si la ficha es rey o peón.
    */
    public void setRey(boolean esRey) {
        this.esRey = esRey;
    }
}