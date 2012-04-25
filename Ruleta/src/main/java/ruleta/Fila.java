package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Fila extends Apuesta{  

	public Fila(Jugador j) {
		super(j);
		this.jugador = j;
		this.jugadaSeleccionada = JUGADA.V1;
	}		

	@Override
	boolean ganaParaNumero(int numero) {		
		 return this.jugadaSeleccionada.getValor() == this.convertirEnFila(numero);
	}
	
	public Integer fichasGanadas(){		
		return 12 * this.fichas;		
	}
	
	public int convertirEnFila(int numero){		
		int resultado;
		if((numero%3)==0){			
			resultado = numero/3;
		}
		else{			
			resultado = (numero/3)+1;
		}
		return resultado;
	}
	
	public  List<JUGADA> getOpciones(){		
		List<JUGADA> lista = new LinkedList<JUGADA>();
		lista.add(JUGADA.V1);lista.add(JUGADA.V2);
		lista.add(JUGADA.V3);lista.add(JUGADA.V4);lista.add(JUGADA.V5);
		lista.add(JUGADA.V6);lista.add(JUGADA.V7);lista.add(JUGADA.V8);
		lista.add(JUGADA.V9);lista.add(JUGADA.V10);lista.add(JUGADA.V11);
		lista.add(JUGADA.V12);
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
	public String tipoApuesta = "Fila";
	
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
