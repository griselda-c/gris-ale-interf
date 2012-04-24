package ruleta;

import java.util.LinkedList;
import java.util.List;
import org.uqbar.commons.model.ObservableObject;


public class Mesa extends ObservableObject{
	
	public static final String BANCA = "banca";
	public static final String NUMEROGANADOR = "numeroGanador";
	public static final String GIRARRULETA = "girarRuleta";

	public final String SELECTED = "jugadorActual";
	public final String JUGADORES = "jugadores";
	
	public static final String NOMBREJUGADOR = "nombreJugadorEntrante";
	public static final String DINEROJUGADOR = "dineroJugadorEntrante";
	public static final String UNIRJUGADOR = "unirJugadorActual";
	public static final String APUESTAS = "apuestas";
	
	int banca;
	int numeroGanador = 0;

	int dineroJugadorEntrante;
	String nombreJugadorEntrante;
	Jugador jugadorActual;
	
	public Ruleta ruleta = new Ruleta();
	
	public List<Jugador> jugadores = new LinkedList<Jugador>();

	public List<Apuesta> apuestas = new LinkedList<Apuesta>();
	
	public Mesa(){
		super();
	}

	public Mesa(int banca){
		this.banca = banca;
		
		//comentar
		this.jugadores.add(new Jugador(100, "Jose"));
		this.jugadores.add(new Jugador(200, "Pepe"));
	}
	
	public void unirJugadorActual() {
		this.unirJugador(new Jugador(this.dineroJugadorEntrante, this.nombreJugadorEntrante));
		this.setDineroJugadorEntrante(0); // limpia la pantalla
		this.setNombreJugadorEntrante("");//limpia la pantalla*/
	}
	
	
	
	public void unirJugador(Jugador unJugador) {
		this.setBanca(this.getBanca() + unJugador.unirAMesa(this));
		this.jugadores.add(unJugador);
		System.out.println("se agrega jugador");
		this.firePropertyChange(JUGADORES, null, this.jugadores);
		System.out.println("se actualisza la tabla");
		this.setJugadorActual(unJugador);
		System.out.println("juagdor" + jugadorActual.getNombre());
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
		this.setBanca(this.getBanca() + cantidadApostada);
		//return apuesta;
	}
	public void girarRuleta(){
		this.setNumeroGanador(this.ruleta.getNumeroGanador());
	}
	
	
	public void pagarApuestas(){
		for(Apuesta a:apuestas){
			if(a.ganaParaNumero(numeroGanador)){
				int cantidadGanada = a.fichasGanadas();
				Jugador j = a.getJugador();
				j.sumarFichas(cantidadGanada);
				this.restarBanca(cantidadGanada);
			}
			
			a.getJugador().borrarApuestas(a);
		}//fin del for
		
	}
	

	public void retirarJugador() {
		Jugador j = this.getJugadorActual();
		this.cambiarFichas(j);
		this.jugadores.remove(j);
		this.firePropertyChange(JUGADORES, null, jugadores);
		
	}

	private void cambiarFichas(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	
	public void anularJugadorActual() {
		this.setJugadorActual(null);
	}
	
	//getters y setters

	public int getBanca() {
		return banca;
	}

	public void setBanca(int banca) {
		this.setProperty(BANCA,banca );
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
	
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	
	public void setJugadorActual(Jugador jugadorActual) {
		this.setProperty(SELECTED, jugadorActual);
		System.out.println("Se setea a " + jugadorActual.getNombre());
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
		this.setProperty(JUGADORES, jugadores);
	}
	
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	
	public void setApuestas(List<Apuesta> apuestas) {
		this.setProperty(APUESTAS, apuestas);
	}
	
}