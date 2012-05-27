package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ruleta.Mesa;

public class AdjuntarJugadorPage extends WebPage{
	
	private static final long serialVersionUID = 1L;
	private Mesa mesa;
	private JugadorModel jugador = new JugadorModel();
	
	public AdjuntarJugadorPage(final PageParameters parameters) {
		this.mesa = new Mesa(1000);
		Form<JugadorModel> adjuntarForm = new Form<JugadorModel>("adjuntarJugadorForm", new CompoundPropertyModel<JugadorModel>(this.jugador));
		this.generarCamposIngreso(adjuntarForm);
		this.add(adjuntarForm);
		//this.generarAcciones(adjuntarForm);
		//this.generarGrillaResultados(adjuntarForm);
		//this.add(adjuntarForm);
		// Al abrir el formulario disparo la búsqueda
		//this.buscarCelulares();
		
		
		
	}//adnuntar jugador

	
	private void generarCamposIngreso(Form<JugadorModel> parent) {
		
		TextField<String>dinero = new TextField<String>("dinero");
		parent.add(dinero);
	    
		TextField<String> nombre = new TextField<String>("nombre");
		parent.add(nombre);
		
		
	    
	}//generarCampos
	
	private void addActions(Form form) {
		form.add(new Button("unirJugador") {
			@Override
			public void onSubmit() {
				jugador.createJugador();
			}
		});
	}
	protected CompoundPropertyModel<Mesa> createModel() {
		this.mesa= new Mesa(1000);
		return new CompoundPropertyModel<Mesa>(this.mesa);
	}
	
}//fin de la clase
