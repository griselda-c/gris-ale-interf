package ruleta;

import org.uqbar.commons.model.ObservableObject;

// quito todos los metodos observableObject
abstract class Apuesta extends ObservableObject{
	
	protected Jugador jugador;
	protected int fichas;
	protected int jugada;
	
	//variables
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADA = "jugada";
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.setProperty(JUGADOR, jugador);
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.setProperty(FICHAS, fichas);
	}

	public int getJugada() {
		return jugada;
	}
   
	public void setJugada(int jugada) {
		this.setProperty(JUGADA, jugada);
	}




	public Apuesta(Jugador unJugador, int fichas, int numero){

		
		if(jugada > 36 | jugada < 0){
			throw new RuntimeException("Digito de apuesta fuera de rango de ruleta");
		}
		
		this.jugador = unJugador;
		this.fichas = fichas;
		this.jugada = numero;
	}
	
	public Apuesta(Jugador j) {
		this.jugador = j;
	}

	abstract boolean ganaParaNumero(int numero);
	abstract int fichasGanadas();
	
	

}
