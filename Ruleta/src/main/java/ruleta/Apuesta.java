package ruleta;

abstract class Apuesta {
	
	private Jugador jugador;
	private int fichas;
	
	
	public Apuesta(Jugador unJugador, int fichas){
		this.jugador = jugador;
		this.fichas = fichas;		
	}
	
	abstract boolean ganaParaNumero();

}
