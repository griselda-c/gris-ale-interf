package griselda.alejandro.ruleta_ui_wicket.componentes;

import java.util.List;

import griselda.alejandro.ruleta_ui_wicket.models.JugarApplicationModel;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;


public class ListadoGeneral<T> extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;
	private JugarApplicationModel aplicationModel;
	private ListView<T> jugadoresComponente;
	private String idListado;
	private String[] idsListadoArray;

	/*
	 * generalizacion de los listview 
	 * El wicket:id del container es el id + ".container"
	 * El wicket:id del listado es el id + ".listado"
	 */
	
	public ListadoGeneral(String id, JugarApplicationModel aplicationModel, String[] idsListadoArray) {
		super(id+".container");
		this.idListado = id;
		this.idsListadoArray = idsListadoArray;
		this.aplicationModel = aplicationModel;
		this.agregarComponentes();
		this.setOutputMarkupId(true);
	}

	private void agregarComponentes(){
		jugadoresComponente = new ListView<T>((idListado+".listado"), new PropertyModel<List<T>>(this.aplicationModel, idListado)) {
			private static final long serialVersionUID = -564745215807518014L;
			protected void populateItem(ListItem<T> item) {
				for (int i = 0; i < idsListadoArray.length; i++) {					
					item.add(new Label(idListado+"."+idsListadoArray[i], new PropertyModel<String>(item.getModel(), idsListadoArray[i])));
				}
			}
		};
		jugadoresComponente.setOutputMarkupId(true);
		this.add(jugadoresComponente);
	}
	
	//item.add(new Label("jugadoresPartidaActual.nombre", new PropertyModel<String>(item.getModel(), "nombre")));
	//item.add(new Label("jugadoresPartidaActual.fichas", new PropertyModel<String>(item.getModel(), "fichas")));
	//item.add(new Label("jugadoresPartidaActual.cantidadapuestas", new PropertyModel<String>(item.getModel(), "cantidadApuestas")));
}
