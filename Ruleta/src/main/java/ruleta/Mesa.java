package ruleta;

import java.util.LinkedList;
import java.util.List;
import org.uqbar.commons.model.ObservableObject;


public class Mesa extends ObservableObject{
	
	int banca;
	int numeroGanador = 0;
	
	String nombreJugadorEntrante;
	int dineroJugadorEntrante;
	
	public static final String BANCA = "banca";
	public static final String NUMEROGANADOR = "numeroGanador";
	public static final String GIRARRULETA = "girarRuleta";

	public static final String NOMBREJUGADOR = "nombreJugadorEntrante";
	public static final String DINEROJUGADOR = "dineroJugadorEntrante";
	public static final String UNIRJUGADOR = "unirJugadorActual";
	
	Ruleta ruleta = new Ruleta();
	private List<Jugador> jugadores = new LinkedList<Jugador>();
	private List<Apuesta> apuestas = new LinkedList<Apuesta>();

	public Mesa(int banca){
		this.banca = banca;
	}
	
	public void unirJugadorActual() {
		this.unirJugador(new Jugador(this.dineroJugadorEntrante, this.nombreJugadorEntrante));
		/*
		this.setDineroJugadorEntrante(0); // limpia la pantalla
		this.setNombreJugadorEntrante("");//limpia la pantalla*/
	}
	
	public void unirJugador(Jugador unJugador) {
		this.banca += unJugador.unirAMesa(this);
		this.jugadores.add(unJugador);
	}

	private void restarBanca(int dinero) {
		if(this.banca < dinero){
			throw new RuntimeException("La banca se quedo sin un mango");
		}
		else{
			this.banca -= dinero;			
		}
	}
	// convertir en void
	public void registrarJugada(Apuesta apuesta){
		int cantidadApostada = apuesta.getFichas();
		apuesta.getJugador().restarFichas(cantidadApostada);
		this.apuestas.add(apuesta);
		this.banca += cantidadApostada;
		//return apuesta;
	}
	public void girarRuleta(){
		this.setNumeroGanador(this.ruleta.getNumeroGanador());
	}
	
	
	public void pagarApuestas(){
		this.girarRuleta();
		for(Apuesta a:apuestas){
			if(a.ganaParaNumero(numeroGanador)){
				int cantidadGanada = a.fichasGanadas();
				a.getJugador().sumarFichas(cantidadGanada);
				this.restarBanca(cantidadGanada);
			}
		}
		
		
	}

	public int getBanca() {
		return banca;
	}

	public void setBanca(int banca) {
		this.banca = banca;
	}

	public int getNumeroGanador() {
		return numeroGanador;
	}

	public void setNumeroGanador(int numeroGanador) {
		this.setProperty(NUMEROGANADOR, numeroGanador);
	}

	public String getNombreJugadorEntrante() {
		return nombreJugadorEntrante;
	}

	public void setNombreJugadorEntrante(String nombreJugadorEntranteT) {
		this.setProperty(NOMBREJUGADOR, nombreJugadorEntranteT);
	}

	public int getDineroJugadorEntrante() {
		return dineroJugadorEntrante;
	}

	public void setDineroJugadorEntrante(int dineroJugadorEntranteT) {
		this.setProperty(DINEROJUGADOR, dineroJugadorEntranteT);
	}
	
	
	
}