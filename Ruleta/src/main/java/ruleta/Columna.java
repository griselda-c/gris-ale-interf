package ruleta;

public class Columna extends Apuesta{


	public Columna(Jugador unJugador, int fichas, int numero){

		super(unJugador, fichas, numero);
	}

	boolean ganaParaNumero(int numero) {
		return ((this.jugada % 3) == (numero % 3));
	}

	
	int fichasGanadas() {
		// TODO Auto-generated method stub
		return 3 * this.fichas;
	}

}
