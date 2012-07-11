package ruleta;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.exceptions.RuletaException;
import ruleta.extras.Validador;

public class Mesa implements Serializable{
	private static final long serialVersionUID = 5031718316785052882L;
	
	private static Mesa instancia;
	private Integer dineroBanca;
	private Ruleta ruleta;
	private Partida partidaActual;
	private Partida partidaAnterior;
	private List<Jugador> jugadores;
	private Integer CANTIDADMAXIMAJUGADORES = 3;
	
	public Mesa(){
		super();
	}

	public Mesa(int banca){
		this.dineroBanca = banca;
		this.ruleta = new Ruleta();
		this.partidaActual = new Partida();
		this.partidaAnterior = new Partida();
		this.jugadores = new LinkedList<Jugador>();
	}
	
	public static Mesa getInstancia(){
		if(instancia == null){
			instancia = new Mesa(10000);
		}
		return instancia;
	}
	
	public Jugador adjuntarJugador(String nombreloggin, String dinerologgin){
		this.validarCampos(nombreloggin, dinerologgin);
		Jugador nuevoJugador = new Jugador(Integer.parseInt(dinerologgin), nombreloggin, this.getPartidaActual());
		this.unirJugador(nuevoJugador);
		return nuevoJugador;
	}

	public void validarCampos(String nombreloggin, String dinerologgin) {
		if(!Validador.isText(nombreloggin)){
			throw new RuletaException("Formato de nombre incorrecto", "Intentelo nuevamente");
		}else if(!Validador.isNumber(dinerologgin)){
			throw new RuletaException("Formato de dinero incorrecto", "Intentelo nuevamente");
		}else if(existeJugador(nombreloggin)){
			throw new RuletaException("Ya existe un jugador con ese nombre", "Intente con otro nombre");
		}else if(!hayLugar()){
			throw new RuletaException("La mesa esta completa", "Intente mas tarde");
		}
	}
	
	private boolean hayLugar() {
		return this.getJugadores().size() < CANTIDADMAXIMAJUGADORES;
	}		

	public boolean existeJugador(String nombreloggin) {
		for(Jugador jugador : this.getJugadores()){
			if(nombreloggin.equals(jugador.getNombre())){
				return true;
			}
		}
		return false;
	}
		
	public void unirJugador(Jugador unJugador) {
		this.setDineroBanca(this.getDineroBanca() + unJugador.unirAMesa());
		agregarJugador(unJugador);
	}
		
	public void retirarJugador(Jugador jugador) {
		this.cambiarFichas(jugador);
		this.borrarJugador(jugador);
	}

	private void cambiarFichas(Jugador jugador) {
		int fichas = jugador.getFichas();
		this.restarDineroBanca(fichas);
		jugador.sumarDinero(fichas);
	}

	void restarDineroBanca(Integer dinero) {
		if(this.dineroBanca < dinero){
			throw new RuletaException("La banca se quedo sin un mango", "Que dios se lo pague");
		}
		else{
			this.setDineroBanca(this.getDineroBanca() - dinero);
		}
	}
	
	public void girarRuleta(){
		this.getPartidaActual().terminarPartida(this.ruleta.getNumeroGanador());
		swapPartidas();
	}

	public void swapPartidas() {
		this.setPartidaAnterior(this.getPartidaActual());
		this.setPartidaActual(new Partida());
	}
	


	public Partida agregarAPartidaActual(Jugador jugador) {
		this.getPartidaActual().agregarJugador(jugador);
		return this.getPartidaActual();
	}
	
	//access

	public void borrarJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
	}

	public void agregarJugador(Jugador unJugador) {
		this.jugadores.add(unJugador);
	}

	public Integer getDineroBanca() {
		return dineroBanca;
	}

	public void setDineroBanca(Integer dineroBanca) {
		this.dineroBanca = dineroBanca;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Partida getPartidaAnterior() {
		return partidaAnterior;
	}

	public void setPartidaAnterior(Partida partidaAnterior) {
		this.partidaAnterior = partidaAnterior;
	}

	
}