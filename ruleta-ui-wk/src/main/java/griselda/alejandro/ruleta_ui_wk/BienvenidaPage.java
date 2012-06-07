package griselda.alejandro.ruleta_ui_wk;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Jugador;


public class BienvenidaPage extends WebPage{
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	private Button linkApostar;
	private Jugador jugador;
	
	public BienvenidaPage(Jugador j,AdjuntarJugadorPage mainPage){
	     paginaAnterior = mainPage;	
	     jugador = j;
	     add (new Label ("mensaje", "Bienvenido"));
	     add (new Label ("nombre", new PropertyModel (jugador, "nombre")));
	     add (new Label ("cantFichas", "Usted tiene "));
	     add (new Label ("fichas", new PropertyModel (jugador, "fichas")));
	     add (new Label ("finFrase", "fichas"));
	    	 
	}
	
	public void agregarBoton(Form<Jugador> parent){
		
		parent.add( new Button("linkApostar")	{
		@Override
		public void onSubmit() {
			this.ir
		}
	});
	
	}
	
	
	
	private void irAApostarPage(Jugador jugador) {
		
		ApostarPage nextPage = (new ApostarPage(jugador));
		this.setResponsePage(nextPage);
		
	}

	
}
