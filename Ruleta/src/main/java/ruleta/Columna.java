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
		//return ((this.jugadaSeleccionada.getValor() % 3) == (numero % 3));
		return this.jugadaSeleccionada.getValor() == (numero%3);
		
	}
	
	int fichasGanadas() {
		return 3 * this.fichas;
	}

	//Re-escritura de superclase
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	
	public Jugador jugador;
	public int fichas;
	public JUGADA jugadaSeleccionada;
	public String tipoApuesta = "Columna";
	
	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.V1);lista.add(JUGADA.V2);lista.add(JUGADA.V3);
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
	/*
	public static void main(String[] args) {
		Jugador j = new Jugador(200, "jorge");
		Columna c = new Columna(j);
		c.setFichas(3);
		c.setJugadaSeleccionada(JUGADA.V2);
		c.ganaParaNumero(5);
		System.out.println(c.ganaParaNumero(7));
		
	}
	*/
}
