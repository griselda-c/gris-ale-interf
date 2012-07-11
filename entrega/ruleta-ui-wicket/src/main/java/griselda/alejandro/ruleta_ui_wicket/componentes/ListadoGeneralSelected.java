package griselda.alejandro.ruleta_ui_wicket.componentes;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import ruleta.apuestas.Apuesta;

import griselda.alejandro.ruleta_ui_wicket.models.JugarApplicationModel;

public class ListadoGeneralSelected  extends WebMarkupContainer{
	


	private static final long serialVersionUID = -588180288292565662L;
	protected JugarApplicationModel aplicationModel;
	protected ListView<Apuesta> listadoComponente;
	protected String idListado;
	protected String[] idsListadoArray;

	public ListadoGeneralSelected(String id, JugarApplicationModel aplicationModel, String[] idsListadoArray) {
		super(id+".container");
		this.idListado = id;
		this.idsListadoArray = idsListadoArray;
		this.aplicationModel = aplicationModel;
		this.agregarComponentes();
		this.setOutputMarkupId(true);
	}
	
	/*
	 * generalizacion de los listview 
	 * El wicket:id del container es el id + ".container"
	 * El wicket:id del listado es el id + ".listado"
	 */
	
	protected void agregarComponentes(){
		listadoComponente = new ListView<Apuesta>((idListado+".listado"), new PropertyModel<List<Apuesta>>(this.aplicationModel, idListado)) {
			private static final long serialVersionUID = -564745215807518014L;
			protected void populateItem(ListItem<Apuesta> item) {
				for (int i = 0; i < idsListadoArray.length; i++) {					
					item.add(new Label(idListado+"."+idsListadoArray[i], new PropertyModel<String>(item.getModel(), idsListadoArray[i])));
				}
				/*AjaxLink<JugarApplicationModel> nuevoLink;
				nuevoLink = new AjaxLink<JugarApplicationModel>(idListado+".link") {
					private static final long serialVersionUID = 4071652915841174209L;

					public void onClick(AjaxRequestTarget target) {
						aplicationModel.setApuestaSeleccionada((Apuesta)item.getModelObject());
					}
				};
				
				item.add(nuevoLink);*/
			}
		};
		
		listadoComponente.setOutputMarkupId(true);
		this.add(listadoComponente);
	}

}
