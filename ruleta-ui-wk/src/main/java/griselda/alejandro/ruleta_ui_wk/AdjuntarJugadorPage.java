package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import ruleta.Jugador;
import ruleta.Mesa;

public class AdjuntarJugadorPage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	private FeedbackPanel feedbackPanel;
	private UnirJugadorModel jugador;
	private ListView<Jugador> view;
	private WebMarkupContainer listContainer;
	private Label labelNombre = new Label ("nombre","");
	private Label cantFichas = new Label ("cantFichas","");
	private Label fichas = new Label ("fichas","");
	private Label finFrase = new Label ("finFrase","");
	protected Label labelMensaje= new Label ("mensaje","");
	
	
	public AdjuntarJugadorPage() {
		//this.setDefaultModel(this.createModel());
		//CompoundPropertyModel<Jugador> formModel = new CompoundPropertyModel<Jugador>(this.getUnirJugadorModel().getJugador());
		jugador = new UnirJugadorModel(getMesa());
		CompoundPropertyModel<Jugador> formModel = new CompoundPropertyModel<Jugador>(jugador.getJugador());
		Form<Jugador> adjuntarForm = new Form<Jugador>("adjuntarJugadorForm", formModel);
		this.add(adjuntarForm);
		this.generarGrillaJugadores();
		this.generarCamposIngreso(adjuntarForm);
		this.addActions(adjuntarForm);
		this.agregarLink();
		
		add(labelMensaje);
		add(labelNombre);
		add(fichas);
		add(cantFichas);
		add(finFrase);
		
		
		
		//view.setOutputMarkupId(true); 
		
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
					//UnirJugadorModel unirJugadorModel = getUnirJugadorModel();
					UnirJugadorModel unirJugadorModel = jugador;
					unirJugadorModel.unir();
					
					 getPaginaActual().labelMensaje.setDefaultModelObject("Bienvenido");
					 getPaginaActual().labelNombre.setDefaultModelObject(jugador.getJugador().getNombre());
					 getPaginaActual().cantFichas.setDefaultModelObject( "Usted tiene ");				 
					 getPaginaActual().fichas.setDefaultModelObject(jugador.getJugador().fichas);
					 getPaginaActual().finFrase.setDefaultModelObject("fichas");
							
					
				}
				catch (BusinessException e) {
					feedbackPanel.error(e.getMessage());
				}
			}

			
		});
	}
/*
	protected CompoundPropertyModel<UnirJugadorModel> createModel() {
		Mesa mesa =
		return new CompoundPropertyModel<UnirJugadorModel>(new UnirJugadorModel(mesa));
	}
*/
	
	
	protected void generarGrillaJugadores(){
	   
		view = new ListView<Jugador>("jugadores",new PropertyModel(getMesa(), "jugadores")) {
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem<Jugador> item) {
	           final Label nombreJugador = new Label("label", new PropertyModel<String>(item.getModel(), "nombre"));
	           item.add(nombreJugador);
	           item.add(new Link<Object>("verApuestas"){
	        	   /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void onClick() {
	        		   
	        		   Jugador j = (Jugador) item.getModelObject();
	        		   AdjuntarJugadorPage.this.mostrarApuestas(j);
	        	   };
	        	   
	           });
	         }
	     };
	 	
	     add(view);
	     /*
	     listContainer = new WebMarkupContainer("theContainer");
	     listContainer.setOutputMarkupId(true);
	     listContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
	     listContainer.add(view);
	     add(listContainer);
		*/
	}
	
	protected void mostrarApuestas(Jugador j){
		
		ApuestasJugadorPage apuestasJugador = new ApuestasJugadorPage(j,getPaginaActual());
		this.setResponsePage(apuestasJugador);
	}
	
	protected AdjuntarJugadorPage getPaginaActual(){
		return this;
	}
	
	protected void agregarLink(){
		
		add(new Link<Object>("verEstadoMesa"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				mostrarEstadoMesa();
				
			}
			
		});
		
		add(new Link<Object>("linkApuesta")
	     {
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onClick()
	         {
	        	 ApostarPage nextPage = new ApostarPage(jugador.getJugador(),getPaginaActual());
	     		this.setResponsePage(nextPage);
	         }
	     });
		
	}


	protected void mostrarEstadoMesa(){
		EstadoMesaPage estadoMesa = new EstadoMesaPage(getPaginaActual());
		this.setResponsePage(estadoMesa);
	}
		
	
	/*
	protected UnirJugadorModel getUnirJugadorModel() {
		return (UnirJugadorModel) this.getDefaultModelObject();
	}
	*/
	protected Mesa getMesa(){
		return  RuletaWicketApplication.getRuletaApplication().getMesa();
	}

}