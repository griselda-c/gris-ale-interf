package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Columna extends Apuesta{

	public Columna(Jugador j) {
		super(j);
		this.jugadaSeleccionada = new OpcionJugada("1",1);
	}
	
	public Columna() {
		super();
	}

	public boolean ganaParaNumero(int numero) {
		return this.jugadaSeleccionada.getValor() == ((numero%3 )+ 1);		
	}
	
	Integer fichasGanadas() {
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


	
}
