package griselda.alejandro.ruleta_ui_wk;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import ruleta.Jugador;
import ruleta.Mesa;

public class ApuestasJugadorPage extends WebPage{
	private Jugador jugador;
	private Mesa mesa = RuletaWicketApplication.getRuletaApplication().getMesa();
	private ListView listaApuestas;
	private WebPage paginaAnterior;
	
	public ApuestasJugadorPage(Jugador j,WebPage page){
		jugador = j;
		paginaAnterior = page;
		 add (new Label ("mensaje", "Apuestas del jugador "));
		 add (new Label ("nombre", new PropertyModel (jugador, "nombre")));
		 this.generarGrillaApuestas();
		 this.agregarLink();
	}
	
	
private void generarGrillaApuestas(){
	  List list = jugador.getApuestas();
	     listaApuestas = new ListView("apuestas", list) {
	         protected void populateItem(final ListItem item) {
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel(item.getModelObject(), "fichas"));
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	         }
	     };
	     add(listaApuestas);
	     
	    
	     IndicatingAjaxFallbackLink link;

	 	link = new IndicatingAjaxFallbackLink("link") {
	 	    @Override
	 	    public void onClick(AjaxRequestTarget target) { 
	 	        listaApuestas.setList(jugador.getApuestas());
	 	        target.addChildren(listaApuestas, Label.class);
	 	        target.add(listaApuestas);
	 	    }
	 	};
	   
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

