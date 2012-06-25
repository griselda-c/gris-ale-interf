package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	//final PageParameters parameters
    public HomePage() {
		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        // TODO Add your page's components here
    	add(new Label("ruleta","Bienvenido a la Ruleta del ocho"));
    	add(new Link("registrarse"){
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				irAAdjuntarJugadorPage();
			}
    	});
    	
    }
    
    
    protected void irAAdjuntarJugadorPage() {
		AdjuntarJugadorPage nextPage = new AdjuntarJugadorPage();
		this.setResponsePage(nextPage);
	}
}
