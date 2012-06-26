package griselda.alejandro.ruleta_ui_wicket;

import griselda.alejandro.ruleta_ui_wicket.JugarApplicationModel.ApuestaWeb;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.OpcionJugada;

public class JugarPage extends WebPage {

	public JugarApplicationModel model;

	public Form<JugarApplicationModel> form;
	public DropDownChoice<ApuestaWeb> selectApuestaTipoComponente;
	public DropDownChoice<OpcionJugada> selectJugadaComponente;
	public DropDownChoice<OpcionJugada> selectApuestaVistaComponete;
	public TextField<Integer> fichasApostadasComponente;
	public AjaxButton apostarComponente;
	public Label fichasJugadorComponente;
	public Label feedbackApuestaComponente;
	public Label numeroGanadorComponente;
	public ListView<JugadorModel> jugadoresComponente;
	public ListView<Apuesta> apuestasComponente;
	public ListView<ApuestaAnteriorModel> apuestasAnterioresComponente;
	public WebMarkupContainer jugadoresContainer;
	public WebMarkupContainer apuestasContainer;
	public WebMarkupContainer partidaAnteriorContainer;
	public AjaxButton girarRuletaComponente;

	@SuppressWarnings("serial")
	public JugarPage(Mesa mesaModel, Jugador jugadorModel) {
		this.model = new JugarApplicationModel(mesaModel, jugadorModel, this);
		add(new Label("nombreJugador", this.model.jugador.nombre));
		configurarFormularioApuesta();
		configurarLabelFichasJugador();
		configurarListadoJugadores();
		configurarListadoApuestas();
		configurarListadoApuestasPartidaAnterior();
		configurarSelectApuestas();
		configurarNumeroGanador();		
		configurarActualizables();
	}

	public void configurarNumeroGanador() {
		//TODO
		numeroGanadorComponente = new Label("numeroGanador", new PropertyModel<Integer>(this.model.mesa, "numeroGanador"));
		add(numeroGanadorComponente);
	}

	public void configurarSelectApuestas() {
		Form<JugarApplicationModel> formApuestaVista = new Form<JugarApplicationModel>("formApuestaVista", new PropertyModel<JugarApplicationModel>(this, "model"));
		this.add(formApuestaVista);
		selectApuestaVistaComponete = new DropDownChoice<OpcionJugada>("selectApuestaVista", new PropertyModel<OpcionJugada>(this.model, "apuestaVista"), new PropertyModel<List<OpcionJugada>>(this.model, "juagadasActivas"), new ChoiceRenderer<OpcionJugada>("nombre"));
		formApuestaVista.add(selectApuestaVistaComponete);
		selectApuestaVistaComponete.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(apuestasContainer);
			}
		});
		selectApuestaVistaComponete.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
	}

	public void configurarFormularioApuesta() {
		form = new Form<JugarApplicationModel>("form_apuesta", new CompoundPropertyModel<JugarApplicationModel>(this.model));
		this.agregarComponentesApuesta(form);
		this.add(form);
	}

	public void configurarLabelFichasJugador() {
		fichasJugadorComponente = new Label("fichasJugador", new PropertyModel<Integer>(this.model.getJugador(), "fichas"));
		add(fichasJugadorComponente);
	}

	public void configurarActualizables() {
		selectApuestaTipoComponente.setOutputMarkupId(true);
		selectJugadaComponente.setOutputMarkupId(true);
		fichasApostadasComponente.setOutputMarkupId(true);
		fichasJugadorComponente.setOutputMarkupId(true);
		jugadoresComponente.setOutputMarkupId(true);
		apuestasComponente.setOutputMarkupId(true);
		apostarComponente.setOutputMarkupId(true);
		feedbackApuestaComponente.setOutputMarkupId(true);
		numeroGanadorComponente.setOutputMarkupId(true);
		apuestasAnterioresComponente.setOutputMarkupId(true);
	}

	public void configurarListadoApuestas() {
		apuestasComponente = new ListView<Apuesta>("apuestas", new PropertyModel<List<Apuesta>>(this.model, "apuestasPartida")) {
			@Override
			protected void populateItem(ListItem<Apuesta> item) {
				item.add(new Label("jugadorApuestaList", new PropertyModel<String>(item.getModel(), "jugador.nombre")));
				item.add(new Label("tipoApuestaList", new PropertyModel<String>(item.getModel(), "tipoApuesta")));
				item.add(new Label("fichasApuestaList", new PropertyModel<Integer>(item.getModel(), "fichas")));
			}
		};
		apuestasContainer = new WebMarkupContainer("apuestasContainer");
		apuestasContainer.setOutputMarkupId(true);
		apuestasContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		apuestasContainer.add(apuestasComponente);
		add(apuestasContainer);
	}

	public void configurarListadoApuestasPartidaAnterior() {

		// TODO controlar al girar la ruleta que se actualicen las apuestas de
		// la partida anterior

		apuestasAnterioresComponente = new ListView<ApuestaAnteriorModel>("apuestasAnteriores", new PropertyModel<List<ApuestaAnteriorModel>>(this.model, "apuestasPartidaAnterior")) {
			@Override
			protected void populateItem(ListItem<ApuestaAnteriorModel> item) {
				item.add(new Label("tipoApuesta", new PropertyModel<String>(item.getModel(), "tipoApuesta")));
				item.add(new Label("jugadaApuesta", new PropertyModel<String>(item.getModel(), "jugada")));
				item.add(new Label("fichasApuesta", new PropertyModel<Integer>(item.getModel(), "apostadas")));
				item.add(new Label("pagaApuesta", new PropertyModel<Integer>(item.getModel(), "ganadas")));
			}
		};
		partidaAnteriorContainer = new WebMarkupContainer(
				"partidaAnteriorContainer");
		partidaAnteriorContainer.setOutputMarkupId(true);
		partidaAnteriorContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		partidaAnteriorContainer.add(apuestasAnterioresComponente);
		add(partidaAnteriorContainer);
	}

	public void configurarListadoJugadores() {
		jugadoresComponente = new ListView<JugadorModel>("jugadores", new PropertyModel<List<JugadorModel>>(this.model, "jugadores")) {
			@Override
			protected void populateItem(ListItem<JugadorModel> item) {
				item.add(new Label("nombreJugadorList", new PropertyModel<String>(item.getModel(), "nombre")));
				item.add(new Label("fichasJugadorList", new PropertyModel<String>(item.getModel(), "fichas")));
				item.add(new Label("apuestasJugadorList", new PropertyModel<String>(item.getModel(), "cantidadApuestas")));
			}
		};
		jugadoresContainer = new WebMarkupContainer("jugadoresContainer");
		jugadoresContainer.setOutputMarkupId(true);
		jugadoresContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		jugadoresContainer.add(jugadoresComponente);
		add(jugadoresContainer);
	}

	public void agregarComponentesApuesta(Form<JugarApplicationModel> form) {
		configurarCampoFichasApuesta(form);
		configurarBotonApostar(form);
		configurarBotonGirarRuketa(form);
		configurarComboApuesta(form);
		configurarComboJugada(form);
		configurarFeedBackApuesta(form);
	}

	public void configurarFeedBackApuesta(Form<JugarApplicationModel> form) {
		feedbackApuestaComponente = new Label("feedBackApuesta", new PropertyModel<String>(this.model, "feedbackApuesta"));
		form.add(feedbackApuestaComponente);
	}

	public void configurarBotonGirarRuketa(Form<JugarApplicationModel> form) {
		// TODO
		girarRuletaComponente = new AjaxButton("girarRuleta") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				model.girarRuleta(target);
			}

			@Override
			protected void onError(AjaxRequestTarget arg0, Form<?> arg1) {
			}
		};
		// girarRuletaComponente.setEnabled(false);
		form.add(girarRuletaComponente);
	}

	public void configurarBotonApostar(Form<JugarApplicationModel> form) {
		apostarComponente = new AjaxButton("apostar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				model.apostar(target);
			}
			@Override
			protected void onError(AjaxRequestTarget arg0, Form<?> arg1) {
			}
		};
		apostarComponente.setEnabled(false);
		form.add(apostarComponente);
	}

	public void configurarCampoFichasApuesta(Form<JugarApplicationModel> form) {
		fichasApostadasComponente = new TextField<Integer>("fichasApostadas", new PropertyModel<Integer>(this.model, "fichasApostadas"));
		form.add(fichasApostadasComponente);
	}

	public void configurarComboApuesta(Form<JugarApplicationModel> form) {
		selectApuestaTipoComponente = new DropDownChoice<ApuestaWeb>("selectApuesta", new PropertyModel<ApuestaWeb>(this.model, "apuestaSeleccionada"), JugarApplicationModel.staticApuestas, new ChoiceRenderer<ApuestaWeb>("tipoApuesta"));
		form.add(selectApuestaTipoComponente);
		selectApuestaTipoComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			protected void onUpdate(AjaxRequestTarget target) {
				selectJugadaComponente.setEnabled(true);
				target.add(selectJugadaComponente);
			}
		});
	}

	public void configurarComboJugada(Form<JugarApplicationModel> form) {
		selectJugadaComponente = new DropDownChoice<OpcionJugada>("selectJugada", new PropertyModel<OpcionJugada>(this.model, "juagadaSeleccionada"), new PropertyModel<List<OpcionJugada>>(this.model, "opciones"), new ChoiceRenderer<OpcionJugada>("nombre"));
		selectJugadaComponente.setEnabled(false);
		form.add(selectJugadaComponente);
		selectJugadaComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			protected void onUpdate(AjaxRequestTarget target) {
				apostarComponente.setEnabled(true);
				target.add(apostarComponente);
			}
		});
	}

	public DropDownChoice<ApuestaWeb> getSelectApuestaTipo() {
		return selectApuestaTipoComponente;
	}

	public void setSelectApuestaTipo(
			DropDownChoice<ApuestaWeb> selectApuestaTipo) {
		this.selectApuestaTipoComponente = selectApuestaTipo;
	}

	public DropDownChoice<OpcionJugada> getSelectJugada() {
		return selectJugadaComponente;
	}

	public void setSelectJugada(DropDownChoice<OpcionJugada> selectJugada) {
		this.selectJugadaComponente = selectJugada;
	}

	public void setErrorFeedback() {
		feedbackApuestaComponente.add(new AttributeModifier("style", setRedColor()));
	}

	public IModel<String> setRedColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
			public String getObject() {
				return "color: red;";
			}
		};
		return colorModel;
	}
	
	public IModel<String> setWhiteColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
			public String getObject() {
				return "color: white;";
			}
		};
		return colorModel;
	}

	public void setOkFeedback() {
		feedbackApuestaComponente.add(new AttributeModifier("style", setWhiteColor()));		
	}

	
}
