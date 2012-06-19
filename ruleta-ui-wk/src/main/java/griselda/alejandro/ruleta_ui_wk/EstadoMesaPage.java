package griselda.alejandro.ruleta_ui_wk;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import ruleta.Apuesta;
import ruleta.Mesa;


public class EstadoMesaPage extends WebPage{
	private WebPage paginaAnterior;
	private ListView listaApuestas;
	private Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	
	public EstadoMesaPage(WebPage paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
		this.generarGrillaApuestas();
	}

	
protected void generarGrillaApuestas(){
		
		listaApuestas = new ListView("apuestas", new PropertyModel(mesa, "apuestas")) {
	         protected void populateItem(final ListItem item) {
	    
	           Apuesta ap = (Apuesta) item.getModelObject();
	           String nombreJugador = ap.getJugadorNombre();
	           final Label jugador = new Label("jugador", new PropertyModel(item.getModelObject(), "jugadorNombre"));
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel(item.getModelObject(), "fichas"));
	           item.add(jugador);
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	         }
	     };
	     add(listaApuestas);
		
	}
}
