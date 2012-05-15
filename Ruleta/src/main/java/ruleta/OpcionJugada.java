package ruleta;

public class OpcionJugada {

	
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