package ruleta;

import java.io.Serializable;

public class JugadorPartida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Jugador jugador;
	Mesa mesa;
	
	public JugadorPartida(Jugador j,Mesa m){
		this.jugador = j;
		this.mesa = m;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	
	
	
}
