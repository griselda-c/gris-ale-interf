package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

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
		subtitulo.setText(this.titulo());
		
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
		unirse.onClick(new MessageSend(this.getModel(),"apostar"));
				
		
		
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
