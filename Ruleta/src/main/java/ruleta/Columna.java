package ruleta;

public class Columna extends Apuesta{

	public Columna(Jugador unJugador, int fichas, int numero) throws Exception {
		super(unJugador, fichas, numero);
	}

	boolean ganaParaNumero(int numero) {
		return ((this.jugada % 3) == (numero % 3));
	}

}
