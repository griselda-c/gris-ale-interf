package griselda.alejandro.ruleta_ui_wk;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;




import ruleta.Jugador;
import ruleta.Mesa;


public class AdjuntarJugadorPage extends WebPage{
	
	private static final long serialVersionUID = 1L;
	private Mesa mesa;
	private int maxJugadores = 10;
	private JugadorModel jugador = new JugadorModel();
	private String jugadorDinero;
	private String jugadorNombre;
	private FeedbackPanel feedbackPanel;
	private FormComponent[] componentes;
	
	
	public AdjuntarJugadorPage(final PageParameters parameters) {
		this.mesa = new Mesa(1000);
		Form<JugadorModel> adjuntarForm = new Form<JugadorModel>("adjuntarJugadorForm", this.createModel());
		this.generarCamposIngreso(adjuntarForm);
		this.add(adjuntarForm);
		this.addActions(adjuntarForm);
		
		
		
		
		
		
	}//adjuntar jugador

	
	private void generarCamposIngreso(Form<JugadorModel> parent) {
		
		final TextField<String>dinero = new TextField<String>("dinero",new PropertyModel<String>(this, "jugadorDinero"));
		parent.add(dinero);
		
		final TextField<String> nombre = new TextField<String>("nombre",new PropertyModel<String>(this, "jugadorNombre"));
		parent.add(nombre);
		
		parent.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
		
		parent.add(new IFormValidator(){

			private static final long serialVersionUID = 1L;

			@Override
			public FormComponent<?>[] getDependentFormComponents() {
				componentes = new FormComponent[]{dinero, nombre}; 
				
				return componentes;
			}

			@Override
			public void validate(Form<?> form) {
				if(componentes[0]== null ){
					throw new IllegalArgumentException(" El dinero no puede ser nulo");
				}
				
				if(componentes[1]== null){
					throw new IllegalArgumentException(" El nombre no puede ser nulo");
				}
				
				
				
			}
			
		}// validator
		);
	    
	}//generarCampos
	
	

	



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
				try{
					jugador.setDinero(Integer.parseInt(jugadorDinero));
					jugador.setNombre(jugadorNombre);
					jugador.createJugador();
					if(puedeRecibirJugador(jugador.getJugador())){
					mesa.unirJugador(jugador.getJugador());
					this.setResponsePage(ApostarPage.class);
					AdjuntarJugadorPage.this.Apostar(jugador.getJugador());
					System.out.println("jugador" + jugador.getNombre());
					}// fin del if}
					else{
						AdjuntarJugadorPage.this.feedbackPanel.error(" No se pudo unir al jugador");
					}
				
				}//try
				catch (RuntimeException e)
				{AdjuntarJugadorPage.this.feedbackPanel.error(e.getMessage());};
				
				
				
				
			}// onSubmit
		});
	}
	
	private boolean yaExisteJugador(Jugador jugador){
		boolean existe = false;
		for(Jugador j:mesa.getJugadores()){
			 if(j.getNombre() == jugador.getNombre()){
				 existe = true;
			 }
			
		}
		return existe;
	}
	
	public boolean puedeRecibirJugador(Jugador j){
		boolean puede = true;
		if(mesa.getJugadores().size() > this.maxJugadores || yaExisteJugador(j)){
			puede = false;
		}
		
		return puede;
		
	}
	
	protected CompoundPropertyModel<JugadorModel> createModel() {
		
		return new CompoundPropertyModel<JugadorModel>(new JugadorModel());
	}
	
	protected void Apostar(Jugador j){
		ApostarPage nextPage = new ApostarPage(j,this);
		this.setResponsePage(nextPage);
	}
	
}//fin de la clase
