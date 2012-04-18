package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


public class JugadorWindow extends MainWindow<Jugador>{// se bindea con la clase mesa

	public JugadorWindow(Jugador model) {
		super(model);
		System.out.println("se pide crear jugador en jugadorWindow");
	}

	private static final long serialVersionUID = 1L;

	public void createContents(Panel mainPanel) {
		this.setTitle("Ruleta el Ocho");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, haga sus apuestas:");
		
		
	}

	/*public static void main(String[] args)  {
		new MesaWindow().startApplication();
	}*/

}
