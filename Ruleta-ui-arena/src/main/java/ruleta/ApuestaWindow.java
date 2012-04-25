package ruleta;

/*import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import org.apache.commons.beanutils.PropertyUtils;
import org.uqbar.lacar.ui.model.Adapter;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import com.uqbar.commons.collections.Transformer;*/

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;



public class ApuestaWindow extends Dialog<Apuesta> {	

	public ApuestaWindow(WindowOwner owner, Apuesta model) {
		super(owner, model);
	}

	@Override
	protected void executeTask() {		
		//this.getModel().confirmar();
		System.out.println("se confirma apuesta con fichas " + this.getModel().getFichas());
		System.out.println("se confirma apuesta con jugada " + this.getModel().getJugadaSeleccionada());
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, ACCEPT))
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, CANCEL));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {			
		mainPanel.setLayout(new VerticalLayout());
		
		Panel filaApuestas = new Panel(mainPanel);
		filaApuestas.setLayout(new ColumnLayout(2));
		
		Label fichasTexto = new Label(filaApuestas);
		fichasTexto.setText("Cantidad de fichas");
		
		TextBox fichas = new TextBox(filaApuestas);
		fichas.bindValueToProperty(Apuesta.FICHAS);
		
		Selector numero = new Selector(filaApuestas);
		numero.setContents(this.getModel().getOpciones(), "nombre");
		numero.bindValueToProperty(Apuesta.JUGADASELECCIONADA);
				
	}
	


	private static final long serialVersionUID = 1L;
	
	
	

}
