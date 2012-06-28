package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	
    public HomePage() {
		
    	add(new Label("ruleta","Bienvenido a la Ruleta del ocho"));
    	add(new Link<Object>("registrarse"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				irAAdjuntarJugadorPage();
			}
    	});
    	
    }
    
    
    protected void irAAdjuntarJugadorPage() {
		AdjuntarJugadorPage nextPage = new AdjuntarJugadorPage();
		this.setResponsePage(nextPage);
	}
}
