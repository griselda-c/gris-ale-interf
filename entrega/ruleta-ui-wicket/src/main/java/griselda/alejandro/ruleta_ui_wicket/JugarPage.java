package griselda.alejandro.ruleta_ui_wicket;

import griselda.alejandro.ruleta_ui_wicket.componentes.FormularioApuesta;
import griselda.alejandro.ruleta_ui_wicket.componentes.ListadoGeneral;
import griselda.alejandro.ruleta_ui_wicket.componentes.ListadoGeneralSelected;
import griselda.alejandro.ruleta_ui_wicket.models.JugarApplicationModel;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import ruleta.Jugador;
import ruleta.apuestas.Apuesta;


public class JugarPage extends WebPage {
	private static final long serialVersionUID = 8370294431505724616L;

	public JugarApplicationModel model;
	
	private FormularioApuesta<JugarApplicationModel> formularioApuesta;
	private ListadoGeneral<Jugador> listadoJugadores;
	private ListadoGeneral<Apuesta> listadoPartidaAnterior;
	private ListadoGeneral<Apuesta> listadoVistaPrincipal;
	private Label numeroGanadorComponente;
	private Label fichasJugadorComponente;
	private MarkupContainer adjuntarContainer;

	private ListadoGeneralSelected listadoColumnaListModel;
	

	public JugarPage(Jugador jugadorModel) {
		this.model = new JugarApplicationModel(jugadorModel, this);
		
		this.configurarNombreJugador();
		this.configurarLabelFichasJugador();		
		this.configurarNumeroGanador();
				
		this.configurarComponentesVistaPrincipal();
		
		formularioApuesta = new FormularioApuesta<JugarApplicationModel>("formularioapuesta", new CompoundPropertyModel<JugarApplicationModel>(this.model), this.model);
		this.add(formularioApuesta);
		
		String idsListadoArrayJ[] = {"nombre", "fichas", "cantidadApuestas"};
		listadoJugadores = new ListadoGeneral<Jugador>("jugadoresPartidaActual", this.model, idsListadoArrayJ);
		this.add(listadoJugadores);
		
		String idsListadoArrayP[] = {"tipoApuesta","jugadaString", "fichasString", "ganadasString"};
		listadoPartidaAnterior = new ListadoGeneral<Apuesta>("apuestasPartidaAnterior", this.model, idsListadoArrayP);
		this.add(listadoPartidaAnterior);
		
		String idsListadoArrayV[] = {"tipoApuesta","jugadaString", "fichasString", "jugador.nombre"};
		listadoVistaPrincipal = new ListadoGeneral<Apuesta>("apuestasVistaPrincipal", this.model, idsListadoArrayV);
		this.add(listadoVistaPrincipal);
		
		String idsListadoArrayM[] = {"tipoApuestaCorto","jugadaString"};
		listadoColumnaListModel = new ListadoGeneralSelected("columnaListModel", this.model, idsListadoArrayM);
		this.add(listadoColumnaListModel);

		configurarContainerAdjuntarJugador();

		this.agregarActualizacionAutomatica();
		
	}


	public void configurarContainerAdjuntarJugador() {		
		AjaxLink<JugarApplicationModel> adjuntarComponente = new AjaxLink<JugarApplicationModel>("adjuntarPartida") {
			private static final long serialVersionUID = 7147050173118500399L;
			public void onClick(AjaxRequestTarget target) {
				model.unirseANuevaPartidaAjax(target);
			}
		};
		adjuntarComponente.setOutputMarkupId(true);		
		
		Label  estadoRuletaComponente = new Label("estadoruleta", new PropertyModel<String>(this.model, "estadoRuleta"));
		estadoRuletaComponente.setOutputMarkupId(true);	
		
		adjuntarContainer = new MarkupContainer("adjuntarJugadorContainer") {
			private static final long serialVersionUID = 1L;
		};
		adjuntarContainer.setOutputMarkupId(true);
		adjuntarContainer.setVisible(false);
		
		adjuntarContainer.add(estadoRuletaComponente);
		adjuntarContainer.add(adjuntarComponente);
		this.add(adjuntarContainer);
	}
	

	private void configurarComponentesVistaPrincipal() {

		AjaxLink<JugarApplicationModel> mostrarPropias = new AjaxLink<JugarApplicationModel>("mostrarApuestasPropias") {
			private static final long serialVersionUID = 7147050173118500399L;
			public void onClick(AjaxRequestTarget target) {
				model.mostarApuestasPropiasAjax(target);				
			}
		};
		mostrarPropias.setOutputMarkupId(true);
		this.add(mostrarPropias);
		
		AjaxLink<JugarApplicationModel> mostrarTodas = new AjaxLink<JugarApplicationModel>("mostrarApuestasTodos") {
			private static final long serialVersionUID = 7147050173118500399L;
			public void onClick(AjaxRequestTarget target) {
				model.mostarTodasLasApuestasAjax(target);				
			}
		};
		mostrarTodas.setOutputMarkupId(true);
		this.add(mostrarTodas);
		
	}

	public void configurarNombreJugador() {
		add(new Label("model.jugador.nombre", this.getModel().getJugador().getNombre()));
	}	

	public void configurarLabelFichasJugador() {
		fichasJugadorComponente = new Label("model.jugador.fichas", new PropertyModel<Integer>(this.model.getJugador(), "fichas"));
		fichasJugadorComponente.setOutputMarkupId(true);
		this.add(fichasJugadorComponente);
	}

	public void configurarNumeroGanador() {
		numeroGanadorComponente = new Label("apuestaanterior.numeroganador", new PropertyModel<String>(this.model, "numeroGanadorPartidaAnterior"));		
		numeroGanadorComponente.setOutputMarkupId(true);
		add(numeroGanadorComponente);
	}
	

	public void agregarActualizacionAutomatica() {
		add(new AbstractAjaxTimerBehavior(Duration.seconds(1))
        {
			private static final long serialVersionUID = -3385972088664246524L;
            protected void onTimer(AjaxRequestTarget target)
            {        
            	model.actualizarEn(target);
            	target.add(listadoVistaPrincipal);
            	target.add(listadoJugadores);
            }
        });
	}


	
	//access
	
	public JugarApplicationModel getModel(){
		return this.model;
	}


	public void setErrorFeedback() {
		this.formularioApuesta.setErrorFeedback();
	}

	public void setOkFeedback() {
		this.formularioApuesta.setOkFeedback();
	}

	public void actualizarFormularioApuestasEn(AjaxRequestTarget target) {
		this.formularioApuesta.actualizarEn(target);
		
	}

	public void volverAEstadoInicialFormularioApuestasEn() {
		this.formularioApuesta.volverAEstadoInicial();		
	}

	public void actualizarNuevaApuesta(AjaxRequestTarget target) {
		target.add(this.formularioApuesta);
		target.add(this.listadoJugadores);
		target.add(this.fichasJugadorComponente);
		target.add(this.listadoVistaPrincipal);
	}

	public void actualizarCambioPartidaEnAjax(AjaxRequestTarget target) {
		
		

		this.formularioApuesta.setEnabled(false);
		target.add(this.formularioApuesta);
		
		this.adjuntarContainer.setVisible(true);
		target.add(this.adjuntarContainer);
		
		this.listadoVistaPrincipal.setVisible(false);
		target.add(this.listadoVistaPrincipal);
		
		target.add(this.numeroGanadorComponente);
		target.add(this.listadoPartidaAnterior);
		target.add(this.fichasJugadorComponente);
	}


	public void actualizarunirseAPartidaEnAjax(AjaxRequestTarget target) {
		
		this.formularioApuesta.setEnabled(true);
		target.add(this.formularioApuesta);
		
		this.adjuntarContainer.setVisible(false);
		target.add(this.adjuntarContainer);
		
		this.listadoVistaPrincipal.setVisible(true);
		target.add(this.listadoVistaPrincipal);
		
		target.add(this.listadoPartidaAnterior);	
	}

	
}
