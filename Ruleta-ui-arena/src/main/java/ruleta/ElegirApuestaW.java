package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.ObservableObject;

import ruleta.MesaApuesta;

public class ElegirApuestaW extends MainWindow<MesaApuesta>{

	public ElegirApuestaW() {
		super(new MesaApuesta(10));
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta del ocho");
		
		mainPanel.setLayout(new VerticalLayout());
		

		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("        Bienvenido a apuesta          ");
		
		Label jugador = new Label(mainPanel);
		jugador.bindValueToProperty(MesaApuesta.NOMBREJUGADOR);
		
		Label elegirLabel = new Label(mainPanel);
		elegirLabel.setText("Que apuesta desea hacer");
		
		
		
		
		Button pleno = new Button(mainPanel);
		pleno.setCaption("Pleno");
		pleno.onClick(new MessageSend(this, "pleno"));		
		
		Button fila = new Button(mainPanel);
		fila.setCaption("Fila");
		fila.onClick(new MessageSend(this, "fila"));
		
		Button par = new Button(mainPanel);
		par.setCaption("ParImpar");
		par.onClick(new MessageSend(this, "parImpar"));
		
		Button columna = new Button(mainPanel);
		columna.setCaption("Columna");
		columna.onClick(new MessageSend(this, "columna"));
		}
	
	public void pleno(){
		new PlenoWindow().open();
		
	}
	
	public void fila(){
		new FilaWindow().open();
		
	}
	
	public void columna(){
		new ColumnaWindow().open();
		
	}
	
	public void parImpar(){
		new ParImparW().open();
		
	}
	

	public static void main(String[] args)  {
		new ElegirApuestaW().startApplication();
	}

}
