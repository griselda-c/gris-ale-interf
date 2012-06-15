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
	
	public static List<ApuestaWeb> staticApuestas = getApuestas();
	public  List<OpcionJugada> opciones = getOpciones();
	private Jugador jugador;
    private ApuestaWeb apuestaSeleccionada;
    private OpcionJugada opcionJugada ;
    private int fichas =0;
    
    
   
    public void setOpciones(List<OpcionJugada> opciones) {
		this.opciones = opciones;
	}

    
    
   public  List<OpcionJugada>getOpciones(){
    	if(apuestaSeleccionada!=null){
    		opciones = apuestaSeleccionada.apuesta.getOpciones();
    		
    	}
    	else{
    		List listaVacia =new LinkedList<OpcionJugada>();
    		opciones = listaVacia;
    	}
    	return opciones;
    }
	
    public void crearApuesta(){
    	
    	Apuesta apuesta = apuestaSeleccionada.create();
    	if(apuestaSeleccionada == null || opcionJugada == null){
    		new BusinessException("debe elegir un tipo de apuesta y un valor");
    	}
    	apuesta.setJugador(jugador);
    	apuesta.setJugadaSeleccionada(opcionJugada);
    	if(fichas > jugador.getFichas() || fichas <= 0 ){
    		new BusinessException(" no tiene las fichas suficientes");
    	}
    	apuesta.setFichas(fichas);
    	
    	jugador.apostar(apuesta);
    	
    }
    
    
	public static List<ApuestaWeb> getApuestas() {
		List<ApuestaWeb> apuestas = new LinkedList<ApuestaWeb>();
		apuestas.add(new ColumnaWeb());
		apuestas.add(new FilaWeb());
		apuestas.add(new PlenoWeb());
		apuestas.add(new ParImparWeb());
		return apuestas;
	}

	public ApuestaWeb getApuestaSeleccionada() {
		return apuestaSeleccionada;
	}

	public void setApuestaSeleccionada(ApuestaWeb apuestaSeleccionada) {
		this.apuestaSeleccionada = apuestaSeleccionada;
	}

	public static List<ApuestaWeb> getStaticApuestas() {
		return staticApuestas;
	}

	public static void setStaticApuestas(List<ApuestaWeb> staticApuestas) {
		ApuestaModel.staticApuestas = staticApuestas;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
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
	
	
	public static abstract class ApuestaWeb implements Serializable{
		public Apuesta apuesta = new Columna();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}		
		public abstract Apuesta create();
	}
	
	public static class ColumnaWeb extends ApuestaWeb implements Serializable{
		 
		public String getTipoApuesta(){
			apuesta = new Columna();
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Columna();
		}
		
	}
	
	public static class FilaWeb extends ApuestaWeb implements Serializable{
		 
		public String getTipoApuesta(){
			apuesta = new Fila();
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Fila();
		}
		
	}
	
	public static class PlenoWeb extends ApuestaWeb implements Serializable{
		 
		public String getTipoApuesta(){
			apuesta = new Pleno();
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Pleno();
		}
		
	}
	
	public static class ParImparWeb extends ApuestaWeb implements Serializable{
		
		public String getTipoApuesta(){
			apuesta = new ParImpar();
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new ParImpar();
		}
		
	}
	
	

}
