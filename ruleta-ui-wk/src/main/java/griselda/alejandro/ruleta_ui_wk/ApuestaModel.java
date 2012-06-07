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
	
	public static List<ApuestaWeb> staticApuestas = getApuestas();
	
    private Apuesta apuestaSeleccionada;
    private OpcionJugada opcionJugada;
	
	private static List<ApuestaWeb> getApuestas() {
		List<ApuestaWeb> apuestas = new LinkedList<ApuestaWeb>();
		apuestas.add(new ColumnaWeb());
		apuestas.add(new FilaWeb());
		apuestas.add(new PlenoWeb());
		apuestas.add(new ParImparWeb());
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
