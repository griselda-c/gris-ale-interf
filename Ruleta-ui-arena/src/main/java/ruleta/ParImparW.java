package ruleta;

public class ParImparW extends ApuestaWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void apostar(){
		this.getModel().apostarParImpar();
	}
	
	public String titulo(){
		  
			return "Bienvenido a apuesta ParImpar";
		}
	
	public static void main(String[] args)  {
		new ParImparW().startApplication();
	}
	

}
