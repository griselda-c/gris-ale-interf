package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import ruleta.Jugador;
import ruleta.Mesa;

public class HomePage extends WebPage {

	public String nombreloggin = "";
	public String dinerologgin = "";
	public Label feedback1;
	public Label feedback2;
	Form<WebPage> form;
	
    public HomePage(final PageParameters parameters) {
		form = new Form<WebPage>("form_logw", new CompoundPropertyModel<WebPage>(this)){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				Mesa mesa = WicketApplication.staticGetMesa();
				this.setResponsePage(new JugarPage(new RuletaWicketModel(mesa, new Jugador(1250, "Juan carlos"))));
			}
		};
		this.addFields(form);
		this.addActions(form);        
		this.add(form);
    }
    
	private void addActions(Form<WebPage> form) {
						
	}

	private void addFields(Form<WebPage> formP) {	
		TextField<String> nombre = new TextField<String>("nombreloggin");
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
