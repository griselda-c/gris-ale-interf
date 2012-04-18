package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.WindowOwner;


import ruleta.MesaApuesta;

public class ApuestaWindow Dialog<Jugador> {
	
	public ApuestaWindow(WindowOwner owner) {
		super(owner, new Socio()); //
	}
	
	@Override
	protected void executeTask() {
		getHome().create(getModel());
	}
	

	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta del ocho "); //concatenar el string de la apuesta
		
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
