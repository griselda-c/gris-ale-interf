package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class RuletaW extends Window<Mesa> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuletaW(WindowOwner owner, Mesa model) {
		super(owner, model);
		// TODO Auto-generated constructor stub
	}




	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta el Ocho-No va mas" );
		
		mainPanel.setLayout(new VerticalLayout());
		
		
		
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("El numero ganador es :");
		
		this.getModel().girarRuleta();
		Label estatico = new Label(mainPanel);
		estatico.bindValueToProperty(Mesa.NUMEROGANADOR);
		
	
		Button pagar = new Button(mainPanel);
		pagar.setCaption("Pagar Apuestas");
		pagar.onClick(new MessageSend(this,"pagar"));
		
		
		}// fin del createContents
	
	
public void pagar(){
		
		this.getModel().pagarApuestas();
		this.close();
		
	}


}
