package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private RuletaWicketModel model;
	
    public HomePage(final PageParameters parameters) {
    	Form form = new Form("form_logw", new CompoundPropertyModel<RuletaWicketModel>(this.model)){
    		@Override
    		protected void onSubmit() {
    			this.setResponsePage(new JugarPage());
    		}
    	};
		this.add(form);
		this.addFields(form);
		this.addActions(form);        
    }
    
	private void addActions(Form form) {
		
	}

	private void addFields(Form form) {	
		form.add(new TextField("nombreJugadorw"));
		form.add(new TextField("dineroJugadorw"));
	}
}
