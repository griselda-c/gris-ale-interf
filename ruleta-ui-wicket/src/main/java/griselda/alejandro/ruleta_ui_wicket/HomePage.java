package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;

public class HomePage extends WebPage {

	public String nombreloggin = "";
	public String dinerologgin = "";
	public Label feedback1;
	public Label feedback2;
	Form<WebPage> form;
	
    public HomePage(final PageParameters parameters) {
		form = new Form<WebPage>("form_logw", new CompoundPropertyModel<WebPage>(this)){
			@Override
			protected void onSubmit() {
				this.setResponsePage(new JugarPage());
			}
		};
		this.addFields(form);
		this.addActions(form);        
		this.add(form);
    }
    
	private void addActions(Form<WebPage> form) {
		form.add(new IFormValidator() {
			
			public void validate(Form<?> arg0) {
				arg0.error("sdfgsdfg");
			}
			
			public FormComponent<?>[] getDependentFormComponents() {
				return null;
			}
		});
				
	}

	private void addFields(Form<WebPage> formP) {	
		TextField<String> nombre = new TextField<String>("nombreloggin");
		nombre.add(new IValidator<String>() {			
			public void validate(IValidatable<String> validatable) {
				System.out.println("nada");
			    form.error("");
			}
		});
		formP.add(nombre);
		formP.add(new TextField<String>("dinerologgin"));
		feedback1 = new Label("feedback1", "Ingrese sus datos");
		formP.add(feedback1);
		feedback2 = new Label("feedback2", "para iniciar sesion.");
		formP.add(feedback2);
		
	}
	
	public String getNombreloggin() {
		return nombreloggin;
	}

	public void setNombreloggin(String nombreLoggin) {
		this.nombreloggin = nombreLoggin;
	}

	public String getDinerologgin() {
		return dinerologgin;
	}

	public void setDinerologgin(String dineroLoggin) {
		this.dinerologgin = dineroLoggin;
	}

}
