package ruleta.apuestas;

import java.util.LinkedList;
import java.util.List;

import ruleta.Jugador;

public class ParImpar extends Apuesta {
	private static final long serialVersionUID = -4673524007000575437L;

	public ParImpar(Jugador j) {
		super(j);
		this.jugadaSeleccionada =new OpcionJugada("Par", 38);
	}

	public ParImpar() {
		super();
	}
	
	public Apuesta create(){
		return new ParImpar();
	}

	public boolean ganaParaNumero(Integer numero) {		
		return ( ( (this.jugadaSeleccionada.getValor() - numero) % 2 ) == 0);		
	}
	
	public Integer fichasGanadas() {		
		return (2 * this.fichas) + 1;
	}
	
	public List<OpcionJugada> getOpciones(){		
		List<OpcionJugada> lista = new LinkedList<OpcionJugada>();
		lista.add(new OpcionJugada("Par", 38));lista.add(new OpcionJugada("Impar",37));
		return lista;
	}
	
	public String getTipoApuesta() {
		return "Paridad";
	}


}
