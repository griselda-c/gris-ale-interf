package ruleta.apuestas;

import java.util.LinkedList;
import java.util.List;

import ruleta.Jugador;

public class Columna extends Apuesta{
	private static final long serialVersionUID = 5391378755414879039L;

	public Columna(Jugador j) {
		super(j);
		this.jugadaSeleccionada = new OpcionJugada("1",1);
	}
	
	public Columna() {
		super();
	}
	
	public Apuesta create(){
		return new Columna();
	}

	public boolean ganaParaNumero(Integer numero) {
		if(this.jugadaSeleccionada.getValor().equals(0)){
			return false;
		}
		return (this.jugadaSeleccionada.getValor()%3 == (numero%3));		
	}
	
	public Integer fichasGanadas() {
		return 3 * this.fichas;
	}
	
	public  List<OpcionJugada> getOpciones(){		
		List<OpcionJugada> lista = new LinkedList<OpcionJugada>();
		for (int i = 1; i <= 3; i++) {
			lista.add(new OpcionJugada(String.valueOf(i),i));
		}
		return lista;
	}

	public String getTipoApuesta() {
		return "Columna";
	}
	
	public String getTipoApuestaCorto() {
		return "Col";
	}
	
}
