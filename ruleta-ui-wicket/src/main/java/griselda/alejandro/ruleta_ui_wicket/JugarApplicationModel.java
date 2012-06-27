package griselda.alejandro.ruleta_ui_wicket;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.protocol.http.WebApplication;

import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.OpcionJugada;
import ruleta.ParImpar;
import ruleta.Pleno;

public class JugarApplicationModel {
	
	public Jugador jugador;
	public Mesa mesa;	
	public JugarPage jugarPage;
	public WicketApplication aplicacion;
	
	public String  fichasApostadas;
	public ApuestaWeb apuestaSeleccionada;
	public OpcionJugada jugadaSeleccionada;
	public OpcionJugada apuestaVista;
	public String feedbackApuesta = "Ingrese la cantidad de fichas que desea apostar:";
	public Partida partidaActual;	
	
	public JugarApplicationModel(Mesa mesa, Jugador jugador, JugarPage jugarPage) {
		this.aplicacion = (WicketApplication) WebApplication.get();
		this.jugador = jugador;
		this.mesa = mesa;
		this.jugarPage = jugarPage;	
		this.fichasApostadas = "";				
		this.unirseANuevaPartida();		
	}	
	
	public void levantarModalEn(AjaxRequestTarget target) {
		//TODO
		jugarPage.modalRuletaCoponente.setContent(new ModalRuletaPanel(jugarPage.modalRuletaCoponente.getContentId()));
		//jugarPage.modalRuletaCoponente.show(target);
	}
	
	public void unirseANuevaPartidaAjax(AjaxRequestTarget target) {
		//TODO actualiza los componentes necesarios
		this.unirseANuevaPartida();
	}
	
	public void unirseANuevaPartida() {
		/**esto agrega el jugador a la nueva partida*/
		this.partidaActual = aplicacion.partidaActual;
		this.partidaActual.jugadoresModel.add(new JugadorModel(this.jugador));
	}
	
	public String getEstadoRuleta(){
		if(!aplicacion.partidaActual.equals(this.partidaActual)){
			return "Se termino la partida anterior";
		}
		return "No cambio la partida aun";
	}
	
	public boolean cambioPartida(){
		return !aplicacion.partidaActual.equals(this.partidaActual);
	}	
	
	/**retorna una lista con los valores posibles del select apuesta vista*/
	public List<Apuesta> getApuestasPartida(){
		
		if(apuestaVista == null){
			return Collections.emptyList();
		}
		if(partidaActual.slotsApuestas[apuestaVista.getValor()].apuestasSlot == null){
			throw new RuntimeException("error al intentar obtener las apuestas del valor " + apuestaVista.getValor());
		}
		return partidaActual.slotsApuestas[apuestaVista.getValor()].apuestasSlot;
	}	
	
	/**Retorna una lista con apuestas model para mostrar los resulados de la partida anterior */
	public List<ApuestaAnteriorModel> getApuestasPartidaAnterior(){
		return getApuestasModelFrom(aplicacion.partidaAnterior);
	}
	
	/**Retorna una lista con apuestasModel para mostrar los resulados delas apuestas en la partida */
	public List<ApuestaAnteriorModel> getApuestasModelFrom(Partida partida) {
		List<ApuestaAnteriorModel> apuestasDeJugador = new LinkedList<ApuestaAnteriorModel>();
		Integer numeroGanadorAnterior = partida.resultadoPartida;
		for (int i = 0; i < partida.slotsApuestas.length; i++) {
			for (Apuesta apuesta : partida.slotsApuestas[i].apuestasSlot) {
				if(apuesta.jugador.equals(this.jugador)){
					apuestasDeJugador.add(new ApuestaAnteriorModel(apuesta, partida.resultadoPartida));
				}
			}			
		}			
		return apuestasDeJugador;
	}

	public List<OpcionJugada> getOpciones() {
		if(apuestaSeleccionada != null){
		    return apuestaSeleccionada.getOpciones();
		}
		else{
			return Collections.emptyList();			
		}
	}	
		
	public void apostar(AjaxRequestTarget target){
		
		if(this.cambioPartida()){			
			levantarModalEn(target);
			target.add(jugarPage.partidaAnteriorContainer);
			actualizarGeneral(target);
		}else if(fichasApostadas.equals("0")){
			feedbackApuesta = "Debe ingresar una suma mayor a cero";
			jugarPage.setErrorFeedback();
		}else if(!RuletaWicketModel.isNumber(fichasApostadas)){
			feedbackApuesta = "Debe ingresar una suma entera";
			jugarPage.setErrorFeedback();
		}else{
			jugarPage.setOkFeedback();
			feedbackApuesta = "Ingrese la cantidad de fichas que desea apostar:";
			
			Apuesta nuevaApuesta = apuestaSeleccionada.create();
			nuevaApuesta.setFichas(Integer.valueOf(fichasApostadas));
			nuevaApuesta.setJugadaSeleccionada(jugadaSeleccionada);
			nuevaApuesta.setJugador(this.jugador);
			nuevaApuesta.confirmar();
			
			/**agrega a la partid actual la apuesta realizada*/
			partidaActual.slotsApuestas[jugadaSeleccionada.getValor()].apuestasSlot.add(nuevaApuesta);
			
			apuestaSeleccionada = null;
			jugadaSeleccionada = null;
			fichasApostadas = "";
			jugarPage.selectJugadaComponente.setEnabled(false);
			jugarPage.apostarComponente.setEnabled(false);		

			actualizarGeneral(target);
		}
		target.add(jugarPage.feedbackApuestaComponente);
	}


	public void girarRuleta(AjaxRequestTarget target){					
		aplicacion.girarRuleta();
		levantarModalEn(target);
		actualizarGeneral(target);
	}

	public void actualizarGeneral(AjaxRequestTarget target) {
		target.add(jugarPage.fichasApostadasComponente);
		target.add(jugarPage.selectJugadaComponente);
		target.add(jugarPage.selectApuestaTipoComponente);
		target.add(jugarPage.fichasJugadorComponente);
		target.add(jugarPage.apostarComponente);
		target.add(jugarPage.apuestasContainer);
		target.add(jugarPage.selectApuestaVistaComponete);
		target.add(jugarPage.jugadoresContainer);	
		target.add(jugarPage.numeroGanadorComponente);
	}
	
	public static List<ApuestaWeb> staticApuestas = getApuestas();


	private static List<ApuestaWeb> getApuestas() {
		List<ApuestaWeb> apuestas = new LinkedList<ApuestaWeb>();
		apuestas.add(new ColumnaWeb());
		apuestas.add(new FilaWeb());
		apuestas.add(new PlenoWeb());
		apuestas.add(new ParImparWeb());
		return apuestas;
	}
	
	public List<JugadorModel> jugadores(){		
		return aplicacion.getJugadoresModel();
	}
	
	public static abstract class ApuestaWeb{
		public Apuesta apuesta;
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}		
		public abstract Apuesta create();
		
		public List<OpcionJugada> getOpciones(){
			return this.apuesta.getOpciones();
		}
	}
	
	public static class ColumnaWeb extends ApuestaWeb{
		
		public ColumnaWeb(){
			super();
			apuesta = new Columna();
		}
		
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Columna();
		}
		
	}
	
	public static class FilaWeb extends ApuestaWeb{
		
		public FilaWeb(){
			super();
			apuesta = new Fila();
		}
		
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Fila();
		}
		
	}
	
	public static class PlenoWeb extends ApuestaWeb{		

		public PlenoWeb(){
			super();
			apuesta = new Pleno();
		}
		
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Pleno();
		}
		
	}
	
	public static class ParImparWeb extends ApuestaWeb{
		
		public ParImparWeb(){
			super();
			apuesta = new ParImpar();
		}
		
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new ParImpar();
		}
		
	}
	

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public ApuestaWeb getApuestaSeleccionada() {
		return apuestaSeleccionada;
	}

	public void setApuestaSeleccionada(ApuestaWeb apuestaSeleccionada) {
		this.apuestaSeleccionada = apuestaSeleccionada;
	}

	public OpcionJugada getJuagadaSeleccionada() {
		return jugadaSeleccionada;
	}

	public void setJuagadaSeleccionada(OpcionJugada juagadaSeleccionada) {
		this.jugadaSeleccionada = juagadaSeleccionada;
	}


	public String getFichasApostadas() {
		return fichasApostadas;
	}


	public void setFichasApostadas(String fichasApostadas) {
		this.fichasApostadas = fichasApostadas;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public OpcionJugada getApuestaVista() {
		return apuestaVista;
	}

	public void setApuestaVista(OpcionJugada apuestaVista) {
		this.apuestaVista = apuestaVista;
	}

	public List<? extends OpcionJugada> getJuagadasActivas() {
		List<OpcionJugada> jugadas = new LinkedList<OpcionJugada>();
		jugadas.addAll(new ParImpar().getOpciones());
		jugadas.addAll(new Pleno().getOpciones());
		
		List<OpcionJugada> jugadasEnCurso = new LinkedList<OpcionJugada>();
		
		for (OpcionJugada opcionJugada : jugadas) {
			if(!partidaActual.slotsApuestas[opcionJugada.getValor()].apuestasSlot.isEmpty()){
				jugadasEnCurso.add(opcionJugada);
			}
		}		
		
		return jugadasEnCurso;
		
	}

	public String getFeedbackApuesta() {
		return feedbackApuesta;
	}

	public void setFeedbackApuesta(String feedbackApuesta) {
		this.feedbackApuesta = feedbackApuesta;
	}
	
	public Integer getNumeroGanador(){
		return this.aplicacion.partidaActual.resultadoPartida;
	}

	public Integer getNumeroGanadorUltimaPartidaJugador(){
		//TODO devuelve el numero ganador del jugador model, es para mostrar los resultados de las puestas del jugador
		return this.partidaActual.resultadoPartida;
	}
	
	
}
