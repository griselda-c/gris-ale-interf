package griselda.alejandro.ruleta_ui_wk;
import griselda.alejandro.ruleta_ui_wk.BienvenidaPage;
import griselda.alejandro.ruleta_ui_wk.RuletaWicketApplication;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.RuletaApplication;


public class ResultadosPage extends WebPage{
	private Jugador jugador;
	private Mesa mesa;
	private ListView<Apuesta> listaApuestas;
	public ResultadosPage(Jugador j){
		jugador = j;
	    mesa = getRuletaApplication().getMesa(jugador);
		add(new Label ("numeroGanador",new PropertyModel<Mesa>(mesa,"numeroGanador")));
		add(new Label ("cantFichas",new PropertyModel<Jugador>(jugador, "fichas")));
		Form<Mesa> ruletaForm = new Form<Mesa>("ruletaForm", new CompoundPropertyModel<Mesa>(getRuletaApplication().getMesa(jugador)));
		add(ruletaForm);
		this.generarGrillaApuestas();
		this.agregarBotones(ruletaForm);
		
	}
	
	private void agregarBotones(Form<Mesa> ruletaForm) {
		ruletaForm.add(new Button("seguirJugando"){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit() {
				getRuletaApplication().cambiarMesa(jugador);
				irAPaginaBienvenida();
			}
			
		});
		
		ruletaForm.add(new Button("retirarse"){
			@Override
			public void onSubmit() {
				// TODO Auto-generated method stub
				this.setResponsePage(new RetirarsePage(jugador));
			}
		});
		
	}

	protected RuletaApplication getRuletaApplication(){
		return  RuletaWicketApplication.getRuletaWicketApplication().getRuletaApplication();
	}
	
	public void irAPaginaBienvenida(){
		
		BienvenidaPage bienvenida = new BienvenidaPage(jugador);
		this.setResponsePage(bienvenida);
		
	}
	
	
private void generarGrillaApuestas(){
		
		listaApuestas = new ListView<Apuesta>("apuestas",new PropertyModel(jugador, "apuestas")) {
	      
			private static final long serialVersionUID = 1L;

			protected void populateItem(final ListItem item) {
	           final Label tipoApuesta = new Label("tipoApuesta", new PropertyModel<String>(item.getModel(), "tipoApuesta"));
	           final Label opcionJugada = new Label("opcion",new PropertyModel<String>(item.getModelObject(), "opcionNombre"));
	           final Label fichas = new Label("fichas",new PropertyModel<String>(item.getModelObject(), "fichas"));
	           final Label fichasG = new Label("fichasGanadas",new PropertyModel<String>(item.getModelObject(), "fichasGanadas"));
	           item.add(tipoApuesta);
	           item.add(opcionJugada);
	           item.add(fichas);
	           item.add(fichasG);
	         }
	     };
	     add(listaApuestas);
		
	}

}
