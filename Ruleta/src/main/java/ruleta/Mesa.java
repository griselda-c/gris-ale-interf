package ruleta;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;


public class Mesa extends ObservableObject implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public        final String SELECTED      = "jugadorActual";
	public        final String JUGADORES     = "jugadores";	
	public static final String NOMBREJUGADOR = "nombreJugadorEntrante";
	public static final String DINEROJUGADOR = "dineroJugadorEntrante";
	public static final String UNIRJUGADOR   = "unirJugadorActual";
	public static final String APUESTAS      = "apuestas";	
	public static final String BANCA         = "banca";
	public static final String NUMEROGANADOR = "numeroGanador";
	public static final String GIRARRULETA   = "girarRuleta";
	
	Integer banca;
	Integer numeroGanador = 99;
	String  dineroJugadorEntrante;
	String  nombreJugadorEntrante;
	Jugador jugadorActual;
	Integer numeroGanadorAnterior=0;
	Boolean mesaCerrada = false;
	
	

	public Ruleta ruleta;
	
	public List<Jugador> jugadores = new LinkedList<Jugador>();

	public List<Apuesta> apuestas = new LinkedList<Apuesta>();
	public  List<Apuesta> apuestasAnteriores = new LinkedList<Apuesta>();
	private int maxJugadores;
	
	public Mesa(){
		super();
	}

	public Mesa(int banca){
		this.banca = banca;
		maxJugadores = 10;
		ruleta = new Ruleta();
	}
	
	public void unirJugadorActual() {		
		this.unirJugador(new Jugador((Integer.valueOf(this.dineroJugadorEntrante)), this.nombreJugadorEntrante));
		this.setDineroJugadorEntrante("");  // limpia la pantalla
		this.setNombreJugadorEntrante("");  //limpia la pantalla*/
	}
	
	public void unir(Jugador jugador) {
		if (!puedeRecibirJugador(jugador)) {
			throw new RuntimeException("La mesa esta llena intente mas tarde");
		}
		if(this.yaExisteJugador(jugador)){
		   throw new RuntimeException("El pseudonimo ya existe");
		}
		this.unirJugador(jugador);
		System.out.println(this.jugadores+"%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
	
	
	private void unirJugador(Jugador unJugador) {
		this.setBanca(this.getBanca() + unJugador.unirAMesa());
		this.jugadores.add(unJugador);
		System.out.println("se agrega jugador");
		this.firePropertyChange(JUGADORES, null, this.jugadores);
		System.out.println("se actualiza la tabla");
		this.setJugadorActual(unJugador);
		System.out.println("jugador" + jugadorActual.getNombre());
	}

	private void restarBanca(Integer dinero) {
		if(this.banca < dinero){
			throw new RuntimeException("La banca se quedo sin un mango");
		}
		else{
			this.setBanca(this.getBanca() - dinero);			
		}
	}
	
	private boolean yaExisteJugador(Jugador jugador) {
		boolean existe = false;
		for (Jugador j : jugadores ) {
			if (j.getNombre().equals(jugador.getNombre())) {
				existe = true;
			}

		}
		return existe;
	}
	
	public boolean puedeRecibirJugador(Jugador j) {
		boolean puede = true;
		if (jugadores.size() >= this.maxJugadores) {
			puede = false;
		}
		return puede;
	}
	
	

	public void registrarJugada(Apuesta apuesta){
		if(mesaCerrada){
			throw new RuntimeException("la mesa no recibe mas apuestas");
		}
		else{
		int cantidadApostada = apuesta.getFichas();
		apuesta.getJugador().restarFichas(cantidadApostada);
		apuesta.getJugador().apuestas.add(apuesta);
		this.apuestas.add(apuesta);
		//this.setBanca(this.getBanca() + cantidadApostada);
		this.firePropertyChange(JUGADORES, null, jugadores);
		System.out.println("se apuesta" + apuesta.getTipoApuesta() + apuesta.jugadaSeleccionada.getNombre() + apuesta.getFichas());
		}
	}
	
	public synchronized void girarRuleta(){
		if(!mesaCerrada){
			this.mesaCerrada = true;
			this.setNumeroGanador(this.ruleta.getNumeroGanador());
		    //setApuestasAnteriores(apuestas);
		    //System.out.println(apuestasAnteriores);
			this.pagarApuestas();
			this.firePropertyChange(JUGADORES, null, jugadores);
		}
		
	}
		
	public void pagarApuestas(){
		for(Apuesta a:apuestas){
			if(a.ganaParaNumero(numeroGanador)){
				System.out.println("gana apuesta" + a.getTipoApuesta() + "con numero" + a.getJugadaSeleccionada());
				int cantidadGanada = a.fichasGanadas();
				Jugador j = a.getJugador();
				j.sumarFichas(cantidadGanada);
				this.restarBanca(cantidadGanada);
				a.setFichasGanadas(a.fichasGanadas());
			}			
			//a.getJugador().borrarApuesta(a);
		}//fin del for
		//this.apuestas.clear();
	}
	

	public void retirarJugador() {
		Jugador j = this.getJugadorActual();
		this.cambiarFichas(j);
		this.jugadores.remove(j);
		this.firePropertyChange(JUGADORES, null, jugadores);
		//
		this.anularJugadorActual();
		
	}

	private void cambiarFichas(Jugador jugador) {
		int fichas = jugador.getFichas();
		this.restarBanca(fichas);
		jugador.sumarDinero(fichas);
		
	}
	
	public void anularJugadorActual() {
		this.setJugadorActual(null);
	}
	
	//getters y setters

	public Integer getBanca() {
		return banca;
	}

	public void setBanca(Integer banca) {
		this.setFieldValue(BANCA,banca );
	}

	public Integer getNumeroGanador() {
		return numeroGanador;
	}

	public void setNumeroGanador(Integer numeroGanador) {
		this.setFieldValue(NUMEROGANADOR, numeroGanador);
	}

	public String getNombreJugadorEntrante() {
		return nombreJugadorEntrante;
	}

	public void setNombreJugadorEntrante(String nombreJugadorEntranteT) {
		this.setFieldValue(NOMBREJUGADOR, nombreJugadorEntranteT);
	}

	public String getDineroJugadorEntrante() {
		return dineroJugadorEntrante;
	}

	public void setDineroJugadorEntrante(String dineroJugadorEntranteT) {
		if (esDigito(dineroJugadorEntranteT)){
			this.setFieldValue(DINEROJUGADOR, dineroJugadorEntranteT);
		}
			
		this.setFieldValue(DINEROJUGADOR, dineroJugadorEntranteT);
	}
	
	public static boolean esDigito(String dineroJugadorEntranteT) {
		boolean res = true;
		if (!dineroJugadorEntranteT.isEmpty()){
			try {
				Integer.valueOf(dineroJugadorEntranteT);
			}
			catch(NumberFormatException e){
				res = false;

				System.out.println("-"+ dineroJugadorEntranteT +"-No es digito");
			}	
		}
		return res;		
	}
	
	public Jugador getJugadorActual() {		
		return jugadorActual;		
	}
	
	public void setJugadorActual(Jugador jugadorActual) {
		this.setFieldValue(SELECTED, jugadorActual);
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
		this.setFieldValue(JUGADORES, jugadores);		
	}
	
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	
	public void setApuestas(List<Apuesta> apuestas) {
		this.setFieldValue(APUESTAS, apuestas);
	}

	public List<Apuesta> getApuestasAnteriores() {
		return apuestasAnteriores;
	}

	public void setApuestasAnteriores(List<Apuesta> apuestasAnteriores) {
		this.apuestasAnteriores = apuestasAnteriores;
	}
	
	public Integer getNumeroGanadorAnterior() {
		return numeroGanadorAnterior;
	}

	public void setNumeroGanadorAnterior(Integer numeroGanadorAnterior) {
		this.numeroGanadorAnterior = numeroGanadorAnterior;
	}

	public Boolean getMesaCerrada() {
		return mesaCerrada;
	}

	public void setMesaCerrada(Boolean mesaCerrada) {
		this.mesaCerrada = mesaCerrada;
	}
	
	
}