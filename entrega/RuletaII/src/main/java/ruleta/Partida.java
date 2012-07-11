package ruleta;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.apuestas.Apuesta;

public class Partida  implements Serializable{
	private static final long serialVersionUID = 2292923819619407769L;
	
	private List<Apuesta> apuestas;
	private List<Jugador> jugadores;
	private Integer numeroGanador;
	private Boolean estaEnVigencia;
	
	public Partida(){
		estaEnVigencia = true;
		apuestas = new LinkedList<Apuesta>();
		jugadores = new LinkedList<Jugador>();
		numeroGanador = null;
	}
	
	public void terminarPartida(Integer numeroGanador){
		this.numeroGanador = numeroGanador;
		this.pagarApuestas();
		this.guardarNumeroGanadorEnApuestas();
		estaEnVigencia = false;
	}
	
	private void guardarNumeroGanadorEnApuestas() {
		for(Apuesta apuesta:apuestas){
			apuesta.setNumeroGanador(this.numeroGanador);
		}		
	}

	public void pagarApuestas(){
		for(Apuesta apuesta:apuestas){
			if(apuesta.ganaParaNumero(numeroGanador)){
				Integer cantidadGanada = apuesta.fichasGanadas();
				apuesta.getJugador().sumarFichas(cantidadGanada);
				this.getMesa().restarDineroBanca(cantidadGanada);
			}
		}
		for (Jugador jugador : jugadores) {
			jugador.rotarApuestas();
		}		
	}
	
	public void registrarJugada(Apuesta apuesta){
		apuesta.getJugador().restarFichas(apuesta.getFichas());
		this.apuestas.add(apuesta);
	}
	
	//access
	
	public void agregarJugador(Jugador jugador){
		this.jugadores.add(jugador);
	}
	
	
	public Mesa getMesa(){
		return Mesa.getInstancia();
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Integer getNumeroGanador() {
		return numeroGanador;
	}

	public void setNumeroGanador(Integer numeroGanador) {
		this.numeroGanador = numeroGanador;
	}

	public Boolean getEstaEnVigencia() {
		return estaEnVigencia;
	}

	public void setEstaEnVigencia(Boolean estaEnVigencia) {
		this.estaEnVigencia = estaEnVigencia;
	}
	
}
