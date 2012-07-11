package ruleta.apuestas;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.Jugador;

public abstract class Apuesta  implements Serializable{	
	private static final long serialVersionUID = -2997796035323150565L;
	
	protected Jugador jugador;
	protected Integer fichas;
	protected Integer numeroGanador;
	protected OpcionJugada jugadaSeleccionada;
	
	
	public static List<Apuesta> staticApuestas = getApuestas();

	public static List<Apuesta> getColeccionApuestasPosibles() {
		return staticApuestas;
	}	
	
	private static List<Apuesta> getApuestas() {
		List<Apuesta> apuestas = new LinkedList<Apuesta>();
		apuestas.add(new Columna());
		apuestas.add(new Fila());
		apuestas.add(new Pleno());
		apuestas.add(new ParImpar());
		return apuestas;
	}
	
	public Apuesta(Jugador j) {
		super();
		this.jugador = j;
		this.fichas = 0;
	}
	
	public Apuesta() {
		super();
	}

	public abstract boolean ganaParaNumero(Integer numero);
	public abstract Integer fichasGanadas();
	public abstract String getTipoApuesta();
	public abstract List<OpcionJugada> getOpciones();
	public abstract Apuesta create();
	
	public Jugador getJugador() {
		return jugador;
	}	

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Integer getFichas() {
		return fichas;
	}

	public void setFichas(Integer fichas) {
		this.fichas = fichas;
	}	

	public OpcionJugada getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}
	

	public void setJugadaSeleccionada(OpcionJugada jugadaSeleccionada) {
		this.jugadaSeleccionada = jugadaSeleccionada;
	}
	
	
	
	//model

	public Integer getNumeroGanador() {
		return numeroGanador;
	}

	public void setNumeroGanador(Integer numeroGanador) {
		this.numeroGanador = numeroGanador;
	}

	public String getJugadaString() {
		return jugadaSeleccionada.getNombre();
	}
	
	public String getFichasString() {
		return String.valueOf(fichas);
	}
	
	public String getGanadasString() {
		if(this.numeroGanador == null){
			return "error";			
		}
		if(this.ganaParaNumero(this.numeroGanador)){
			return String.valueOf(fichasGanadas());
		}
		return "-";
	}
	
}
	


