package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;


import ruleta.Mesa;

public class AdjuntarJugadorPage extends WebPage{
	
	public static final long serialVersionUID = 1L;
	public Mesa mesa;
	public JugadorModel jugador = new JugadorModel();
	public FeedbackPanel feedbackPanel;
	public String dineroJugador;
	
	public String getDineroJugador() {
		return dineroJugador;
	}


	public void setDineroJugador(String dineroJugador) {
		this.dineroJugador = dineroJugador;
	}


	public AdjuntarJugadorPage() {
		this.mesa = new Mesa(1000);
		Form<JugadorModel> adjuntarForm = new Form<JugadorModel>("adjuntarJugadorForm", this.createModel());
		this.generarCamposIngreso(adjuntarForm);
		this.add(adjuntarForm);
		addActions(adjuntarForm);
		
		
		
	}//adjuntar jugador

	
	public void generarCamposIngreso(Form<JugadorModel> parent) {
		
		TextField<String>dinero = new TextField<String>("dinero",new PropertyModel<String>(this, "dineroJugador"));
		parent.add(dinero);
	    
		TextField<String> nombre = new TextField<String>("nombre");
		parent.add(nombre);
		
		parent.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
		
		
	    
	}//generarCampos
	
	private void addActions(Form<JugadorModel> form) {
		form.add(new Button("unirJugador") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				//jugador.createJugador();
				//mesa.unirJugador(jugador.getJugador());
				System.out.println("el nombre del jugador es: "+ dineroJugador);
			}
		});
	}
	protected CompoundPropertyModel<JugadorModel> createModel() {
		
		return new CompoundPropertyModel<JugadorModel>(new JugadorModel());
	}
	
}//fin de la clase
