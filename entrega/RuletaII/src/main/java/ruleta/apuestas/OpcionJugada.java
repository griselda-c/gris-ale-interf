package ruleta.apuestas;

import java.io.Serializable;

public class OpcionJugada  implements Serializable{
	private static final long serialVersionUID = -2356860016485232290L;
	private String nombre;
	private Integer valor;
	
	public OpcionJugada(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public OpcionJugada() {
	}

	public Integer getValor() {
		return this.valor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}