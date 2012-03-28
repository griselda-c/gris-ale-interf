package ruleta;

public class ParImpar extends Apuesta {

	
	public ParImpar(Jugador unJugador, int fichas, int numero) throws Exception {
		super(unJugador, fichas, numero);
	}

	boolean ganaParaNumero(int numero) {
		return ( ( (this.jugada - numero) % 2 ) == 0);
	}

}