package ruleta;

import org.uqbar.commons.model.ObservableObject;

public class Jugador extends ObservableObject{
	
	int fichas;
	int dinero;
	private Mesa mesa;
	String nombre;
	int monoApuestaActual;

	public static final String NOMBRE = "nombre";
	public static final String DINERO = "dinero";
	public static final String FICHAS = "fichas";
	public static final String MONTOAPUESTA = "monoApuestaActual";


	public Jugador(int dineroT, String nombreT){
		this.setDinero(dineroT);
		this.setNombre(nombreT);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.setProperty(NOMBRE, nombre);
	}
	
	public void setFichas(int fichasT) {
		this.setProperty(FICHAS, fichasT);
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
		this.setProperty(DINERO, dineroT);
	}

	public int unirAMesa(Mesa mesa) {
		this.mesa = mesa;
		int fichasTemp = dinero*80/100;
		this.fichas += fichasTemp;
		this.dinero -= fichasTemp;		
		return fichasTemp;
	}
	
	
	

}
