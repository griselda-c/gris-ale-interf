package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

public class ElegirApuestaWindow extends Window<Jugador> {

	public ElegirApuestaWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Ruleta del ocho");

		mainPanel.setLayout(new VerticalLayout());

		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("¿Qué apuesta creamos?");

		Panel filaApuestas = new Panel(mainPanel);
		filaApuestas.setLayout(new ColumnLayout(4));

		Button plena = new Button(filaApuestas);
		plena.setCaption("Plena");
		plena.onClick(new MessageSend(this, "apostarPleno"));

		Button paridad = new Button(filaApuestas);
		paridad.setCaption("Paridad");
		paridad.onClick(new MessageSend(this, "apostarParImpar"));

		Button columna = new Button(filaApuestas);
		columna.setCaption("Columna");
		columna.onClick(new MessageSend(this, "apostarColumna"));

		Button fila = new Button(filaApuestas);
		fila.setCaption("Fila");
		fila.onClick(new MessageSend(this, "apostarFila"));

	}

	public void apostarPleno() {
		Apuesta apuesta = this.getModel().nuevaApuestaPleno();
		this.apostarGeneral(apuesta);
	}
	public void apostarParImpar() {
		Apuesta apuesta = this.getModel().nuevaApuestaParImpar();
		this.apostarGeneral(apuesta);
	}
	public void apostarColumna() {
		Apuesta apuesta = this.getModel().nuevaApuestaColumna();
		this.apostarGeneral(apuesta);
	}
	public void apostarFila() {
		Apuesta apuesta = this.getModel().nuevaApuestaFila();
		this.apostarGeneral(apuesta);
	}
	
	//generaliza todos los tipos de apuesta
	public void apostarGeneral(Apuesta apuesta){	
		final Apuesta apuestaL = apuesta;
		ApuestaWindow apuestaWindow = new ApuestaWindow(this, apuesta);
		apuestaWindow.onAccept(new Action() {
			public void execute() {
				apuestaL.confirmar();	
				
			}
		});
		apuestaWindow.open();
	}

}

