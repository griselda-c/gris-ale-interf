package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Columna extends Apuesta{

	public Columna(Jugador j) {
		super(j);
		this.jugador = j;
		this.jugadaSeleccionada = JUGADA.V1;
	}

	boolean ganaParaNumero(int numero) {
		return this.jugadaSeleccionada.getValor() == (numero%3 + 1);		
	}
	
	Integer fichasGanadas() {
		return 3 * this.fichas;
	}
	
	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.V1);lista.add(JUGADA.V2);lista.add(JUGADA.V3);
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
	public String tipoApuesta = "Columna";
	
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
