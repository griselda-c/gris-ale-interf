package griselda.alejandro.ruleta_ui_wk;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.Apuesta;

public class ApuestaModel implements Serializable {
	
	private List<String>tiposApuestas = getTipoApuestas();
	
	public ApuestaModel(){
		
	}
	
	public List<String> getTipoApuestas(){
		List<String>apuestasTipo = new LinkedList<String>();
		apuestasTipo.add("Pleno");
		apuestasTipo.add("Columna");
		apuestasTipo.add("Paridad");
		apuestasTipo.add("Fila");
		return apuestasTipo;
	}
	
	
	
	

}
