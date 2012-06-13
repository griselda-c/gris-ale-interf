package griselda.alejandro.ruleta_ui_wicket;


import griselda.alejandro.ruleta_ui_wicket.RuletaWicketModel.ApuestaWeb;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.OpcionJugada;



public class JugarPage extends WebPage {

	public RuletaWicketModel model;
	public Form<RuletaWicketModel> form;
	public DropDownChoice selectApuestaTipo;
	public DropDownChoice selectJugada;
	public ApuestaWeb apuestaSeleccionada;
	public OpcionJugada juagadaSeleccionada;
	
	
	public JugarPage(RuletaWicketModel model){
		super();
		this.model = model;		
		
		form = new Form<RuletaWicketModel>("form_apuesta", new CompoundPropertyModel<RuletaWicketModel>(this.model));
		this.addFields(form);
		this.addActions(form);        
		this.add(form);
		

		Label fichas = new Label("fichas", new PropertyModel<String>(model.jugador, "fichas"));
		add(fichas);
	}

	public void addActions(Form<RuletaWicketModel> form) {
		
	}

	public void addFields(Form<RuletaWicketModel> form) {
		
		
		
		selectApuestaTipo = new DropDownChoice("selectApuesta",new PropertyModel(this, "apuestaSeleccionada"), RuletaWicketModel.staticApuestas, new ChoiceRenderer<ApuestaWeb>("tipoApuesta"));
	    selectApuestaTipo.setOutputMarkupId(true);
	    form.add(selectApuestaTipo);
	    
	    /*selectApuestaTipo.add(new AjaxFormComponentUpdatingBehavior("onchange") {
	    	protected void onUpdate(AjaxRequestTarget target) {
	    		target.add(selectJugada);
	    	}
	    });*/
	    
	    selectJugada = new DropDownChoice("selectJugada",new PropertyModel(this, "juagadaSeleccionada"), this.apuestaSeleccionada.apuesta.getOpciones(), new ChoiceRenderer<OpcionJugada>("nombre"));
	    selectJugada.setOutputMarkupId(true);
	    form.add(selectJugada);
	   
	    form.add(new AjaxButton("apostar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
								
			}
		});
		
	}
	
	public void apostarActual(){
		
	}
	

}
