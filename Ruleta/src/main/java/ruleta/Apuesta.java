package ruleta;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;

// quito todos los metodos observableObject
abstract class Apuesta extends ObservableObject{	
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADASELECCIONADA = "jugadaSeleccionada";
	public static final String TIPO = "tipoApuesta";
	
	public Jugador jugador;
	public int fichas;
	public JUGADA jugadaSeleccionada;
	public String tipoApuesta = "Apuesta";
	
	public Apuesta(Jugador j) {
		this.jugador = j;
		this.fichas = 0;
	}

	abstract boolean ganaParaNumero(int numero);
	abstract int fichasGanadas();

	public void confirmar() {		
		this.jugador.apostar(this);		
	}

	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.V0);lista.add(JUGADA.V1);lista.add(JUGADA.V2);
		lista.add(JUGADA.V3);lista.add(JUGADA.V4);lista.add(JUGADA.V5);
		lista.add(JUGADA.V6);lista.add(JUGADA.V7);lista.add(JUGADA.V8);
		lista.add(JUGADA.V9);lista.add(JUGADA.V10);lista.add(JUGADA.V11);
		lista.add(JUGADA.V12);lista.add(JUGADA.V13);lista.add(JUGADA.V14);
		lista.add(JUGADA.V15);lista.add(JUGADA.V16);lista.add(JUGADA.V17);
		lista.add(JUGADA.V18);lista.add(JUGADA.V19);lista.add(JUGADA.V20);
		lista.add(JUGADA.V21);lista.add(JUGADA.V22);lista.add(JUGADA.V23);
		lista.add(JUGADA.V24);lista.add(JUGADA.V25);lista.add(JUGADA.V26);
		lista.add(JUGADA.V27);lista.add(JUGADA.V28);lista.add(JUGADA.V29);
		lista.add(JUGADA.V30);lista.add(JUGADA.V31);lista.add(JUGADA.V32);
		lista.add(JUGADA.V33);lista.add(JUGADA.V34);lista.add(JUGADA.V35);
		lista.add(JUGADA.V36);
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


