package griselda.alejandro.ruleta_ui_wk;


import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
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
import ruleta.RuletaApplication;


public class ApostarPage extends WebPage{

	private static final long serialVersionUID = 1L;

	private DropDownChoice<ApuestaWeb> comboApuesta;
	private DropDownChoice<OpcionJugada> comboJugada;
	private Jugador jugador;
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	private FeedbackPanel feedbackPanelRuleta;
	private ApuestaModel apuestaModelo = new ApuestaModel();
	private ListView<Apuesta> listaApuestas;
	protected Label labelMensaje= new Label ("numero","");
	protected Label labelRuletaMensaje = new Label("mensajeRuleta","");
	protected TextField<String> textfieldFichas;
	
	
	public ApostarPage(Jugador j,WebPage page){
	     jugador = j;
	     paginaAnterior = page;
	    Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm", new CompoundPropertyModel<ApuestaModel>(apuestaModelo));
	    Form<Mesa> ruletaForm = new Form<Mesa>("ruletaForm", new CompoundPropertyModel<Mesa>(getRuletaApplication().getMesa(jugador)));
	    ruletaForm.add(labelRuletaMensaje);
	    ruletaForm.add(labelMensaje);
	    apuestaForm.setOutputMarkupId(true);
	    feedbackPanelRuleta = new FeedbackPanel("feedbackPanelRuleta");
	    feedbackPanelRuleta.setOutputMarkupId(true);
	    ruletaForm.add(feedbackPanelRuleta);	
	    this.add(apuestaForm);
	    this.add(ruletaForm);
		this.addFields(apuestaForm);
		this.addAction(apuestaForm);
		this.crearCombos(apuestaForm);
		this.agregarLink();	
		this.agregarLabelFichasJugador();
		this.generarGrillaApuestas();
		this.botonGirarRuleta(ruletaForm);
	   
	}
	
	
	protected RuletaApplication getRuletaApplication(){
		return  RuletaWicketApplication.getRuletaWicketApplication().getRuletaApplication();
	}
	
	private void botonGirarRuleta(Form<Mesa> form){
		form.add(new AjaxButton("girarRuleta"){

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				try{  
					System.out.println("Fichas" +jugador.fichas);
	                Mesa mesa = getRuletaApplication().getMesa(jugador);
					mesa.girarRuleta();
					System.out.println("Fichas" +jugador.fichas);
		
	            	 labelRuletaMensaje.setDefaultModelObject("El numero ganador es:");
	            	 labelMensaje.setDefaultModelObject(mesa.getNumeroGanador());
	            	 labelRuletaMensaje.setOutputMarkupId(true);
	            	 labelMensaje.setOutputMarkupId(true);
	            	 form.setOutputMarkupId(true);
	            	
	            	 target.add(form);
	            	 target.add(labelRuletaMensaje);
	            	 target.add(labelMensaje);
	            	 irAPaginaResultado();
	                 
	            	 
	            	 /*
	            	 ModalWindow modal =new ModalWindowApuesta("apuestaM", getDefaultModel());
	            	 add(modal);
	            	 modal.show(target);
	            	 */
				}
				catch (BusinessException e)
				{feedbackPanelRuleta.error(e.getMessage());};
				
				
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
	private void addFields(Form<ApuestaModel> form) {		
	    textfieldFichas = new TextField<String>("fichas");
	    textfieldFichas.setRequired(true);
		textfieldFichas.setOutputMarkupId(true);
	    form.add(textfieldFichas);
	    feedbackPanel = new FeedbackPanel("feedbackPanel");
	    feedbackPanel.setOutputMarkupId(true);
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
				Mesa mesa = getRuletaApplication().getMesa(jugador);
				System.out.println("mesa "+ mesa);
				apuestaModelo.setJugador(jugador);
				Apuesta apuesta = apuestaModelo.crearApuesta(); 
				mesa.registrarJugada(apuesta);
				
				}
					
			catch (RuntimeException e)
			{feedbackPanel.error(e.getMessage());};
			
			
			
			};
	});

	/*
		@Override
		protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            try{  
				
				ApuestaModel apuesta = apuestaModelo;
				apuesta.setJugador(jugador);
				apuesta.crearApuesta();
				target.add(form);
				target.add(comboApuesta);
			    target.add(comboJugada);
			    target.add(textfieldFichas);
			    target.add(feedbackPanel);
			
				
				
			}
			catch (BusinessException e)
			{feedbackPanel.error(e.getMessage());};
			
			
		}

		@Override
		protected void onError(AjaxRequestTarget target, Form<?> form) {
			
			
			
		}
	});
	
	
	*/
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
	
	public void irAPaginaResultado(){
		
		ResultadosPage resultados = new ResultadosPage(jugador);
		this.setResponsePage(resultados);
		
	}
	

	
}
