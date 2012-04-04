package ruleta;

public class Jugador {
	
	private int fichas;
	private int dinero;
	private Mesa mesa;

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

	public int unirAMesa(Mesa mesa) {
		this.mesa = mesa;
		int fichasTemp = dinero*80/100;
		this.fichas += fichasTemp;
		this.dinero -= fichasTemp;		
		return fichasTemp;
	}
	
	
	

}
