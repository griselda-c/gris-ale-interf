package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Mesa {
	
	int banca;
	private List<Jugador> jugadores = new LinkedList<Jugador>();

	public Mesa(int banca){
		this.banca = banca;
	}
	
	public Jugador unirJugador(Jugador unJugador) {
		int dineroTemp = unJugador.getDinero();
		int fichasTemp = dineroTemp*80/100;
		unJugador.setDinero(dineroTemp - fichasTemp);
		unJugador.sumarFichas(fichasTemp);
		this.restarBanca(fichasTemp);
		this.jugadores .add(unJugador);
		return unJugador;
	}

	private void restarBanca(int dinero) {
		this.banca -= dinero;
	}

}
