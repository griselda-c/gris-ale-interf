package griselda.alejandro.ruleta_ui_wk;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.OpcionJugada;
import ruleta.ParImpar;
import ruleta.Pleno;




public class ApuestaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static List<Apuesta> staticApuestas = getApuestas();
	
    private Apuesta apuestaSeleccionada;
    private OpcionJugada opcionJugada;
    private int fichas = 0;
    
    
    private  List<OpcionJugada>getOpciones(){
    	return this.apuestaSeleccionada.getOpciones();
    	
    }
	
	private static List<Apuesta> getApuestas() {
		List<Apuesta> apuestas = new LinkedList<Apuesta>();
		apuestas.add(new Columna());
		apuestas.add(new Fila());
		apuestas.add(new Pleno());
		apuestas.add(new ParImpar());
		return apuestas;
	}

	public Apuesta getApuestaSeleccionada() {
		return apuestaSeleccionada;
	}

	public void setApuestaSeleccionada(Apuesta apuestaSeleccionada) {
		this.apuestaSeleccionada = apuestaSeleccionada;
	}

	public OpcionJugada getOpcionJugada() {
		return opcionJugada;
	}

	public void setOpcionJugada(OpcionJugada opcionJugada) {
		this.opcionJugada = opcionJugada;
	}
	
	
	
	

}
