package griselda.alejandro.ruleta_ui_wk;
import java.util.List;

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
import ruleta.RuletaApplication;


public class EstadoMesaPage extends WebPage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebPage paginaAnterior;
	private ListView<Apuesta> listaApuestas;
	private ListView<Apuesta> listaApuestasAnteriores;
    private WebMarkupContainer listContainer;
	private Jugador jugador;
	
	public EstadoMesaPage(WebPage paginaAnterior,Jugador j) {
		this.jugador = j;
		this.paginaAnterior = paginaAnterior;
		this.generarGrillaApuestas();
		//this.generarGrillaApuestasAnteriores();
		this.agregarLink();
	}


	protected RuletaApplication getRuletaApplication(){
		return  RuletaWicketApplication.getRuletaWicketApplication().getRuletaApplication();
	}

protected void generarGrillaApuestas(){
		
	    Mesa mesa = getRuletaApplication().getMesa(jugador);
		listaApuestas = new ListView<Apuesta>("apuestas",new PropertyModel(mesa, "apuestas")) {
	         /**
			 * 
			 */
		
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem<Apuesta>item) {
	           Jugador j = item.getModelObject().jugador;
	           String nombre  = j.getNombre();
	           final Label jugador = new Label("jugador",nombre);
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

/*
protected void generarGrillaApuestasAnteriores(){
	
	listaApuestasAnteriores = new ListView<Apuesta>("apuestasA", new PropertyModel(getMesa(), "apuestasAnteriores")) {
        
		private static final long serialVersionUID = 1L;

		protected void populateItem(final ListItem<Apuesta>item) {
    
		
           
           final Label jugador = new Label("jugadorA", new PropertyModel<Apuesta>(item.getModelObject(), "jugadorNombre"));
           final Label tipoApuesta = new Label("tipoApuestaA", new PropertyModel<Apuesta>(item.getModel(), "tipoApuesta"));
           final Label opcionJugada = new Label("opcionA",new PropertyModel<Apuesta>(item.getModelObject(), "opcionNombre"));
           final Label fichas = new Label("fichasA",new PropertyModel<Apuesta>(item.getModelObject(), "fichas"));
           item.add(jugador);
           item.add(tipoApuesta);
           item.add(opcionJugada);
           item.add(fichas);
         }
     };
     add(listaApuestasAnteriores);

}
*/

 public void agregarLink(){
	 add(new Link<Object>("volver"){

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void onClick() {
			setResponsePage(paginaAnterior);
			
		}
		 
	 });
	 
	 
	 
	 
 }
 
 
}
