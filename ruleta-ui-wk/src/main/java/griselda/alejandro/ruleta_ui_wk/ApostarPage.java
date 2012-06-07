package griselda.alejandro.ruleta_ui_wk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.OpcionJugada;

public class ApostarPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public DropDownChoice comboApuestaw;
	public DropDownChoice comboJugadaw;
	public Jugador jugador;
	public WebPage paginaAnterior;
	public FeedbackPanel feedbackPanel;
	//public String fichasApuesta;
	//public ApuestaModel.ApuestaWeb apuestaNombre;
	//public String jugadaNombre;
	//public Apuesta apuesta;
	public List<OpcionJugada> opciones = new LinkedList<OpcionJugada>();

	public ApostarPage(Jugador j, AdjuntarJugadorPage mainPage) {
		paginaAnterior = mainPage;
		jugador = j;
		CompoundPropertyModel<Apuesta> formModel = new CompoundPropertyModel<Apuesta>(this.getApuestaModel().getApuestaSeleccionada());
		
		this.comboJugadaw = this.getJugadas(apuestaForm);
		this.add(apuestaForm);
		this.addFields(apuestaForm);
		this.getComboTipoApuesta(apuestaForm);
		this.addAction(apuestaForm);
	}

	public void addFields(Form<Apuesta> form) {
		form.add(new TextField<String>("fichas");
		feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupId(true);
		form.add(feedbackPanel);
	}

	public void getComboTipoApuesta(Form<Apuesta> form) {
		ChoiceRenderer choiceRender = new ChoiceRenderer("tipo");
		DropDownChoice comboApuesta = new DropDownChoice("tipoApuesta",new PropertyModel(this, "apuestaNombre"),apuestaM.staticApuestas, choiceRender);
		form.add(comboApuesta);
		// Add Ajax Behaviour...
		comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			protected void onUpdate(AjaxRequestTarget target) {
				// Reset the phone model dropdown when the vendor changes
				// comboJugada.setChoices(apuestaM.getApuesta(apuestaNombre).getOpciones());
				feedbackPanel.error("nada" + apuestaNombre.getTipoApuesta());
				target.add(feedbackPanel);
				// target.add(comboJugadaw);
			}
		});
		// return comboApuesta;
	}

	public DropDownChoice getJugadas(Form<Apuesta> form) {
		List list = Collections.EMPTY_LIST;
		if (apuestaNombre != null) {
			// list = apuestaNombre.apuesta.getOpciones();
			list = (List) new PropertyModel(apuestaNombre, "opciones");
		}
		ChoiceRenderer choiceJugada = new ChoiceRenderer("nombre");
		DropDownChoice comboJugada = new DropDownChoice("jugada", new PropertyModel(this, "jugadaNombre"), list, choiceJugada);
		comboJugada.setOutputMarkupId(true); // Needed for Ajax to update it
		form.add(comboJugada);
		return comboJugada;
	}

	public void addAction(Form<Apuesta> form) {
		form.add(new Button("apostar") {
			@Override
			public void onSubmit() {
				try { /*
					 * apuesta = apuestaM.getApuesta(apuestaNombre);
					 * apuesta.setJugador(jugador);
					 * apuesta.setFichas(Integer.parseInt(fichasApuesta));
					 * if(opciones.isEmpty()){ opciones = apuesta.getOpciones();
					 * 
					 * }
					 */
				}// try
				catch (RuntimeException e) {
					ApostarPage.this.feedbackPanel.error(e.getMessage());
				}
				;

			}// onSubmit
		});

	}

	protected ApuestaModel getApuestaModel() {
		return (ApuestaModel) this.getDefaultModelObject();
	}

	
	
	public CompoundPropertyModel<ApuestaModel> createModel() {

		return new CompoundPropertyModel<ApuestaModel>(new ApuestaModel());
	}
	
	

	/*
	 * public DropDownChoice getComboApuestaw() { return comboApuestaw; }
	 * 
	 * public void setComboApuestaw(DropDownChoice comboApuestaw) {
	 * this.comboApuestaw = comboApuestaw; }
	 * 
	 * public DropDownChoice getComboJugadaw() { return comboJugadaw; }
	 * 
	 * public void setComboJugadaw(DropDownChoice comboJugadaw) {
	 * this.comboJugadaw = comboJugadaw; }
	 * 
	 * public Jugador getJugador() { return jugador; }
	 * 
	 * public void setJugador(Jugador jugador) { this.jugador = jugador; }
	 * 
	 * public WebPage getPaginaAnterior() { return paginaAnterior; }
	 * 
	 * public void setPaginaAnterior(WebPage paginaAnterior) {
	 * this.paginaAnterior = paginaAnterior; }
	 * 
	 * public ApuestaModel getApuestaM() { return apuestaM; }
	 * 
	 * public void setApuestaM(ApuestaModel apuestaM) { this.apuestaM =
	 * apuestaM; }
	 * 
	 * public FeedbackPanel getFeedbackPanel() { return feedbackPanel; }
	 * 
	 * public void setFeedbackPanel(FeedbackPanel feedbackPanel) {
	 * this.feedbackPanel = feedbackPanel; }
	 * 
	 * public String getFichasApuesta() { return fichasApuesta; }
	 * 
	 * public void setFichasApuesta(String fichasApuesta) { this.fichasApuesta =
	 * fichasApuesta; }
	 * 
	 * 
	 * public String getJugadaNombre() { return jugadaNombre; }
	 * 
	 * public void setJugadaNombre(String jugadaNombre) { this.jugadaNombre =
	 * jugadaNombre; }
	 * 
	 * public String getJugadorNombre() { return jugadorNombre; }
	 * 
	 * public void setJugadorNombre(String jugadorNombre) { this.jugadorNombre =
	 * jugadorNombre; }
	 * 
	 * public Apuesta getApuesta() { return apuesta; }
	 * 
	 * public void setApuesta(Apuesta apuesta) { this.apuesta = apuesta; }
	 * 
	 * public List<OpcionJugada> getOpciones() { return opciones; }
	 * 
	 * public void setOpciones(List<OpcionJugada> opciones) { this.opciones =
	 * opciones; }
	 */

}
