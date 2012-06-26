package griselda.alejandro.ruleta_ui_wk;


import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.OpcionJugada;


public class ApostarPage extends WebPage{

	private static final long serialVersionUID = 1L;

	private DropDownChoice<ApuestaWeb> comboApuesta;
	private DropDownChoice<OpcionJugada> comboJugada;
	private Jugador jugador;
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	private ApuestaModel apuestaModelo = new ApuestaModel();
	private ListView<Apuesta> listaApuestas;
	protected Label labelMensaje= new Label ("numero","");
	protected Label labelRuletaMensaje = new Label("mensajeRuleta","");
	
	
	public ApostarPage(Jugador j,WebPage page){
	     jugador = j;
	     paginaAnterior = page;
	    Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm", new CompoundPropertyModel<ApuestaModel>(apuestaModelo));
	    this.add(apuestaForm);
		this.addFields(apuestaForm);
		this.addAction(apuestaForm);
		this.crearCombos(apuestaForm);
		this.agregarLink();	
		this.agregarLabelFichasJugador();
		this.generarGrillaApuestas();
		add(labelMensaje);
		add(labelRuletaMensaje);
		add(new Link<Object>("girarRuleta"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				try{  
	            	            	 
	            	 RuletaWicketApplication.getRuletaApplication().girarRuleta();
	            	 getPaginaActual().labelRuletaMensaje.setDefaultModelObject("El numero ganador es:");
	            	 getPaginaActual().labelMensaje.setDefaultModelObject(getMesa().getNumeroGanador());
				}
				catch (BusinessException e)
				{feedbackPanel.error(e.getMessage());};
				
			}
			
		});
	}
	
	
	protected Mesa getMesa(){
		return  RuletaWicketApplication.getRuletaApplication().getMesa();
	}
	
	private void addFields(Form<ApuestaModel> form) {		
	    TextField<String> textfieldFichas = new TextField<String>("fichas");
	    textfieldFichas.setRequired(true);
		textfieldFichas.setOutputMarkupId(true);
	    form.add(textfieldFichas);
	    FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		form.add(feedbackPanel);			
	}
	
	private void agregarLabelFichasJugador(){
		Label labelFrase = new Label("nombreJugador",jugador.nombre +" tiene disponible ");
		Label labelFichasDisponibles = new Label("fichasJugador",new PropertyModel<String> (jugador, "fichas"));
		add(labelFrase);
		add(labelFichasDisponibles);
	}
	
	protected ApostarPage getPaginaActual(){
		return this;
	}
	
	private void crearCombos(Form<ApuestaModel> form){
		
	    comboApuesta = new DropDownChoice<ApuestaWeb>("apuestaSeleccionada",new PropertyModel<ApuestaWeb>(apuestaModelo, "apuestaSeleccionada"),ApuestaModel.getApuestas(),new ChoiceRenderer<ApuestaWeb>("tipoApuesta"));
	    comboApuesta.setOutputMarkupId(true);
	    comboApuesta.setRequired(true);
	    form.add(comboApuesta);
	  
	    comboJugada =new DropDownChoice<OpcionJugada>("opcionJugada",new PropertyModel<OpcionJugada>(apuestaModelo,"opcionJugada"),new PropertyModel(apuestaModelo,"opciones"),new ChoiceRenderer<Object>("nombre"));
	    comboJugada.setOutputMarkupId(true);
	    comboJugada.setEnabled(false);
	    comboJugada.setRequired(true);
	    form.add(comboJugada);
	   
	    comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void onUpdate(AjaxRequestTarget target) {
            	comboJugada.setEnabled(true);
                target.add(comboJugada);
            }
        });
		
		
		
	}

	
	private void addAction(Form<ApuestaModel> form){
	form.add(new Button("apostar") {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void onSubmit() {
			try{  
				
				ApuestaModel apuesta = apuestaModelo;
				apuesta.setJugador(jugador);
				apuesta.crearApuesta();
				
				
			}
			catch (RuntimeException e)
			{ApostarPage.this.feedbackPanel.error(e.getMessage());};
			
			
			
			}
	});
	
	
	
}

	
	
	private void generarGrillaApuestas(){
		
		listaApuestas = new ListView<Apuesta>("apuestas",new PropertyModel(jugador, "apuestas")) {
	      
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem item) {
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel<String>(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel<String>(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel<String>(item.getModelObject(), "fichas"));
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	         }
	     };
	     add(listaApuestas);
		
	}
	private void volverPaginaAnterior(){
		this.setResponsePage(paginaAnterior);
		
	}


	private void agregarLink(){
		add(new Link<Object>("volver"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				volverPaginaAnterior();
				
			}
			
		});
		
	}
	
	
	

	
}
