package griselda.alejandro.ruleta_ui_wicket;

import griselda.alejandro.ruleta_ui_wicket.extras.Styler;
import griselda.alejandro.ruleta_ui_wicket.models.HomeApplicationModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = -7622210569682682045L;

	public Label feedback1component;
	public Label feedback2component;
	public Form<HomeApplicationModel> formComponent;
	public HomeApplicationModel pageModel;
	
    public HomePage(final PageParameters parameters) {    	
    	this.pageModel = new HomeApplicationModel(this);    	    	
    	this.formComponent = new Form<HomeApplicationModel>("form_logw", new CompoundPropertyModel<HomeApplicationModel>(this.pageModel)){
			private static final long serialVersionUID = 4935057329504620881L;

			protected void onSubmit() {
				pageModel.adjuntarJugador();
			}
		};
		this.addFields(formComponent);
		this.add(formComponent);
    }

    public void addFields(Form<HomeApplicationModel> form) {    	    	
    	crearTexfield(form, "nombreloggin");
    	crearTexfield(form, "dinerologgin");    	
    	feedback1component = crearYAdjuntarFeedback("feedback1", form);
    	feedback2component = crearYAdjuntarFeedback("feedback2", form);
		//configurarLinkSubmit(form);
	}

	public void configurarLinkSubmit(Form<HomeApplicationModel> form) {
		//TODO utilizar link ajax impide el binding
		form.add(new AjaxLink<HomePage>("adjuntarJugador") {
			private static final long serialVersionUID = -4756682741456743787L;
			
			public void onClick(AjaxRequestTarget target) {
				pageModel.adjuntarJugador();
				target.add(feedback1component);
				target.add(feedback2component);
			}
		});
	}
	
	public Label crearYAdjuntarFeedback(String idLabel, Form<HomeApplicationModel> form){
		Label feedbackComponent = new Label(idLabel, new PropertyModel<String>(pageModel, idLabel));
		feedbackComponent.setOutputMarkupId(true); 
		form.add(feedbackComponent);
		return feedbackComponent;
	}
    
    public void crearTexfield(Form<HomeApplicationModel> form, String idTexfield){
    	TextField<String> campo = new TextField<String>(idTexfield, new PropertyModel<String>(pageModel, idTexfield));
		form.add(campo);
		campo.setOutputMarkupId(true);
    }
	
    public void setErrorFeedback(){
    	Styler.setErrorFeedback(feedback1component);
    }	
	
}
