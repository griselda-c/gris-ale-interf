package griselda.alejandro.ruleta_ui_wicket.componentes;

import java.util.List;

import griselda.alejandro.ruleta_ui_wicket.extras.Styler;
import griselda.alejandro.ruleta_ui_wicket.models.JugarApplicationModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.apuestas.Apuesta;
import ruleta.apuestas.OpcionJugada;


public class FormularioApuesta<T> extends Form<T> {

	private static final long serialVersionUID = 2677734979358642016L;

	private DropDownChoice<Apuesta> selectApuestaTipoComponente;
	private DropDownChoice<OpcionJugada> selectJugadaComponente;
	private TextField<String> fichasApostadasComponente;
	private Label feedbackApuestaComponente;
	private AjaxButton apostarComponente;

	private JugarApplicationModel aplicationModel;
	
	public FormularioApuesta(String id, IModel<T> model) {
		super(id, model);
	}
	
	public FormularioApuesta(String id, IModel<T> model, JugarApplicationModel aplicationModel) {
		super(id, model);
		this.aplicationModel = aplicationModel;
		this.agregarComponentesApuesta();
	}
	
	public void agregarComponentesApuesta() {
		this.configurarBotonApostar();
		this.configurarFeedBackApuesta();
		this.configurarComboApuesta();
		this.configurarComboJugada();
		this.configurarCampoFichasApuesta();
		this.configurarBotonGirarRuleta();
		
	}
	
	public void configurarBotonApostar() {
		apostarComponente = new AjaxButton("formularioapuesta.apostar") {
			private static final long serialVersionUID = 3754693047687480068L;		
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				aplicationModel.apostar(target);
			}			
			protected void onError(AjaxRequestTarget arg0, Form<?> arg1) {
			}
		};
		apostarComponente.setEnabled(false);
		apostarComponente.setOutputMarkupId(true);
		this.add(apostarComponente);
	}
	


	public void configurarFeedBackApuesta() {
		feedbackApuestaComponente = new Label("formularioapuesta.feedbackApuesta", new PropertyModel<String>(this.aplicationModel, "feedbackApuesta"));
		feedbackApuestaComponente.setOutputMarkupId(true);
		this.add(feedbackApuestaComponente);
	}
	
	public void setErrorFeedback() {
		Styler.setErrorFeedback(feedbackApuestaComponente);
	}


	public void setOkFeedback() {
		Styler.setOkFeedback(feedbackApuestaComponente);
	}
	
	public void configurarComboApuesta() {
		selectApuestaTipoComponente = new DropDownChoice<Apuesta>("formularioapuesta.seleccionar.apuesta", new PropertyModel<Apuesta>(this.aplicationModel, "apuestaSeleccionada"), this.aplicationModel.getColeccionApuestasPosibles(), new ChoiceRenderer<Apuesta>("tipoApuesta"));
		selectApuestaTipoComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1253701247858206747L;
			protected void onUpdate(AjaxRequestTarget target) {
				selectJugadaComponente.setEnabled(true);
				target.add(selectJugadaComponente);
			}
		});
		selectApuestaTipoComponente.setOutputMarkupId(true);
		this.add(selectApuestaTipoComponente);
	}
	

	public void configurarComboJugada() {
		selectJugadaComponente = new DropDownChoice<OpcionJugada>("formularioapuesta.seleccionar.jugada", new PropertyModel<OpcionJugada>(this.aplicationModel, "jugadaSeleccionada"), new PropertyModel<List<OpcionJugada>>(this.aplicationModel, "opionesApuestaSeleccionada"), new ChoiceRenderer<OpcionJugada>("nombre"));
		selectJugadaComponente.setEnabled(false);
		selectJugadaComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 8695705523039667573L;

			protected void onUpdate(AjaxRequestTarget target) {
				apostarComponente.setEnabled(true);
				target.add(apostarComponente);
			}
		});
		selectJugadaComponente.setOutputMarkupId(true);
		this.add(selectJugadaComponente);
	}
	
	public void configurarCampoFichasApuesta() {
		fichasApostadasComponente = new TextField<String>("formularioapuesta.fichas.apostadas", new PropertyModel<String>(this.aplicationModel, "fichasApostadas"));
		fichasApostadasComponente.setOutputMarkupId(true);
		this.add(fichasApostadasComponente);
	}

	public void actualizarEn(AjaxRequestTarget target) {
		target.add(this.fichasApostadasComponente);
		target.add(this.selectApuestaTipoComponente);
		target.add(this.selectJugadaComponente);
		target.add(this.feedbackApuestaComponente);
		target.add(this.apostarComponente);			
	}
	
	public void volverAEstadoInicial(){
    	this.selectJugadaComponente.setEnabled(false);
    	this.apostarComponente.setEnabled(false);
	}
	

	public void configurarBotonGirarRuleta() {
		AjaxButton girarRuletaComponente = new AjaxButton("formularioapuesta.girarruleta") {
			private static final long serialVersionUID = -3966634221400817055L;
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				aplicationModel.girarRuleta(target);
			}			
			protected void onError(AjaxRequestTarget arg0, Form<?> arg1) {
			}
		};
		add(girarRuletaComponente);
	}
	
}
