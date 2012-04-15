package ruleta;

public class ColumnaWindow extends ApuestaWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void apostar(){
		this.getModel().apostarColumna();
	}
	
	public String titulo(){
		  
			return "Bienvenido a apuesta Columna";
		}
	
	public static void main(String[] args)  {
		new ColumnaWindow().startApplication();
	}
	

}
