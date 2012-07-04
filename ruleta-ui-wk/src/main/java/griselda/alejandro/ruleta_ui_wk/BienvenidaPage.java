package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.RuletaApplication;


public class BienvenidaPage extends WebPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListView<Jugador> view;
	private WebMarkupContainer listContainer;
	
	
	private Jugador jugador;
	
	public BienvenidaPage(Jugador j){
		jugador = j;
		add(new Label ("mensaje","Bienvenido "));
		add(new Label ("nombre",new PropertyModel<Jugador>(jugador,"nombre")));
		add(new Label ("fichas"," usted tiene "));
		add(new Label ("cantFichas",new PropertyModel<Jugador>(jugador, "fichas")));
		add(new Label ("finFrase"," fichas "));
		this.agregarLink();
		this.generarGrillaJugadores();
		
	}
	
	protected RuletaApplication getRuletaApplication(){
		return  RuletaWicketApplication.getRuletaWicketApplication().getRuletaApplication();
	}
	
protected void generarGrillaJugadores(){
	      
	    Mesa mesa =  getRuletaApplication().getMesa(jugador);
	
		view = new ListView<Jugador>("jugadores",new PropertyModel(mesa, "jugadores")) {
		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem<Jugador> item) {
	           final Label nombreJugador = new Label("label", new PropertyModel<String>(item.getModel(), "nombre"));
	           item.add(nombreJugador);
	           item.add(new Link<Object>("verApuestas"){
	        	   /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void onClick() {
	        		   
	        		   Jugador j = (Jugador) item.getModelObject();
	        		   BienvenidaPage.this.mostrarApuestas(j);
	        	   };
	        	   
	           });
	         }
	     };
	     view.setOutputMarkupId(true); 
	     add(view);
	    
	     listContainer = new WebMarkupContainer("theContainer");
	     listContainer.setOutputMarkupId(true);
	     listContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
	     listContainer.add(view);
	     add(listContainer);
		
	}
	

protected void mostrarApuestas(Jugador j){
	
	ApuestasJugadorPage apuestasJugador = new ApuestasJugadorPage(j,getPaginaActual());
	this.setResponsePage(apuestasJugador);
}

 protected BienvenidaPage getPaginaActual(){
	return this;
}
 
 protected void agregarLink(){
		
		add(new Link<Object>("verEstadoMesa"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				mostrarEstadoMesa();
				
			}
			
		});
		
		add(new Link<Object>("linkApuesta")
	     {
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onClick()
	         {
	        	ApostarPage nextPage = new ApostarPage(jugador,getPaginaActual());
	     		this.setResponsePage(nextPage);
				
	         }
	     });
		
	}


	protected void mostrarEstadoMesa(){
		EstadoMesaPage estadoMesa = new EstadoMesaPage(getPaginaActual(),jugador);
		this.setResponsePage(estadoMesa);
	}
		
	

}
