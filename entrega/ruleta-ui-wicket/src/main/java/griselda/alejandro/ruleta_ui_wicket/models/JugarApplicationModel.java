package griselda.alejandro.ruleta_ui_wicket.models;

import griselda.alejandro.ruleta_ui_wicket.JugarPage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;

import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.apuestas.Apuesta;
import ruleta.apuestas.OpcionJugada;
import ruleta.exceptions.RuletaException;
import ruleta.exceptions.TerminoPartidaException;

public class JugarApplicationModel implements Serializable{
	private static final long serialVersionUID = -7962009390546831624L;
	
	private Jugador jugador;
	private JugarPage jugarPage;
	
	private String  fichasApostadas;
	private Apuesta apuestaSeleccionada;
	private OpcionJugada jugadaSeleccionada;
	private OpcionJugada apuestaVista;
	private String feedbackApuesta;
	private boolean mostrarPropias;
	private final String FEEDBACKDEFAULT = "Ingrese la cantidad de fichas que desea apostar:";

	
	public JugarApplicationModel(Jugador jugador, JugarPage jugarPage) {		
		this.jugador = jugador;
		this.jugarPage = jugarPage;	
		this.feedbackApuesta = FEEDBACKDEFAULT;
		this.fichasApostadas = "";				
		this.getJugador().unirseANuevaPartida();
		this.mostrarPropias = false;
	}		
	
    public void apostar(AjaxRequestTarget target){		
    	try{
    		this.jugador.apostar(fichasApostadas, apuestaSeleccionada, jugadaSeleccionada);			
    		feedbackApuesta = FEEDBACKDEFAULT;
    		volverAEstadoInicial();
    		this.jugarPage.actualizarNuevaApuesta(target);
    	}
    	//Se maneja que se halla cambiado la partida
    	catch (TerminoPartidaException e) {
    		this.jugarPage.actualizarCambioPartidaEnAjax(target);
		}
    	 //Se maneja un error de datos se mouestra el error de la excepcion
    	catch (RuletaException e) {       
    		feedbackApuesta = e.getError();
    		jugarPage.setErrorFeedback();
		}
    	this.jugarPage.actualizarFormularioApuestasEn(target);    	
	}
    

	public void volverAEstadoInicial() {
		this.apuestaSeleccionada = null;
		this.jugadaSeleccionada = null;
    	this.fichasApostadas = "";
    	this.jugarPage.volverAEstadoInicialFormularioApuestasEn();
    	this.jugarPage.setOkFeedback();
	}
		
	public void girarRuleta(AjaxRequestTarget target){					
		this.getMesa().girarRuleta();
		this.jugarPage.actualizarCambioPartidaEnAjax(target);
	}
	
	/**####################### TODO ###############################**/
	
	/**retorna una lista con los valores posibles del select apuesta vista*/
	public List<Apuesta> getApuestasPartida(){
		//TODO generar esta lista
		if(apuestaVista == null){
			return Collections.emptyList();
		}
		return Collections.emptyList();		
	}	
	
	public List<? extends OpcionJugada> getJuagadasActivas() {
		//para completar
		return Collections.emptyList();		
	}		
	
	public void unirseANuevaPartidaAjax(AjaxRequestTarget target) {
		this.getJugador().unirseANuevaPartida();
		this.jugarPage.actualizarunirseAPartidaEnAjax(target);
	}
	
	/**####################### ACCESS ###############################**/	
	//access	
	

	public List<Apuesta>getApuestasVistaPrincipal(){
		if(cambioPartida()){
			return Collections.emptyList();
		}
		if(this.mostrarPropias){
			return this.jugador.getApuestas();
		}
		return this.jugador.getPartidaActual().getApuestas();			
	}

	public boolean cambioPartida(){
		return this.getJugador().cambioPartida();
	}	

	public String getEstadoRuleta(){
		if(cambioPartida()){
			return "Se termino la partida anterior";
		}
		return "No cambio la partida aun";
	}	

	public List<OpcionJugada> getOpionesApuestaSeleccionada() {
		if(apuestaSeleccionada != null){
		    return apuestaSeleccionada.getOpciones();
		}
		else{
			return Collections.emptyList();			
		}
	}

	public List<Apuesta> getApuestasPartidaAnterior(){
		return this.getJugador().getApuestasPartidaAnterior();
	}

    public List<Jugador> getJugadoresPartidaActual(){
    	return this.getJugador().getPartidaActual().getJugadores();
    }
	
	public String getNumeroGanadorPartidaAnterior(){
		Integer numeroGanador = this.getJugador().getPartidaAnterior().getNumeroGanador();
		if(numeroGanador == null){
			return "";
		}
		return String.valueOf(numeroGanador);
	}

	public List<Apuesta> getColeccionApuestasPosibles(){
		return Apuesta.getColeccionApuestasPosibles();
	}

	public List<Jugador> jugadores(){		
		return this.getMesa().getJugadores();
	}
	
	public Mesa getMesa() {
		return Mesa.getInstancia();
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public JugarPage getJugarPage() {
		return jugarPage;
	}

	public void setJugarPage(JugarPage jugarPage) {
		this.jugarPage = jugarPage;
	}

	public String getFichasApostadas() {
		return fichasApostadas;
	}

	public void setFichasApostadas(String fichasApostadas) {
		this.fichasApostadas = fichasApostadas;
	}

	public Apuesta getApuestaSeleccionada() {
		return apuestaSeleccionada;
	}

	public void setApuestaSeleccionada(Apuesta apuestaSeleccionada) {
		this.apuestaSeleccionada = apuestaSeleccionada;
	}

	public OpcionJugada getJugadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJugadaSeleccionada(OpcionJugada jugadaSeleccionada) {
		this.jugadaSeleccionada = jugadaSeleccionada;
	}

	public OpcionJugada getApuestaVista() {
		return apuestaVista;
	}

	public void setApuestaVista(OpcionJugada apuestaVista) {
		this.apuestaVista = apuestaVista;
	}

	public String getFeedbackApuesta() {
		return feedbackApuesta;
	}

	public void setFeedbackApuesta(String feedbackApuesta) {
		this.feedbackApuesta = feedbackApuesta;
	}

	public void mostarApuestasPropiasAjax(AjaxRequestTarget target) {
		this.mostrarPropias = true;
		this.jugarPage.actualizarNuevaApuesta(target);
	}

	public void mostarTodasLasApuestasAjax(AjaxRequestTarget target) {
		this.mostrarPropias = false;
		this.jugarPage.actualizarNuevaApuesta(target);		
	}

	public void actualizarEn(AjaxRequestTarget target) {
		if(cambioPartida()){			
			this.jugarPage.actualizarCambioPartidaEnAjax(target);
		}		
	}
	
	
	
}
