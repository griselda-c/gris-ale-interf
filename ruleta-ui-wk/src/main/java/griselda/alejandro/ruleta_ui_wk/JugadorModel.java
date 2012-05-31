package griselda.alejandro.ruleta_ui_wk;



import java.io.Serializable;

import ruleta.Jugador;

public class JugadorModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private String nombre = "";
private int dinero = 0;

private Jugador jugador = new Jugador(dinero,nombre);

public String getNombre() {
	return nombre;
}

public JugadorModel(){

	
}

public void createJugador(){
	this.jugador = new Jugador (dinero,nombre);
	
}

//getters and setters
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getDinero() {
	return dinero;
}

public void setDinero(int dinero) {
	this.dinero = dinero;
}

public Jugador getJugador() {
	return jugador;
}

public void setJugador(Jugador jugador) {
	this.jugador = jugador;
}



	
	
}
