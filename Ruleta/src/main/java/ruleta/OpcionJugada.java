package ruleta;

import java.io.Serializable;

public class OpcionJugada implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int valor;
	
	public OpcionJugada(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public OpcionJugada() {
	}

	public int getValor() {
		return this.valor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}