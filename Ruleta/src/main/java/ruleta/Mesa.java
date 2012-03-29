package ruleta;

import java.util.LinkedList;
import java.util.List;

public class Mesa {
	
	int banca;
	Ruleta ruleta = new Ruleta();
	private List<Jugador> jugadores = new LinkedList<Jugador>();
	private List<Apuesta> apuestas = new LinkedList<Apuesta>();

	public Mesa(int banca){
		this.banca = banca;
	}
	
	public Jugador unirJugador(Jugador unJugador) {
		int dineroTemp = unJugador.getDinero();
		int fichasTemp = dineroTemp*80/100;
		unJugador.setDinero(dineroTemp - fichasTemp);
		unJugador.sumarFichas(fichasTemp);
		this.restarBanca(fichasTemp);
		this.jugadores .add(unJugador);
		return unJugador;
	}

	private void restarBanca(int dinero) {
		this.banca -= dinero;
	}
	
	public Apuesta registrarJugada(Apuesta apuesta){
		int cantidadApostada = apuesta.getFichas();
		apuesta.getJugador().restarFichas(cantidadApostada);
		this.apuestas.add(apuesta);
		this.banca += cantidadApostada;
		return apuesta;
	}
	
	public void pagarApuestas(){
		int numeroGanador = this.ruleta.getNumeroGanador();
		for(Apuesta a:apuestas){
			if(a.ganaParaNumero(numeroGanador)){
				int cantidadGanada = a.fichasGanadas();
				a.getJugador().sumarFichas(cantidadGanada);
				this.banca -= cantidadGanada;
			}
		}
		
		
	}

}
