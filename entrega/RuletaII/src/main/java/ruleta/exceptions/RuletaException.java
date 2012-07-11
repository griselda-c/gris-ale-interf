package ruleta.exceptions;

public class RuletaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String error;
	private String sugerencia;

	public RuletaException(String error){
		super(error);
		this.error = error;		
	}
	
	public RuletaException(String error, String sugerencia){
		super(error);
		this.error = error;	
		this.sugerencia = sugerencia;		
	}

	public String getError() {
		return error;
	}

	public String getSugerencia() {
		return sugerencia;
	}
	
	
}
