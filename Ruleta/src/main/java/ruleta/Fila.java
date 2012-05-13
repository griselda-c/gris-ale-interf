package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Fila extends Apuesta{  

	public Fila(Jugador j) {
		super(j);
		this.jugadaSeleccionada = new OpcionJugada("1",1);
	}		

	public Fila() {
		super();
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

}
