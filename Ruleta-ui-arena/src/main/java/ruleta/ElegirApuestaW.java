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

public class ElegirApuestaW extends Window<Jugador> {

	public ElegirApuestaW(WindowOwner owner, Jugador model) {
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
		// paridad.onClick(new MessageSend(this.getModel(),
		// Jugador."APOSTARPARIDAD"));

		Button columna = new Button(filaApuestas);
		columna.setCaption("Columna");
		// columna.onClick(new MessageSend(this.getModel(),
		// Jugador."APOSTARCOLUMNA"));

		Button fila = new Button(filaApuestas);
		fila.setCaption("Fila");
		// fila.onClick(new MessageSend(this.getModel(),
		// Jugador."APOSTARFILA"));

	}

	public void apostarPleno() {
		final Jugador jugador = this.getModel();
		final Apuesta apuesta = jugador.nuevaApuestaPleno();
		
		ApuestaWindow apuestaWindow = new ApuestaWindow(this, apuesta);
		apuestaWindow.onAccept(new Action() {
			public void execute() {
				apuesta.confirmar();
				
			}
		});
		apuestaWindow.open();
	}

}
