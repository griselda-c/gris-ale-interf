package ruleta;

public class FilaWindow extends ApuestaWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void apostar(){
		this.getModel().apostarFila();
	}
	
	public String titulo(){
		  
			return "Bienvenido a apuesta Fila";
		}
	
	public static void main(String[] args)  {
		new FilaWindow().startApplication();
	}
	
	
	
	

}
