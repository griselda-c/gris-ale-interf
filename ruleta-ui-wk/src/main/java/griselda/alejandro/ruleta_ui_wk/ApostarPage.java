package griselda.alejandro.ruleta_ui_wk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.OpcionJugada;

public class ApostarPage extends WebPage{

	private static final long serialVersionUID = 1L;

	private DropDownChoice comboApuesta;
	private DropDownChoice comboJugada;
	private Jugador jugador;
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	
	public ApostarPage(Jugador j){
	     jugador = j;
	    Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm",this.createModel());
	    this.add(apuestaForm);
		this.addFields(apuestaForm);
		this.addAction(apuestaForm);
		this.crearCombos(apuestaForm);
		
		
		
	}
	
	private void addFields(Form<ApuestaModel> form) {
		
		form.add(new TextField<String>("fichas"));
		form.add(new FeedbackPanel("feedbackPanel"));		
		
	}
	
	
	
	private void crearCombos(Form<ApuestaModel> form){
		
	    comboApuesta = new DropDownChoice("apuestaSeleccionada",new PropertyModel(this.getApuestaModel(), "apuestaSeleccionada"),this.getApuestaModel().opciones);
	    comboApuesta.setOutputMarkupId(true);
	    form.add(comboApuesta);
	    comboJugada =new DropDownChoice("opcionJugada",new PropertyModel(this.getApuestaModel(),"opcionesJugada"),this.getApuestaSeleccionada().getOpciones());
	    comboJugada.setOutputMarkupId(true);
	    form.add(comboJugada);
	   
	    comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(comboJugada);
            }
        });
		
		
		
	}

	
/*
	 private void getComboTipoApuesta( Form<ApuestaModel>form) {
	        DropDownChoice comboApuesta = new DropDownChoice("apuestaSeleccionada",this.getApuestaModel().staticApuestas);
	        comboApuesta.setOutputMarkupId(true);
	        form.add(comboApuesta);
	        // Add Ajax Behaviour...
	        comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
	            protected void onUpdate(AjaxRequestTarget target) {
	                target.add(comboJugada);
	            }
	        });
	    }
	 
	 
	 private DropDownChoice getJugadas(Form<ApuestaModel> form) {
	        List list = Collections.EMPTY_LIST;
	        if (this.getApuestaSeleccionada() != null) {
	   	        	list = this.getApuestaSeleccionada().getOpciones();
	        }
	        DropDownChoice comboJugada = new DropDownChoice("opcionJugada",list);
	        comboJugada.setOutputMarkupId(true);  // Needed for Ajax to update it
	        form.add(comboJugada);
	        return comboJugada;
	    }
	
*/
	private void addAction(Form<ApuestaModel> form){
	form.add(new Button("apostar") {
		@Override
		public void onSubmit() {
			try{  
				/*
				ApuestaModel apuesta = getApuestaModel();
				apuesta.setJugador(jugador);
				apuesta.crearApuesta();
				*/
			}//try
			catch (RuntimeException e)
			{ApostarPage.this.feedbackPanel.error(e.getMessage());};
			
			
			
			
		}// onSubmit
	});
	
	
}
	
	
	
	protected ApuestaModel getApuestaModel() {
		return (ApuestaModel) this.getDefaultModelObject();
	}
	
	protected Apuesta getApuestaSeleccionada(){
		return this.getApuestaModel().getApuestaSeleccionada();
		
	}
	
protected CompoundPropertyModel<ApuestaModel> createModel() {
		
		return new CompoundPropertyModel<ApuestaModel>(new ApuestaModel());
	}
	
}
