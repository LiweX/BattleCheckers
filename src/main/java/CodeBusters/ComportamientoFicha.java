package codebusters;

public abstract class ComportamientoFicha {
    private Algoritmo comportamiento;

    public void setComportamiento(Algoritmo comportamiento){
        this.comportamiento=comportamiento;
    }

    public void celdasContiguas(){
        this.comportamiento.celdasContiguas();
    }

    public void celdasEliminar(){
        this.comportamiento.celdasEliminar();
    }
}