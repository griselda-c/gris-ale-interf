package ruleta;

public class Jugador {
	
	private int fichas;
	private int dinero;

	public int getFichas() {
		return fichas;
	}
	
	public void sumarFichas(int cantidad) {
		this.fichas += cantidad;
	}
	
	public void restarFichas(int cantidad) {
		this.fichas -= cantidad;
	}

	public Jugador(int dinero){
		this.dinero = dinero;		
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	
	

}
