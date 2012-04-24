package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class CambioFichasWindow extends Dialog<Jugador> {

	private static final long serialVersionUID = 1L;

	public CambioFichasWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		
		mainPanel.setLayout(new ColumnLayout(3));
		
		
		new Label(mainPanel).setText("Cuenta con");
		new Label(mainPanel).bindValueToProperty(Jugador.DINERO);
		new Label(mainPanel).setText("$");
		new Label(mainPanel).setText("cambiar");
		new TextBox(mainPanel).bindValueToProperty(Jugador.FICHASMAS);
		
		Panel botonesPanel = new Panel(mainPanel);
		botonesPanel.setLayout(new ColumnLayout(6));
		
		Button botonCambiar = new Button(botonesPanel);
		botonCambiar.setCaption("Cambiar");
		botonCambiar.onClick(new MessageSend(this, "sumar"));
		
		Button botonCancelar = new Button(botonesPanel);
		botonCancelar.setCaption("Cancelar");
		botonCancelar.onClick(new MessageSend(this,"cerrar"));
		
	
	}
	
	public void sumar(){
		this.getModel().sumarFichas();
		this.close();
		
	}
	
	public void cerrar(){
		this.close();
		this.getModel().fichasMas =0;
	}

	@Override
	protected void executeTask() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}

}
