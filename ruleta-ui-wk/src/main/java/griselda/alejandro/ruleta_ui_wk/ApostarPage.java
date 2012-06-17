package griselda.alejandro.ruleta_ui_wk;

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
import ruleta.Jugador;


public class ApostarPage extends WebPage{

	private static final long serialVersionUID = 1L;

	private DropDownChoice comboApuesta;
	private DropDownChoice comboJugada;
	private Jugador jugador;
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	private ApuestaModel apuestaModelo = new ApuestaModel();
	private ListView listaApuestas;
	
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
	}
	
	

	private void addFields(Form<ApuestaModel> form) {		
		form.add(new TextField<String>("fichas"));
		form.add(new FeedbackPanel("feedbackPanel"));			
	}
	
	private void agregarLabelFichasJugador(){
		Label labelFrase = new Label("nombreJugador",jugador.nombre +" tiene disponible ");
		Label labelFichasDisponibles = new Label("fichasJugador",new PropertyModel (jugador, "fichas"));
		add(labelFrase);
		add(labelFichasDisponibles);
	}
	
	private void crearCombos(Form<ApuestaModel> form){
		
	    comboApuesta = new DropDownChoice("apuestaSeleccionada",new PropertyModel(apuestaModelo, "apuestaSeleccionada"),apuestaModelo.staticApuestas,new ChoiceRenderer("tipoApuesta"));
	    comboApuesta.setOutputMarkupId(true);
	    form.add(comboApuesta);
	  
	    comboJugada =new DropDownChoice("opcionJugada",new PropertyModel(apuestaModelo,"opcionJugada"),new PropertyModel(apuestaModelo,"opciones"),new ChoiceRenderer("nombre"));
	    comboJugada.setOutputMarkupId(true);
	    comboJugada.setEnabled(false);
	    form.add(comboJugada);
	   
	    comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
            protected void onUpdate(AjaxRequestTarget target) {
            	comboJugada.setEnabled(true);
                target.add(comboJugada);
            }
        });
		
		
		
	}

	
	private void addAction(Form<ApuestaModel> form){
	form.add(new Button("apostar") {
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
		
		listaApuestas = new ListView("apuestas", new PropertyModel(jugador, "apuestas")) {
	         protected void populateItem(final ListItem item) {
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel(item.getModelObject(), "fichas"));
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
		add(new Link("volver"){

			@Override
			public void onClick() {
				volverPaginaAnterior();
				
			}
			
		});
		
	}
	

	
}
