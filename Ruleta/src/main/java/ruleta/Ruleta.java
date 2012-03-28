package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Ruleta {
	List<Jugador> jugadores = new LinkedList<Jugador>();
	
	public Jugador unirJugador(Jugador unJugador){
		int totalDinero = unJugador.getDinero();
		int fichasCambio = totalDinero * 80 / 100;
		unJugador.setDinero(totalDinero - fichasCambio);
		unJugador.sumarFichas(fichasCambio);		
		this.jugadores.add(unJugador);
		return unJugador;
	}

}
