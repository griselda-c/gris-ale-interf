package ruleta;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;

// quito todos los metodos observableObject
public abstract class Apuesta extends ObservableObject implements Serializable{	
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	public static final String FICHASSTRING = "fichasString";
	public static final String JUGADORNOMBRE =	"jugadorNombre";

	public String fichasString = "";
	public Jugador jugador;
	public Integer fichas;
	public OpcionJugada jugadaSeleccionada;
	public String jugadorNombre;
	public String opcionNombre;
	public int fichasGanadas = 0;
	public Apuesta(Jugador j) {
		this.jugador = j;
		this.fichas = 0;
	}
	
	public String getOpcionNombre() {
		return opcionNombre;
	}

	public void setOpcionNombre(String opcionNombre) {
		this.opcionNombre = opcionNombre;
	}

	public Apuesta() {
		super();
	}

	public String getJugadorNombre(){
	    return jugador.getNombre();
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
		//System.out.println("se setea fichas en " + fichas);
	}

	public OpcionJugada getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJugadaSeleccionada(OpcionJugada jugadaSeleccionada) {
		this.setFieldValue(JUGADASELECCIONADA, jugadaSeleccionada);
		this.opcionNombre = jugadaSeleccionada.getNombre();
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

	public int getFichasGanadas() {
		return fichasGanadas;
	}

	public void setFichasGanadas(int fichasGanadas) {
		this.fichasGanadas = fichasGanadas;
	}

	



}


