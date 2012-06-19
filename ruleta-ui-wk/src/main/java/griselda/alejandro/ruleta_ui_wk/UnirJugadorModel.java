package griselda.alejandro.ruleta_ui_wk;

import java.io.Serializable;

import ruleta.Jugador;
import ruleta.Mesa;

public class UnirJugadorModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Jugador jugador;
	private final Mesa mesa;
	private int maxJugadores = 10;
	
	public UnirJugadorModel(Mesa mesa) {
		this.mesa = mesa;
		this.jugador = new Jugador(0, "");
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void unir() {
		if (!puedeRecibirJugador(jugador)) {
			throw new BusinessException("La mesa esta llena intente mas tarde");
		}
		if(this.yaExisteJugador(jugador)){
		   throw new BusinessException("El pseudonimo ya existe");
		}
		mesa.unirJugador(jugador);
	}
	
	private boolean yaExisteJugador(Jugador jugador) {
		boolean existe = false;
		for (Jugador j : mesa.getJugadores()) {
			if (j.getNombre().equals(jugador.getNombre())) {
				existe = true;
			}

		}
		return existe;
	}

	public boolean puedeRecibirJugador(Jugador j) {
		boolean puede = true;
		if (mesa.getJugadores().size() >= this.maxJugadores) {
			puede = false;
		}
		return puede;
	}

}
