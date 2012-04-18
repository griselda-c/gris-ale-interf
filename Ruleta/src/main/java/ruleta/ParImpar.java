package ruleta;

public class ParImpar extends Apuesta {

	
	public ParImpar(Jugador unJugador, int fichas, int numero){
		super(unJugador, fichas, numero);
	}

	public ParImpar(Jugador j) {
		super(j);
	}

	boolean ganaParaNumero(int numero) {
		return ( ( (this.jugada - numero) % 2 ) == 0);
	}

	
	int fichasGanadas() {		
		return (2 * this.fichas) + 1;
	}

}
