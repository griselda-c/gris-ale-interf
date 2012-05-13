package ruleta;

import java.util.List;

import org.uqbar.commons.model.ObservableObject;

// quito todos los metodos observableObject
public abstract class Apuesta extends ObservableObject{	
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	public static final String FICHASSTRING = "fichasString";

	public String fichasString = "";
	public Jugador jugador;
	public Integer fichas;
	public OpcionJugada jugadaSeleccionada;
	
	public Apuesta(Jugador j) {
		this.jugador = j;
		this.fichas = 0;
	}
	
	public Apuesta() {
		super();
	}

	abstract boolean ganaParaNumero(int numero);
	abstract Integer fichasGanadas();

	public void confirmar() {		
		this.jugador.apostar(this);	
		//System.out.println("cantidad de apuestas" +this.jugador.apuestas.size());
	}

	public abstract  List<OpcionJugada> getOpciones();
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.setFieldValue(JUGADOR, jugador);
	}

	public Integer getFichas() {
		return fichas;
	}

	public void setFichas(Integer fichas) {	
		this.setFieldValue(FICHAS, fichas);
	}

	public OpcionJugada getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJugadaSeleccionada(OpcionJugada jugadaSeleccionada) {
		this.setFieldValue(JUGADASELECCIONADA, jugadaSeleccionada);
	}

	public abstract String getTipoApuesta();
	
	public void setTipoApuesta(String tipoApuesta) {
		this.setFieldValue(TIPO, jugadaSeleccionada);
	}

	public String getFichasString() {
		return fichasString;
	}

	public void setFichasString(String fichasString) {
		this.setFieldValue(FICHASSTRING, fichasString);
		this.setFieldValue(FICHAS, Integer.valueOf(fichasString));		
	}
	



}


