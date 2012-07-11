package ruleta.apuestas;

import java.util.LinkedList;
import java.util.List;

import ruleta.Jugador;

public class Fila extends Apuesta{  
	private static final long serialVersionUID = 1312758403239179879L;

	public Fila(Jugador j) {
		super(j);
		this.jugadaSeleccionada = new OpcionJugada("1",1);
	}		

	public Fila() {
		super();
	}	
	
	public Apuesta create(){
		return new Fila();
	}

	public boolean ganaParaNumero(Integer numero) {		
		 return this.jugadaSeleccionada.getValor() == this.convertirEnFila(numero);
	}
	
	public Integer fichasGanadas(){		
		return 12 * this.fichas;		
	}
	
	public Integer convertirEnFila(Integer numero){		
		int resultado;
		if((numero%3)==0){			
			resultado = numero/3;
		}
		else{			
			resultado = (numero/3)+1;
		}
		return resultado;
	}
	
	public  List<OpcionJugada> getOpciones(){		
		List<OpcionJugada> lista = new LinkedList<OpcionJugada>();
		for (int i = 1; i <= 12; i++) {
			lista.add(new OpcionJugada(String.valueOf(i),i));
		}
		return lista;		
	}
	
	public String getTipoApuesta() {
		return "Fila";
	}
	
	public String getTipoApuestaCorto() {
		return "Fila";
	}

}
