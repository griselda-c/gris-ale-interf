package ruleta;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;

// quito todos los metodos observableObject
abstract class Apuesta extends ObservableObject{
	
	
	
	public static final String OPCIONSELECCIONADA = "opcionSeleccionada";
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADA = "jugada";
	
	public Jugador jugador;
	public int fichas;
	public int jugada;
	public VALOR opcionSeleccionada;



	public Apuesta(Jugador unJugador, int fichas, int numero){
		
		if(jugada > 36 | jugada < 0){
			throw new RuntimeException("Digito de apuesta fuera de rango de ruleta");
		}
		
		this.jugador = unJugador;
		this.fichas = fichas;
		this.jugada = numero;
		
	}
	
	public Apuesta(Jugador j) {
		this.jugador = j;
		this.fichas = 0;
		this.jugada = 0;
		this.opcionSeleccionada = VALOR.V0;
	}

	abstract boolean ganaParaNumero(int numero);
	abstract int fichasGanadas();

	public void confirmar() {		
		this.jugador.apostar(this);		
	}

	public  List<VALOR> getOpciones(){		
		List<VALOR> lista = new LinkedList<VALOR>();
		lista.add(VALOR.V0);lista.add(VALOR.V1);lista.add(VALOR.V2);
		lista.add(VALOR.V3);lista.add(VALOR.V4);lista.add(VALOR.V5);
		lista.add(VALOR.V6);lista.add(VALOR.V7);lista.add(VALOR.V8);
		lista.add(VALOR.V9);lista.add(VALOR.V10);lista.add(VALOR.V11);
		lista.add(VALOR.V12);lista.add(VALOR.V13);lista.add(VALOR.V14);
		lista.add(VALOR.V15);lista.add(VALOR.V16);lista.add(VALOR.V17);
		lista.add(VALOR.V18);lista.add(VALOR.V19);lista.add(VALOR.V20);
		lista.add(VALOR.V21);lista.add(VALOR.V22);lista.add(VALOR.V23);
		lista.add(VALOR.V24);lista.add(VALOR.V25);lista.add(VALOR.V26);
		lista.add(VALOR.V27);lista.add(VALOR.V28);lista.add(VALOR.V29);
		lista.add(VALOR.V30);lista.add(VALOR.V31);lista.add(VALOR.V32);
		lista.add(VALOR.V33);lista.add(VALOR.V34);lista.add(VALOR.V35);
		lista.add(VALOR.V36);
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
		System.out.println("se setea fichas en " + this.fichas);
	}

	public int getJugada() {
		return jugada;
	}
   
	public void setJugada(int jugada) {
		this.setProperty(JUGADA, jugada);
	}
	
	public VALOR getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(VALOR opcionSeleccionada) {
		this.setProperty(OPCIONSELECCIONADA, opcionSeleccionada);
	}
	

}
