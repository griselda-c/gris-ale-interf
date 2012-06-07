package griselda.alejandro.ruleta_ui_wk;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Jugador;
import ruleta.Mesa;


public class BienvenidaPage extends WebPage{
	private WebPage paginaAnterior;
	private FeedbackPanel feedbackPanel;
	private Button linkApostar;
	private Jugador jugador;
	private ListView view;
	private Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	
	public BienvenidaPage(Jugador j,AdjuntarJugadorPage mainPage){
	     paginaAnterior = mainPage;	
	     jugador = j;
	     add (new Label ("mensaje", "Bienvenido"));
	     add (new Label ("nombre", new PropertyModel (jugador, "nombre")));
	     add (new Label ("cantFichas", "Usted tiene "));
	     add (new Label ("fichas", new PropertyModel (jugador, "fichas")));
	     add (new Label ("finFrase", "fichas"));
	     add(new Link("linkApuesta")
	     {
	         public void onClick()
	         {
	        	 ApostarPage nextPage = (new ApostarPage(jugador));
	     		this.setResponsePage(nextPage);
	         }
	     });
	  
	     List list = mesa.getJugadores();
	     view = new ListView("jugadores", list) {
	         protected void populateItem(ListItem item) {
	             item.add(new Label("label", new PropertyModel(item.getModel(), "nombre")));
	         }
	     };
	     add(view);
	     
	    
	     IndicatingAjaxFallbackLink link;

	 	link = new IndicatingAjaxFallbackLink("link") {
	 	    @Override
	 	    public void onClick(AjaxRequestTarget target) { 
	 	        view.setList(mesa.getJugadores());
	 	        target.addChildren(view, Label.class);
	 	        target.add(view);
	 	    }
	 	};
	   
	}
	
	
public void crearTablaJugadores(){
	final Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	final List lista = mesa.getJugadores();
	
	   view = new ListView("jugadores", lista) {
	    @Override
	    protected void populateItem(ListItem item) {
	        Label label = new Label("label", new PropertyModel(item.getModel(), "nombre"));
	        label.setOutputMarkupId(true);
	        item.add(label);
	    }
	};

	IndicatingAjaxFallbackLink link;

	link = new IndicatingAjaxFallbackLink("link") {
	    @Override
	    public void onClick(AjaxRequestTarget target) { 
	        view.setList(mesa.getJugadores());
	        target.addChildren(view, Label.class);
	    }
	};
	
}

	
}
