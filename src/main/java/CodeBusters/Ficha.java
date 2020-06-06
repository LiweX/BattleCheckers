import java.util.ArrayList;

public class Ficha implements SujetoObservable {
	
	private ArrayList<Observador> observadores;
	private String posicion;
	private ColorFicha color;
	private TipoFicha tipo;
	private ObservadorMovimientos obsMov;
	private ObservadorEliminaciones obsElim;
	private ObservadorTipoFicha obsTipo;
	
	public Ficha(ColorFicha color, String posicion) {
		observadores = new ArrayList<Observador>();
		
		obsMov = new ObservadorMovimientos();
		obsElim = new ObservadorEliminaciones();
		obsTipo = new ObservadorTipoFicha();
		
		this.color = color;
		this.posicion = posicion;
	}
	
	//Setters
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void setTipo(TipoFicha tipo) {
		this.tipo = tipo;
	}
	
	//Getters
	public String getPosicion() {
		return posicion;
	}
	
	public ColorFicha getColor() {
		return color;
	}
	
	public TipoFicha getTipo() {
		return tipo;
	}
	
	//Otros metodos
	public void enlazarObservadores(Observador o) {
		observadores.add(o);
	}
	
	public void notificar() {
		for(Observador o : observadores) {
			o.update();
		}
	}
}