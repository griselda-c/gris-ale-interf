package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	public Label feedback1component;
	public Label feedback2component;
	public Form<HomeApplicationModel> formComponent;
	public HomeApplicationModel pageModel;
	
	
	
    public HomePage(final PageParameters parameters) {    	
    	this.pageModel = new HomeApplicationModel(this);    	    	
		formComponent = new Form<HomeApplicationModel>("form_logw", new CompoundPropertyModel<HomeApplicationModel>(this.pageModel)){
			@Override
			protected void onSubmit() {				
				pageModel.validarJugador();
			}			
		};		
		this.addFields(formComponent);      
		this.add(formComponent);
    }

    public void addFields(Form<HomeApplicationModel> formComponent2) {	
		formComponent2.add(new TextField<String>("nombreloggin"));
		formComponent2.add(new TextField<String>("dinerologgin"));		
		feedback1component = new Label("feedback1");
		feedback2component = new Label("feedback2");		
		formComponent2.add(feedback1component);
		formComponent2.add(feedback2component);		
	}
	
    public void setErrorFeedback(){
    	Styler.setErrorFeedback(feedback1component);
    }
	
	
}
