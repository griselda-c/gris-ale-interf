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
			throw new BusinessException("No se pudo unir al jugador");
		}
		mesa.unirJugador(jugador);
	}
	
	private boolean yaExisteJugador(Jugador jugador) {
		boolean existe = false;
		for (Jugador j : mesa.getJugadores()) {
			if (j.getNombre() == jugador.getNombre()) {
				existe = true;
			}

		}
		return existe;
	}

	public boolean puedeRecibirJugador(Jugador j) {
		boolean puede = true;
		if (mesa.getJugadores().size() > this.maxJugadores || yaExisteJugador(j)) {
			puede = false;
		}
		return puede;
	}

}
