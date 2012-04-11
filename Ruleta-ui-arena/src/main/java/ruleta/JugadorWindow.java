package ruleta;

import org.apache.log4j.chainsaw.Main;
import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


public class JugadorWindow extends MainWindow<Mesa>{// se bindea con la clase mesa

	public JugadorWindow(Mesa model) {
		super(model);
	}

	private static final long serialVersionUID = 1L;

	public void createContents(Panel mainPanel) {
		this.setTitle("Ruleta el Ocho");
		
		mainPanel.setLayout(new VerticalLayout());
		

		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, haga sus apuestas:");
		
		Label nombreLabel = new Label(mainPanel);
		nombreLabel.setText("Nombre:");
		
		TextBox nombreJugador = new TextBox(mainPanel);
		nombreJugador.bindValueToProperty(Mesa.NOMBREJUGADOR);
		
		Label dineroLabel = new Label(mainPanel);
		dineroLabel.setText("Dinero:");
		
		TextBox dineroJugador = new TextBox(mainPanel);
		dineroJugador.bindValueToProperty(Mesa.DINEROJUGADOR);

		Button unirse = new Button(mainPanel);
		unirse.setCaption("Unirse");
		unirse.onClick(new MessageSend(this.getModel(), Mesa.UNIRJUGADOR));
		
	}
	
	public static void main(String[] args)  {
		new JugadorWindow(new Mesa(30)).startApplication();
	}

}
