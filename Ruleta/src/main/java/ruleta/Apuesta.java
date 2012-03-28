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

	public Apuesta(Jugador unJugador, int fichas, int numero) throws Exception{
		
		if(jugada > 36 | jugada < 0){
			throw new Exception("Digito de apuesta fuera de rango de ruleta");
		}
		
		this.jugador = unJugador;
		this.fichas = fichas;
		this.jugada = numero;
	}
	
	abstract boolean ganaParaNumero(int numero);
	abstract int fichasGanadas();
	
	

}
