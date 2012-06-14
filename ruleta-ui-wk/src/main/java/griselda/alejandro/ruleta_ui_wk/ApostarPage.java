package griselda.alejandro.ruleta_ui_wk;

import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
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
	
	public ApostarPage(Jugador j,WebPage page){
	     jugador = j;
	     paginaAnterior = page;
	    Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm", new CompoundPropertyModel<ApuestaModel>(apuestaModelo));
	    this.add(apuestaForm);
		this.addFields(apuestaForm);
		this.addAction(apuestaForm);
		this.crearCombos(apuestaForm);
		this.agregarLink();		
	}
	
	

	private void addFields(Form<ApuestaModel> form) {		
		form.add(new TextField<String>("fichas"));
		form.add(new FeedbackPanel("feedbackPanel"));			
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
	
/*	
	protected ApuestaModel getApuestaModel() {
		return (ApuestaModel) this.getDefaultModelObject();
	}
	
	protected ApuestaWeb getApuestaSeleccionada(){
		return this.getApuestaModel().getApuestaSeleccionada();
		
	}
	
*/
	
}
