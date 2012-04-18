package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import ruleta.MesaApuesta;

public class ApuestaWindow extends MainWindow<MesaApuesta> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApuestaWindow() {
		super(new MesaApuesta(10));
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta del ocho");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("¿Qué apuesta creamos?");
		
		Panel filaApuestas = new Panel(mainPanel);
		filaApuestas.setLayout(new ColumnLayout(4));

		/*
		
		Label fichasLabel = new Label(mainPanel);
		fichasLabel.setText("ingrese fichas");
		
		TextBox ficha = new TextBox(mainPanel);
		ficha.bindValueToProperty(MesaApuesta.FICHASJUGADA);
		
		Label numeroLabel = new Label(mainPanel);
		numeroLabel.setText("ingrese numero: ");
		
		TextBox numeroJ = new TextBox(mainPanel);
		numeroJ.bindValueToProperty(MesaApuesta.NUMERO);*/

		Button plena = new Button(filaApuestas);
		plena.setCaption("Plena");
		plena.onClick(new MessageSend(this.getModel(), Jugador."APOSTARPLENA"));
		
		Button paridad = new Button(filaApuestas);
		paridad.setCaption("Paridad");
		paridad.onClick(new MessageSend(this.getModel(), Jugador."APOSTARPLENA"));
		
		Button columna = new Button(filaApuestas);
		columna.setCaption("Columna");
		columna.onClick(new MessageSend(this.getModel(), Jugador."APOSTARPLENA"));
		
		Button fila = new Button(filaApuestas);
		fila.setCaption("Fila");
		fila.onClick(new MessageSend(this.getModel(), Jugador."APOSTARPLENA"));
				
		
		
	}
	
	public void apostar(){
		//para implementar subclases
	}
	
	public String titulo(){
	  //para implementar en subclases
		return "";
	}
	
	public static void main(String[] args)  {
		new ApuestaWindow().startApplication();
	}
	
	
	
	

}
