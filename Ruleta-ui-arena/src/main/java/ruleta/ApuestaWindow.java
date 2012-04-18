package ruleta;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class ApuestaWindow extends Dialog<Jugador> {	

	public ApuestaWindow(WindowOwner owner, Jugador model) {
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
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {			
		mainPanel.setLayout(new VerticalLayout());
		
		Panel filaApuestas = new Panel(mainPanel);
		filaApuestas.setLayout(new ColumnLayout(2));
		
		Label subtitulo = new Label(filaApuestas);
		subtitulo.setText("Cantidad de fichas");
		
		TextBox fichas = new TextBox(mainPanel);
		fichas.bindValueToProperty("apuestaActual.fichas");
		
		
		
	}

	
	
	
	

}
