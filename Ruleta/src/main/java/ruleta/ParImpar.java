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
	
	Integer fichasGanadas() {		
		return (2 * this.fichas) + 1;
	}
	
	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.PAR);lista.add(JUGADA.IMPAR);
		return lista;		
	}

	//Re-escritura de superclase
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	public static final String FICHASSTRING = "fichasString";

	public String fichasString = "";
	public Jugador jugador;
	public Integer fichas;
	public JUGADA jugadaSeleccionada;
	public String tipoApuesta = "Paridad";
	
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

	public JUGADA getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJugadaSeleccionada(JUGADA jugadaSeleccionada) {
		this.setFieldValue(JUGADASELECCIONADA, jugadaSeleccionada);
	}

	public String getTipoApuesta() {
		return tipoApuesta;
	}

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
