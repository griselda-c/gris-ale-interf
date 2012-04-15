package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;


public class PlenoWindow extends MainWindow<MesaApuesta>{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	

	public PlenoWindow() {
		super(new MesaApuesta(10));
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Ruleta del ocho");
		
		mainPanel.setLayout(new VerticalLayout());
		

		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a Pleno");
		
		Label fichasLabel = new Label(mainPanel);
		fichasLabel.setText("ingrese fichas");
		
		TextBox ficha = new TextBox(mainPanel);
		ficha.bindValueToProperty(MesaApuesta.FICHASJUGADA);
		
		Label numeroLabel = new Label(mainPanel);
		numeroLabel.setText("ingrese numero: ");
		
		TextBox numeroJ = new TextBox(mainPanel);
		numeroJ.bindValueToProperty(MesaApuesta.NUMERO);
		
		Button unirse = new Button(mainPanel);
		unirse.setCaption("Apostar");
		unirse.onClick(new MessageSend(this.getModel(),MesaApuesta.APOSTARPLENO));
				
		
		
	}
	
	public static void main(String[] args)  {
		new PlenoWindow().startApplication();
	}
	
	

}
