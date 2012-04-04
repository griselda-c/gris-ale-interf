package ruleta;


import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


public class MesaWindow extends MainWindow<Mesa>{
	
	public MesaWindow(){
		super(new Mesa(10));
	}
	
	public void createContents(Panel mainPanel) {
		mainPanel.setLayout(new VerticalLayout());

		

		Label girarRuleta2 = new Label(mainPanel);
		girarRuleta2.setText("El numero ganador es:");
		
		Label numeroGanadorEstatico = new Label(mainPanel);
		numeroGanadorEstatico.bindValueToProperty(Mesa.NUMEROGANADOR);
		
		
		TextBox numeroGanador = new TextBox(mainPanel);
		numeroGanador.bindValueToProperty(Mesa.NUMEROGANADOR);

		Button girarRuleta = new Button(mainPanel);
		girarRuleta.setCaption("Girar ruleta");
		girarRuleta.onClick(new MessageSend(this.getModel(), Mesa.GIRARRULETA));
		
		
		

		/*Label kilometros = new Label(mainPanel);
		kilometros.bindValueToProperty(Conversor.KILOMETROS);*/
		
	}

	public static void main(String[] args)  {
		new MesaWindow().startApplication();
	}

}

