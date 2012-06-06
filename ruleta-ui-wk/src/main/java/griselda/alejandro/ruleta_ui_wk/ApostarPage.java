package griselda.alejandro.ruleta_ui_wk;

import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;


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

	private DropDownChoice _comboApuesta, _comboJugada;
	private Jugador jugador;
	private WebPage paginaAnterior;
	public ApuestaModel apuestaM;
	private FeedbackPanel feedbackPanel;
	private String fichasApuesta;
	private String apuestaNombre;
	private String jugadaNombre;
	private String jugadorNombre;
	private Apuesta apuesta;
	private List<OpcionJugada>opciones = new LinkedList<OpcionJugada>();
	
	public ApostarPage(Jugador j,AdjuntarJugadorPage mainPage){
	     paginaAnterior = mainPage;	
	     jugador = j;
	     jugadorNombre = jugador.getNombre();
	     this.apuestaM = new ApuestaModel();
	    Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm",this.createModel());
	    _comboApuesta = this.getComboTipoApuesta(apuestaForm);
	    _comboJugada = this.getJugadas(apuestaForm);
	    this.add(apuestaForm);
		this.addFields(apuestaForm);
		this.getJugadas(apuestaForm);
		this.getComboTipoApuesta(apuestaForm);
		this.addAction(apuestaForm);
		
	}
	
	private void addFields(Form<ApuestaModel> form) {
		
		form.add(new TextField<String>("fichas",new PropertyModel<String>(this, "fichasApuesta")));
		form.add(new FeedbackPanel("feedbackPanel"));		
		/*
		ChoiceRenderer choiceRender = new ChoiceRenderer("tipo");
		form.add(new DropDownChoice<ApuestaWeb>("tipoApuesta", new PropertyModel(this, "apuestaNombre"),apuestaM.staticApuestas,choiceRender));
		System.out.println("se aposto" +apuestaNombre);
	
		ChoiceRenderer choiceJugada = new ChoiceRenderer("nombre");
		form.add(new DropDownChoice<OpcionJugada>("jugada", new PropertyModel(this, "jugadaNombre"),opciones,choiceJugada));
		*/
		
		
		
	}
	
	
	

	 private DropDownChoice getComboTipoApuesta( Form<ApuestaModel>form) {
	        DropDownChoice comboApuesta = new DropDownChoice("tipoApuesta",new PropertyModel(this, "apuestaNombre") ,apuestaM.staticApuestas);
	       form.add(comboApuesta);
	        // Add Ajax Behaviour...
	        comboApuesta.add(new AjaxFormComponentUpdatingBehavior("onchange") {
	            protected void onUpdate(AjaxRequestTarget target) {
	                // Reset the phone model dropdown when the vendor changes
	            	//comboJugada.setChoices(apuestaM.getApuesta(apuestaNombre).getOpciones());
	                target.focusComponent(_comboJugada);
	            }
	        });
	        return comboApuesta;
	    }
	 
	 
	 private DropDownChoice getJugadas(Form<ApuestaModel> form) {
	        List list = Collections.EMPTY_LIST;
	        if (apuestaNombre != null) {
	            apuesta = apuestaM.getApuesta(apuestaNombre);
	        	list = apuesta.getOpciones();
	        }
	        DropDownChoice comboJugada = new DropDownChoice("jugada",new PropertyModel(this, "jugadaNombre"), list);
	        comboJugada.setOutputMarkupId(true);  // Needed for Ajax to update it
	        return comboJugada;
	    }
	
	
	private void addAction(Form<ApuestaModel> form){
	form.add(new Button("apostar") {
		@Override
		public void onSubmit() {
			try{  /*
				  apuesta = apuestaM.getApuesta(apuestaNombre);
				  apuesta.setJugador(jugador);
				  apuesta.setFichas(Integer.parseInt(fichasApuesta));
				  if(opciones.isEmpty()){
					  opciones = apuesta.getOpciones();
					  
				  }
			*/
			}//try
			catch (RuntimeException e)
			{ApostarPage.this.feedbackPanel.error(e.getMessage());};
			
			
			
			
		}// onSubmit
	});
	
	
}
	
	
protected CompoundPropertyModel<ApuestaModel> createModel() {
		
		return new CompoundPropertyModel<ApuestaModel>(this.apuestaM);
	}
	
}
