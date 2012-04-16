package ruleta;



import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


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
		unirse.onClick(new MessageSend(this.getModel(),Mesa.UNIRJUGADOR));
		
		/*Button nuevaVista = new Button(mainPanel);
		nuevaVista.setCaption("levantarVista");
		nuevaVista.onClick(new ActionListener() {
			
			public void execute() {
				
			}
		});*/
		
		
		

		
	}
	
	
	public void unirse(){
	   this.getModel().unirJugadorActual();
       new ElegirApuestaW().open();	   
		
		
	}

	public static void main(String[] args)  {
		new MesaWindow().startApplication();
	}

}

