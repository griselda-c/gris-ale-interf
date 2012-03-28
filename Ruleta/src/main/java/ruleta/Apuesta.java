package ruleta;

abstract class Apuesta {
	
	protected Jugador jugador;
	protected int fichas;
	protected int jugada;
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public int getJugada() {
		return jugada;
	}

	public void setJugada(int jugada) {
		this.jugada = jugada;
	}

	public Apuesta(Jugador unJugador, int fichas){
		this.jugador = unJugador;
		this.fichas = fichas;		
	}
	
	abstract boolean ganaParaNumero(int numero);

}
