package griselda.alejandro.ruleta_ui_wk;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.RuletaApplication;


public class AdjuntarJugadorPage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	private FeedbackPanel feedbackPanel;
	private Jugador jugador;
	
	
	
	public AdjuntarJugadorPage() {
		//this.setDefaultModel(this.createModel());
		//CompoundPropertyModel<Jugador> formModel = new CompoundPropertyModel<Jugador>(this.getUnirJugadorModel().getJugador());
		jugador = new Jugador(0,"");
		CompoundPropertyModel<Jugador> formModel = new CompoundPropertyModel<Jugador>(jugador);
		Form<Jugador> adjuntarForm = new Form<Jugador>("adjuntarJugadorForm", formModel);
		this.add(adjuntarForm);
		this.generarCamposIngreso(adjuntarForm);
		this.addActions(adjuntarForm);	
		
		
	}
	
	
	protected RuletaApplication getRuletaApplication(){
		return  RuletaWicketApplication.getRuletaWicketApplication().getRuletaApplication();
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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				try {
					
				    Mesa mesa = getRuletaApplication().getMesa(jugador);
				   // System.out.println("mesa jugador " +jugador.getNombre() +mesa);
				    mesa.unir(jugador);
					irAPaginaBienvenida();
					 
							
					
				}
				catch (BusinessException e) {
					feedbackPanel.error(e.getMessage());
				}
			}

			
		});
	}

	
public void irAPaginaBienvenida(){
	
	BienvenidaPage bienvenida = new BienvenidaPage(jugador);
	this.setResponsePage(bienvenida);
	
}
	
	
	
	
	/*
	protected CompoundPropertyModel<UnirJugadorModel> createModel() {
		Mesa mesa =
		return new CompoundPropertyModel<UnirJugadorModel>(new UnirJugadorModel(mesa));
	}
*/
	
	
	
	
	
	
	
	
	
	
	

}