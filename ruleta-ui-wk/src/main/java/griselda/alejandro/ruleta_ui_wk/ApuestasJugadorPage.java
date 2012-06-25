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
import ruleta.Jugador;
import ruleta.Mesa;

public class ApuestasJugadorPage extends WebPage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Jugador jugador;
	private Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	private ListView<Apuesta> listaApuestas;
	private WebPage paginaAnterior;
	private WebMarkupContainer listContainer;
	
	public ApuestasJugadorPage(Jugador j,WebPage page){
		jugador = j;
		paginaAnterior = page;
		 add (new Label ("mensaje", "Apuestas del jugador "));
		 add (new Label ("nombre", new PropertyModel<String> (jugador, "nombre")));
		 this.generarGrillaApuestas();
		 this.agregarLink();
	}
	
	
@SuppressWarnings("unchecked")
private void generarGrillaApuestas(){
	 
	     listaApuestas = new ListView("apuestas", new PropertyModel<Apuesta>(jugador, "apuestas")) {
	         protected void populateItem(final ListItem item) {
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel<String>(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel<String>(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel<String>(item.getModelObject(), "fichas"));
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	         }
	     };
	     add(listaApuestas);
	     /*
	     listaApuestas.setOutputMarkupId(true);
	     listContainer = new WebMarkupContainer("theContainer");
	     listContainer.setOutputMarkupId(true);
	     listContainer.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
	     listContainer.add(listaApuestas);
	     add(listContainer);
	     */
	}

private void volverPaginaAnterior(){
	this.setResponsePage(paginaAnterior);
	
}


private void agregarLink(){
	add(new Link("volver"){

		@Override
		public void onClick() {
			volverPaginaAnterior();
			
		}
		
	});
	
}
	
}

