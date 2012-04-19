package ruleta;

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

	// conoce una apuesta y no un jugador
	public ApuestaWindow(WindowOwner owner, Apuesta model) {
		super(owner, model);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	protected void executeTask() {		
		this.getModel().confirmar();
		
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
		numero.setContents(this.getModel().getOptions(), "esta es una descripcion");
		
		
	}

	
	
	
	

}
