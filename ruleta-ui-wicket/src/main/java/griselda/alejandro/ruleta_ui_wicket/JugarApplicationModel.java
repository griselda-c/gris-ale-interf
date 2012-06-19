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
	
	public Integer  fichasApostadas;
	public ApuestaWeb apuestaSeleccionada;
	public OpcionJugada jugadaSeleccionada;
	public OpcionJugada apuestaVista;
	public String feedbackApuesta = "Ingrese la cantidad de fichas que desea apostar:";
	
	
	public JugarApplicationModel(Mesa mesa, Jugador jugador, JugarPage jugarPage) {
		this.jugador = jugador;
		this.mesa = mesa;
		this.jugarPage = jugarPage;	
		this.fichasApostadas = 0;
	}	
	
	public List<Apuesta> getApuestasPartida(){
		if(apuestaVista == null){
			return Collections.emptyList();
		}
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		if(aplicacion.apuestasActuales[apuestaVista.getValor()].apuestasSlot == null){
			throw new RuntimeException("error al intentar obtener las apuestas del valor " + apuestaVista.getValor());
		}
		return aplicacion.apuestasActuales[apuestaVista.getValor()].apuestasSlot;
		
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
		
		Apuesta nuevaApuesta = apuestaSeleccionada.create();
		nuevaApuesta.setFichas(fichasApostadas);
		nuevaApuesta.setJugadaSeleccionada(jugadaSeleccionada);
		nuevaApuesta.setJugador(this.jugador);
		nuevaApuesta.confirmar();
		
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		aplicacion.apuestasActuales[jugadaSeleccionada.getValor()].apuestasSlot.add(nuevaApuesta);
		
		apuestaSeleccionada = null;
		jugadaSeleccionada = null;
		fichasApostadas = 0;
		jugarPage.selectJugadaComponente.setEnabled(false);
		jugarPage.apostarComponente.setEnabled(false);
		
		target.add(jugarPage.fichasApostadasComponente);
		target.add(jugarPage.selectJugadaComponente);
		target.add(jugarPage.selectApuestaTipoComponente);
		target.add(jugarPage.fichasJugadorComponente);
		target.add(jugarPage.apostarComponente);
		target.add(jugarPage.apuestasContainer);
				
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
		return WicketApplication.staticGetJugadores();		
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


	public Integer getFichasApostadas() {
		return fichasApostadas;
	}


	public void setFichasApostadas(Integer fichasApostadas) {
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

	public List<? extends OpcionJugada> getJugadasPosibles() {
		List<OpcionJugada> jugadas = new LinkedList<OpcionJugada>();
		jugadas.addAll(new ParImpar().getOpciones());
		jugadas.addAll(new Pleno().getOpciones());
		return jugadas;
	}

	public String getFeedbackApuesta() {
		return feedbackApuesta;
	}

	public void setFeedbackApuesta(String feedbackApuesta) {
		this.feedbackApuesta = feedbackApuesta;
	}

	
	
}
