package ruleta;



import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.SearchByExample;

import com.uqbar.commons.ReflectionUtils;



public class MesaWindow extends MainWindow<Mesa>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MesaWindow(){
		super(new Mesa(10));
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ruleta el Ocho");
		
		mainPanel.setLayout(new VerticalLayout());


		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, ingrese sus datos para unirse:");

		//panel horizantal x2

		Panel nombreDinero = new Panel(mainPanel);
		nombreDinero.setLayout(new ColumnLayout(2));

		Label nombreLabel = new Label(nombreDinero);
		nombreLabel.setText("Nombre:");

		TextBox nombreJugador = new TextBox(nombreDinero);
		nombreJugador.bindValueToProperty(Mesa.NOMBREJUGADOR);

		Label dineroLabel = new Label(nombreDinero);
		dineroLabel.setText("Dinero:");

		TextBox dineroJugador = new TextBox(nombreDinero);
		dineroJugador.bindValueToProperty(Mesa.DINEROJUGADOR);
		

		Button unirse = new Button(mainPanel);
		unirse.setCaption("Unirse");
		unirse.onClick(new MessageSend(this, "unirJugador"));
	
	}
	
	
	public void unirJugador() {
		System.out.println("se invoca a unir jugador");
		this.getModel().unirJugadorActual();
		System.out.println("se unio jugador?");
		new JugadorWindow(this.getModel().getJugadorActual()).open();
	}


	public static void main(String[] args)  {
		new MesaWindow().startApplication();
	}

}

