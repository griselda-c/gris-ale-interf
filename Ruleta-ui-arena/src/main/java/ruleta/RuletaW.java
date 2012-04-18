package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import ruleta.Mesa;

public class RuletaW extends MainWindow<Mesa> {
	
	public RuletaW(){
		super(new Mesa(10));
		
	}
	
	


	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta el Ocho-No va mas" );
		
		mainPanel.setLayout(new VerticalLayout());
		
		
		
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("El numero ganador es :");
		
		
		Label estatico = new Label(mainPanel);
		estatico.bindValueToProperty(Mesa.NUMEROGANADOR);
		
		Button ruleta = new Button(mainPanel);
		ruleta.setCaption("Girar Ruleta");
		ruleta.onClick(new MessageSend(this.getModel(),Mesa.GIRARRULETA));
		
        
		Button pagar = new Button(mainPanel);
		pagar.setCaption("Pagar Apuestas");
		ruleta.onClick(new MessageSend(this.getModel(),Mesa.GIRARRULETA));
		
		
		}// fin del createContents
	
	
	
	public static void main(String[] args) {
		
		new RuletaW().startApplication();
	}

}
