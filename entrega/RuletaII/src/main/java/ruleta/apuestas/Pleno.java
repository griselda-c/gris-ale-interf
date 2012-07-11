package ruleta.apuestas;

import java.util.LinkedList;
import java.util.List;

import ruleta.Jugador;

public class Pleno extends Apuesta{
	private static final long serialVersionUID = 6953943384102341517L;

	public Pleno(Jugador j) {
		super(j);
		this.jugadaSeleccionada = new  OpcionJugada("0",0);
	}

	public Pleno() {
		super();
	}
	
	public Apuesta create(){
		return new Pleno();
	}

	public boolean ganaParaNumero(Integer numero){
		return (this.jugadaSeleccionada.getValor() == numero);
	}

	public Integer fichasGanadas(){
		return ((this.fichas * 36) + 1);		
	}
	
	public  List<OpcionJugada> getOpciones(){		
		List<OpcionJugada> lista = new LinkedList<OpcionJugada>();
		for (int i = 0; i <= 36; i++) {
			lista.add(new OpcionJugada(String.valueOf(i),i));
		}
		return lista;		
	}
	
	public String getTipoApuesta() {
		return "Pleno";
	}


}
