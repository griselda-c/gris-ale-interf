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
	private String jugadorDinero;
	private String jugadorNombre;
	private FeedbackPanel feedbackPanel;
	
	public AdjuntarJugadorPage(final PageParameters parameters) {
		this.mesa = new Mesa(1000);
		Form<JugadorModel> adjuntarForm = new Form<JugadorModel>("adjuntarJugadorForm", this.createModel());
		this.generarCamposIngreso(adjuntarForm);
		this.add(adjuntarForm);
		this.addActions(adjuntarForm);
		
		
		
		
	}//adjuntar jugador

	
	private void generarCamposIngreso(Form<JugadorModel> parent) {
		
		TextField<String>dinero = new TextField<String>("dinero",new PropertyModel<String>(this, "jugadorDinero"));
		parent.add(dinero);
		//,new PropertyModel<String>(this, "jugadorDinero")
		TextField<String> nombre = new TextField<String>("nombre",new PropertyModel<String>(this, "jugadorNombre"));
		parent.add(nombre);
		
		parent.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
		
		
	    
	}//generarCampos
	
	public JugadorModel getJugador() {
		return jugador;
	}


	public void setJugador(JugadorModel jugador) {
		this.jugador = jugador;
	}


	public String getJugadorDinero() {
		return jugadorDinero;
	}


	public void setJugadorDinero(String jugadorDinero) {
		this.jugadorDinero = jugadorDinero;
	}


	public FeedbackPanel getFeedbackPanel() {
		return feedbackPanel;
	}


	public void setFeedbackPanel(FeedbackPanel feedbackPanel) {
		this.feedbackPanel = feedbackPanel;
	}


	private void addActions(Form<JugadorModel> form) {
		form.add(new Button("unirJugador") {
			@Override
			public void onSubmit() {
				jugador.setDinero(Integer.parseInt(jugadorDinero));
				jugador.setNombre(jugadorNombre);
				jugador.createJugador();
				mesa.unirJugador(jugador.getJugador());
				System.out.println("jugador" + jugador.getNombre());
			}
		});
	}
	protected CompoundPropertyModel<JugadorModel> createModel() {
		
		return new CompoundPropertyModel<JugadorModel>(new JugadorModel());
	}
	
}//fin de la clase
