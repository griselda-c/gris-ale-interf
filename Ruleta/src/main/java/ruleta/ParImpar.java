package ruleta;

import java.util.LinkedList;
import java.util.List;

public class ParImpar extends Apuesta {

	public ParImpar(Jugador j) {
		super(j);
		this.jugadaSeleccionada =new OpcionJugada("Par", 38);
	}

	boolean ganaParaNumero(int numero) {		
		return ( ( (this.jugadaSeleccionada.getValor() - numero) % 2 ) == 0);		
	}
	
	Integer fichasGanadas() {		
		return (2 * this.fichas) + 1;
	}
	
	public  List<OpcionJugada> getOpciones(){		
		List<OpcionJugada> lista = new LinkedList<OpcionJugada>();
		lista.add(new OpcionJugada("Par", 38));lista.add(new OpcionJugada("Impar",37));
		return lista;		
	}

	
	public String getTipoApuesta() {
		return "Paridad";
	}


}
