package ruleta;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.apuestas.Apuesta;
import ruleta.apuestas.OpcionJugada;
import ruleta.exceptions.RuletaException;
import ruleta.exceptions.TerminoPartidaException;
import ruleta.extras.Validador;

public class Jugador implements Serializable{
	private static final long serialVersionUID = 627992329932490023L;
	
	private String nombre;
	private Integer fichas;
	private Integer dinero;
	private List<Apuesta> apuestas;
	private List<Apuesta> apuestasPartidaAnterior;
	private Partida partidaActual;
	private Partida partidaAnterior;


	protected Jugador(Integer dineroT, String nombreT){ //Solo para uso de los test
		this.setDinero(dineroT);
		this.setNombre(nombreT);
		this.setFichas(0);
		this.setPartidaActual(new Partida());
		this.setPartidaAnterior(new Partida());
		this.setApuestas(new LinkedList<Apuesta>());
		this.setApuestasPartidaAnterior(new LinkedList<Apuesta>());
	}
	
	public Jugador(Integer dineroT, String nombreT, Partida partidaActual){
		this.setDinero(dineroT);
		this.setNombre(nombreT);
		this.setFichas(0);
		this.setPartidaActual(partidaActual);
		this.setPartidaAnterior(new Partida());
		this.setApuestas(new LinkedList<Apuesta>());
		this.setApuestasPartidaAnterior(new LinkedList<Apuesta>());
	}

	public void sumarFichas(Integer cantidad) {
		this.setFichas(this.getFichas() + cantidad);
	}

	public void sumarDinero(Integer dienero) {
		this.setDinero(this.getDinero() + dienero);
	}

	public void restarFichas(Integer cantidad) {
		if(cantidad > this.getFichas()){
			throw new RuletaException("Cantidad de fichas no valido");
		}
		else{
			this.setFichas(this.getFichas() - cantidad);
		}
	}

	public Integer unirAMesa() {
		Integer cambio = this.getDinero()*80/100;
		this.setFichas(this.getFichas() + cambio);
		this.setDinero(this.getDinero() - cambio);
		return cambio;
	}

	public void apostar(String fichasApostadas, Apuesta apuestaSeleccionada, OpcionJugada jugadaSeleccionada) {
		
		if(cambioPartida()){
			throw new TerminoPartidaException("La partida del jugador no es la misma que la de la mesa");
		}
		if(fichasApostadas == null){
			throw new RuletaException("Ingrese una cantidad superior a 0", "");
	    }
	    if(fichasApostadas.equals("0")){
			throw new RuletaException("Ingrese una cantidad superior a 0", "");
	    }			
	    if(!Validador.isNumber(fichasApostadas)){
	    	throw new RuletaException("Debe ingresar una suma entera", "");
	    }
	    
    	Apuesta nuevaApuesta = apuestaSeleccionada.create();
    	nuevaApuesta.setFichas(Integer.valueOf(fichasApostadas));
    	nuevaApuesta.setJugadaSeleccionada(jugadaSeleccionada);
    	nuevaApuesta.setJugador(this);
		this.partidaActual.registrarJugada(nuevaApuesta);
		agregarApuesta(nuevaApuesta);
	}
	
	public boolean cambioPartida() {		
		return !this.getPartidaActual().equals(this.getMesa().getPartidaActual());
	}

	public void unirseANuevaPartida(){
		this.setPartidaAnterior(this.getPartidaActual());
		this.setPartidaActual(this.getMesa().agregarAPartidaActual(this));
	}
	

	public void rotarApuestas() {
		this.setApuestasPartidaAnterior(this.getApuestas());
		this.setApuestas(new LinkedList<Apuesta>());		
	}
	
	//access	
	
	
	
	public Integer getCantidadApuestas(){
		return this.getApuestas().size();
	}
	
	public void agregarApuesta(Apuesta apuesta) {
		this.apuestas.add(apuesta);
	}	
	
	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}

	public Partida getPartidaAnterior() {
		return partidaAnterior;
	}

	public void setPartidaAnterior(Partida partidaAnterior) {
		this.partidaAnterior = partidaAnterior;
	}

	public void borrarApuesta(Apuesta apuesta){
		this.apuestas.remove(apuesta);
	}

	public Mesa getMesa() {
		return Mesa.getInstancia();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getFichas() {
		return fichas;
	}

	public void setFichas(Integer fichas) {
		this.fichas = fichas;
	}

	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	public List<Apuesta> getApuestasPartidaAnterior() {
		return apuestasPartidaAnterior;
	}

	public void setApuestasPartidaAnterior(List<Apuesta> apuestasPartidaAnterior) {
		this.apuestasPartidaAnterior = apuestasPartidaAnterior;
	}


	
	

}
