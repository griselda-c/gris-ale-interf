package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class RetirarseWindow extends Window<Jugador>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RetirarseWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		// TODO Auto-generated method stub
		mainPanel.setLayout(new ColumnLayout(5));
		new Label(mainPanel).setText("El jugador");
		new Label(mainPanel).setText(this.getModel().nombre);
		new Label(mainPanel).setText("se retira con ");
		new Label(mainPanel).bindValueToProperty(Jugador.FICHAS);
		new Label(mainPanel).setText("$");
	   Button boton = new Button(mainPanel).setCaption("OK");
	   boton.onClick(new MessageSend(this,"cerrar"));
	    
	  
	    
	}
	
	  public void cerrar(){
	    	this.close();
	    }
	  
	
}
