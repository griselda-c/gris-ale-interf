package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ruleta.Jugador;
import ruleta.Mesa;

public class AdjuntarJugadorPage extends WebPage {
	private static final long serialVersionUID = 1L;
	private FeedbackPanel feedbackPanel;

	public AdjuntarJugadorPage(final PageParameters parameters) {
		this.setDefaultModel(this.createModel());
		CompoundPropertyModel<Jugador> formModel = new CompoundPropertyModel<Jugador>(this.getUnirJugadorModel().getJugador());
		Form<Jugador> adjuntarForm = new Form<Jugador>("adjuntarJugadorForm", formModel);
		this.add(adjuntarForm);
		
		this.generarCamposIngreso(adjuntarForm);
		this.addActions(adjuntarForm);
	}

	private void generarCamposIngreso(Form<Jugador> parent) {
		final TextField<String> dinero = new TextField<String>("dinero");
		dinero.setRequired(true);
		parent.add(dinero);

		final TextField<String> nombre = new TextField<String>("nombre");
		nombre.setRequired(true);
		parent.add(nombre);

		parent.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
	}

	private void addActions(Form<Jugador> form) {
		form.add(new Button("unirJugador") {
			@Override
			public void onSubmit() {
				try {
					UnirJugadorModel unirJugadorModel = getUnirJugadorModel();
					unirJugadorModel.unir();
					irABienvenidaPage(unirJugadorModel);
				}
				catch (BusinessException e) {
					feedbackPanel.error(e.getMessage());
				}
			}
		});
	}

	protected CompoundPropertyModel<UnirJugadorModel> createModel() {
		Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
		return new CompoundPropertyModel<UnirJugadorModel>(new UnirJugadorModel(mesa));
	}
	
	protected void irABienvenidaPage(UnirJugadorModel unirJugadorModel) {
		BienvenidaPage nextPage = new BienvenidaPage(unirJugadorModel.getJugador(), this);
		this.setResponsePage(nextPage);
	}
	
	protected UnirJugadorModel getUnirJugadorModel() {
		return (UnirJugadorModel) this.getDefaultModelObject();
	}

}