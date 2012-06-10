package griselda.alejandro.ruleta_ui_wk;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.Jugador;
import ruleta.OpcionJugada;
import ruleta.ParImpar;
import ruleta.Pleno;




public class ApuestaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static List<Apuesta> staticApuestas = getApuestas();
	public  List<OpcionJugada> opciones = getOpciones();
	private Jugador jugador;
    private Apuesta apuestaSeleccionada;
    private OpcionJugada opcionJugada;
    private int fichas = 0;
    
    
   public  List<OpcionJugada>getOpciones(){
    	if(apuestaSeleccionada!=null){
    		return apuestaSeleccionada.getOpciones();
    	}
    	else{
    		return null;
    	}
    	
    }
	
    public void crearApuesta(){
    	
    	apuestaSeleccionada.setFichas(fichas);
    	apuestaSeleccionada.setJugadaSeleccionada(opcionJugada);
    	apuestaSeleccionada.setJugador(jugador);
    	jugador.apostar(apuestaSeleccionada);
    	
    }
	public static List<Apuesta> getApuestas() {
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
		System.out.println(" se selecciono " +apuestaSeleccionada);
	}

	public static List<Apuesta> getStaticApuestas() {
		return staticApuestas;
	}

	public static void setStaticApuestas(List<Apuesta> staticApuestas) {
		ApuestaModel.staticApuestas = staticApuestas;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public void setOpciones(List<OpcionJugada> opciones) {
		this.opciones = opciones;
	}

	public OpcionJugada getOpcionJugada() {
		return opcionJugada;
	}

	public void setOpcionJugada(OpcionJugada opcionJugada) {
		this.opcionJugada = opcionJugada;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	
	
	

}
