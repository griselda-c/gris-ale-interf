package griselda.alejandro.ruleta_ui_wicket;


import griselda.alejandro.ruleta_ui_wicket.RuletaWicketModel.ApuestaWeb;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Jugador;
import ruleta.OpcionJugada;



public class JugarPage extends WebPage {

	public RuletaWicketModel model;
	public Form<RuletaWicketModel> form;
	public DropDownChoice<ApuestaWeb> selectApuestaTipoComponente;
	public DropDownChoice<OpcionJugada> selectJugadaComponente;
	public TextField<Integer>  fichasApostadasComponente;
	public AjaxButton apostarComponent;
	public Label fichasJugadorComponente;

	public Integer  fichasApostadas;
	public ApuestaWeb apuestaSeleccionada;
	public OpcionJugada juagadaSeleccionada;
	
	
	
	public JugarPage(RuletaWicketModel model){
		super();
		this.model = model;		
		
		form = new Form<RuletaWicketModel>("form_apuesta", new CompoundPropertyModel<RuletaWicketModel>(this.model));
		this.addFields(form);      
		this.add(form);
		
	}


	public void addFields(Form<RuletaWicketModel> form) {
		
		
		fichasApostadasComponente = new TextField<Integer>("fichasApostadas", new PropertyModel<Integer>(this, "fichasApostadas"));
		fichasApostadasComponente.setOutputMarkupId(true);
		form.add(fichasApostadasComponente);
		
		fichasJugadorComponente = new Label("fichasJugador", new PropertyModel<Integer>(this.getJugador() , "fichas"));
		fichasJugadorComponente.setOutputMarkupId(true);
		form.add(fichasJugadorComponente);
		
		apostarComponent = new AjaxButton("apostar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				apuestaSeleccionada = null;
				juagadaSeleccionada = null;
				fichasApostadas = 0;
				selectJugadaComponente.setEnabled(false);
				apostarComponent.setEnabled(false);
				target.addComponent(fichasApostadasComponente);
				target.addComponent(selectJugadaComponente);
				target.addComponent(selectApuestaTipoComponente);
				target.addComponent(apostarComponent);
			}
		};
		
		apostarComponent.setEnabled(false);
		form.add(apostarComponent);
		
		selectApuestaTipoComponente = new DropDownChoice<ApuestaWeb>("selectApuesta",new PropertyModel<ApuestaWeb>(this, "apuestaSeleccionada"), RuletaWicketModel.staticApuestas, new ChoiceRenderer<ApuestaWeb>("tipoApuesta"));
		selectApuestaTipoComponente.setOutputMarkupId(true);
	    form.add(selectApuestaTipoComponente);
	    
	    selectApuestaTipoComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
	    	protected void onUpdate(AjaxRequestTarget target) {
	    	    selectJugadaComponente.setEnabled(true);
	    		target.addComponent(selectJugadaComponente);
	    	}
	    });
	    
	    selectJugadaComponente = new DropDownChoice<OpcionJugada>("selectJugada",new PropertyModel<OpcionJugada>(this, "juagadaSeleccionada"), new PropertyModel<List<OpcionJugada>>(this, "opciones"), new ChoiceRenderer<OpcionJugada>("nombre"));
	    selectJugadaComponente.setOutputMarkupId(true);
	    selectJugadaComponente.setEnabled(false);
	    form.add(selectJugadaComponente);
	    
	    selectJugadaComponente.add(new AjaxFormComponentUpdatingBehavior("onchange") {
	    	protected void onUpdate(AjaxRequestTarget target) {
	    		apostarComponent.setEnabled(true);
	    		target.addComponent(apostarComponent);
	    	}
	    });    
		
	}
	
	private Jugador getJugador() {
		return this.model.jugador;
	}


	public List<OpcionJugada> getOpciones() {
		if(apuestaSeleccionada != null){
		    return apuestaSeleccionada.getOpciones();
		}
		else{
			return Collections.emptyList();			
		}
	}	
	

	public DropDownChoice<ApuestaWeb> getSelectApuestaTipo() {
		return selectApuestaTipoComponente;
	}

	public void setSelectApuestaTipo(DropDownChoice<ApuestaWeb> selectApuestaTipo) {
		this.selectApuestaTipoComponente = selectApuestaTipo;
	}

	public DropDownChoice<OpcionJugada> getSelectJugada() {
		return selectJugadaComponente;
	}

	public void setSelectJugada(DropDownChoice<OpcionJugada> selectJugada) {
		this.selectJugadaComponente = selectJugada;
	}

	public ApuestaWeb getApuestaSeleccionada() {
		return apuestaSeleccionada;
	}

	public void setApuestaSeleccionada(ApuestaWeb apuestaSeleccionada) {
		this.apuestaSeleccionada = apuestaSeleccionada;
	}

	public OpcionJugada getJuagadaSeleccionada() {
		return juagadaSeleccionada;
	}

	public void setJuagadaSeleccionada(OpcionJugada juagadaSeleccionada) {
		this.juagadaSeleccionada = juagadaSeleccionada;
	}


	public Integer getFichasApostadas() {
		return fichasApostadas;
	}


	public void setFichasApostadas(Integer fichasApostadas) {
		this.fichasApostadas = fichasApostadas;
	}	

}
