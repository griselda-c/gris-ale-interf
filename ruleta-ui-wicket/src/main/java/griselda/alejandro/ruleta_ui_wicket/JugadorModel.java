package griselda.alejandro.ruleta_ui_wicket;

import ruleta.Jugador;

public class JugadorModel{

	public Jugador jugador;
	
	public JugadorModel(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public String getNombre(){
		return this.jugador.getNombre();
	}
	
	public Integer getFichas(){
		return this.jugador.getFichas();
	}
	
	public Integer getCantidadApuestas(){
		return this.jugador.getApuestas().size();
	}

}
