package griselda.alejandro.ruleta_ui_wk;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import ruleta.Apuesta;
import ruleta.Mesa;


public class EstadoMesaPage extends WebPage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebPage paginaAnterior;
	private ListView<Apuesta> listaApuestas;
	private Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	private WebMarkupContainer listContainer;
	
	public EstadoMesaPage(WebPage paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
		this.generarGrillaApuestas();
		this.agregarLink();
	}


protected void generarGrillaApuestas(){
		
		listaApuestas = new ListView<Apuesta>("apuestas", new PropertyModel(mesa, "apuestas")) {
	         /**
			 * 
			 */
		
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem item) {
	    
			
	           Apuesta ap = (Apuesta) item.getModelObject();
	           String nombreJugador = ap.getJugadorNombre();
	           final Label jugador = new Label("jugador", new PropertyModel<Apuesta>(item.getModelObject(), "jugadorNombre"));
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel<Apuesta>(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel<Apuesta>(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel<Apuesta>(item.getModelObject(), "fichas"));
	           item.add(jugador);
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	         }
	     };
	     add(listaApuestas);
	     
	     listaApuestas.setOutputMarkupId(true);
	     listContainer = new WebMarkupContainer("theContainer");
	     listContainer.setOutputMarkupId(true);
	     listContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
	     listContainer.add(listaApuestas);
	     add(listContainer);
		
	}

 public void agregarLink(){
	 add(new Link("volver"){

		@Override
		public void onClick() {
			setResponsePage(paginaAnterior);
			
		}
		 
	 });
 }
}
