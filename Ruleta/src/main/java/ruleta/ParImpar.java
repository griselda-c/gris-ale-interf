package ruleta;

import java.util.LinkedList;
import java.util.List;

public class ParImpar extends Apuesta {


	public ParImpar(Jugador j) {
		super(j);
		this.jugador = j;
		this.jugadaSeleccionada = JUGADA.PAR;
	}

	boolean ganaParaNumero(int numero) {
		return ( ( (this.jugadaSeleccionada.getValor() - numero) % 2 ) == 0);
	}

	
	int fichasGanadas() {		
		return (2 * this.fichas) + 1;
	}

	//Re-escritura de superclase
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	
	public Jugador jugador;
	public int fichas;
	public JUGADA jugadaSeleccionada;
	public String tipoApuesta = "Paridad";
	
	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.PAR);lista.add(JUGADA.IMPAR);
		return lista;		
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.setProperty(JUGADOR, jugador);
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.setProperty(FICHAS, fichas);
	}

	public JUGADA getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJugadaSeleccionada(JUGADA jugadaSeleccionada) {
		this.setProperty(JUGADASELECCIONADA, jugadaSeleccionada);
	}

	public String getTipoApuesta() {
		return tipoApuesta;
	}

	public void setTipoApuesta(String tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}
}
