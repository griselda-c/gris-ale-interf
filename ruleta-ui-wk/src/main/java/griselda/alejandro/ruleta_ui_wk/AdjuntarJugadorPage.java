package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


import ruleta.Mesa;

public class AdjuntarJugadorPage extends WebPage{
	
	private static final long serialVersionUID = 1L;
	private Mesa mesa;
	private JugadorModel jugador = new JugadorModel();
	private FeedbackPanel feedbackPanel;
	
	public AdjuntarJugadorPage(final PageParameters parameters) {
		this.mesa = new Mesa(1000);
		Form<JugadorModel> adjuntarForm = new Form<JugadorModel>("adjuntarJugadorForm", this.createModel());
		this.generarCamposIngreso(adjuntarForm);
		this.add(adjuntarForm);
		
		
		
		
	}//adnuntar jugador

	
	private void generarCamposIngreso(Form<JugadorModel> parent) {
		
		TextField<String>dinero = new TextField<String>("dinero");
		parent.add(dinero);
	    
		TextField<String> nombre = new TextField<String>("nombre");
		parent.add(nombre);
		
		parent.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
		
		
	    
	}//generarCampos
	
	private void addActions(Form<JugadorModel> form) {
		form.add(new Button("unirJugador") {
			@Override
			public void onSubmit() {
				jugador.createJugador();
				mesa.unirJugador(jugador.getJugador());
			}
		});
	}
	protected CompoundPropertyModel<JugadorModel> createModel() {
		
		return new CompoundPropertyModel<JugadorModel>(new JugadorModel());
	}
	
}//fin de la clase
