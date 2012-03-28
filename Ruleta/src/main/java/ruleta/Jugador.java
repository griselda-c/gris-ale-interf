package ruleta;

public class Jugador {
	
	private int fichas;

	public int getFichas() {
		return fichas;
	}
	
	public void sumarFichas(int cantidad) {
		this.fichas += cantidad;
	}
	
	public void restarFichas(int cantidad) {
		this.fichas -= cantidad;
	}

	
	
	

}
