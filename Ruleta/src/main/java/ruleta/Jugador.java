package ruleta;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;


// quito todos los metodos de observable object
// no afecto a mesaWindow
public class Jugador extends ObservableObject{
	
	int fichas;
	int dinero;
	private Mesa mesa;
	String nombre;
	int montoApuestaActual;
	private List<Apuesta> apuestas = new LinkedList<Apuesta>();

	public static final String NOMBRE = "nombre";
	public static final String DINERO = "dinero";
	//cambie de lugar
	public static final String FICHAS = "fichas";
	public static final String MONTOAPUESTA = "montoApuestaActual";
	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public Jugador(int dineroT, String nombreT){
		this.setDinero(dineroT);
		this.setNombre(nombreT);
		
		/*para comentar*/
		this.apuestas.add(new Pleno(this, 10, 3));
		this.apuestas.add(new ParImpar(this, 15, 10));
		this.apuestas.add(new Fila(this, 100, 4));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFichas(int fichasT) {
		this.fichas = fichasT;
	}

	public int getFichas() {
		return fichas;
	}
	
	public void sumarFichas(int cantidad) {
		this.setFichas(this.getFichas() + cantidad);
	}
	
	public void restarFichas(int cantidad) {
		this.setFichas(this.getFichas() - cantidad);
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dineroT) {
		this.dinero = dineroT;
	}

	public int unirAMesa(Mesa mesa) {
		this.mesa = mesa;
		int fichasTemp = dinero*80/100;
		this.fichas += fichasTemp;
		this.dinero -= fichasTemp;		
		return fichasTemp;
	}

	public Apuesta nuevaApuestaPleno() {
		return new Pleno(this);
	}

	public void apostar(Apuesta apuesta) {
		
		this.getMesa().registrarJugada(apuesta);
		this.apuestas.add(apuesta);
		
	}

	public Class<Jugador> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
