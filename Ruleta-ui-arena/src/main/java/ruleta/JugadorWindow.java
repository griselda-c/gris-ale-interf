package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


public class JugadorWindow extends Window<Jugador>{// se bindea con la clase mesa

	public JugadorWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	private static final long serialVersionUID = 1L;

	public void createContents(Panel mainPanel) {
		
		mainPanel.setLayout(new VerticalLayout());
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, haga sus apuestas:");
		
		Panel columnas = new Panel(mainPanel);
		columnas.setLayout(new ColumnLayout(2));
		
		Panel grid = new Panel(columnas);
		grid.setLayout(new ColumnLayout(1));
		
		Label sGrid = new Label(grid);
		sGrid.setText("Mesa CIU");
		
		Panel datosOpciones = new Panel(columnas);
		datosOpciones.setLayout(new ColumnLayout(1));

		Label nombreLabel = new Label(datosOpciones);
		nombreLabel.setText("Hola");

		Label nombreJugador = new Label(datosOpciones);
		nombreJugador.bindValueToProperty(Jugador.NOMBRE);

		Label dineroLabel = new Label(datosOpciones);
		dineroLabel.setText("Cantidad de fichas:");

		Label dineroJugador = new Label(datosOpciones);
		dineroJugador.bindValueToProperty(Jugador.FICHAS);
		
		Label ask = new Label(datosOpciones);
		ask.setText("¿Qué desea hacer?");
		

		Button retirarse = new Button(datosOpciones);
		retirarse.setCaption("Retirarse");
		retirarse.onClick(new MessageSend(this, "retirarse"));
		
		Button apostar = new Button(datosOpciones);
		apostar.setCaption("Apostar");
		apostar.onClick(new MessageSend(this, "apostar"));
		
		Button cambiar = new Button(datosOpciones);
		cambiar.setCaption("Cambiar fichas");
		cambiar.onClick(new MessageSend(this, "retirarse"));
				
	}
	
	public void retirarse(){
		((MesaWindow)this.getOwner()).retirarJugador(this.getModel());
		this.close();
	}
	
	public void apostar(){
		new ElegirApuestaW(this, this.getModel()).open();
	}
	
}

