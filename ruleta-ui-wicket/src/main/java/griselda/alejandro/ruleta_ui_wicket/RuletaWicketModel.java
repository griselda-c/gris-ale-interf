package griselda.alejandro.ruleta_ui_wicket;

import java.util.LinkedList;
import java.util.List;

import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.OpcionJugada;
import ruleta.ParImpar;
import ruleta.Pleno;

public class RuletaWicketModel {
	
	public static final String MESA = "mesa";

	public static final String ERRORJUGADOR = "errorJugador";

	public static final String NOMBREJUGADOR = "nombreJugador";

	public static final String DINEROJUGADOR = "dineroJugador";

	public static final String JUGADOR = "jugador";

	public static final String MODEL = "model";

	public static final String ERRORAPUESTA = "errorApuesta";

	public Jugador jugador;

	public Mesa mesa;
	
	public ApuestaWebAdapter pleno;
	public ApuestaWebAdapter paridad;
	public ApuestaWebAdapter fila;
	public ApuestaWebAdapter columna;
	public ApuestaWebAdapter zero;

	
	
	
	public RuletaWicketModel(Mesa mesa, Jugador jugador) {
		this.jugador = jugador;
		this.mesa = mesa;
		this.pleno = new ApuestaWebAdapter(jugador.nuevaApuestaPleno(), false);
		this.zero = new ApuestaWebAdapter(jugador.nuevaApuestaPleno(), true);
		this.paridad = new ApuestaWebAdapter(jugador.nuevaApuestaParImpar());
		this.fila = new ApuestaWebAdapter(jugador.nuevaApuestaFila());
		this.columna = new ApuestaWebAdapter(jugador.nuevaApuestaColumna());
	}
	
	public class ApuestaWebAdapter{
		
		public List<OpcionJugada> opciones;
		public String tipoApuesta;
		
		public ApuestaWebAdapter(Apuesta apuesta){
			this.opciones = apuesta.getOpciones();
			this.tipoApuesta = apuesta.getTipoApuesta();
		}
		
		public ApuestaWebAdapter(Apuesta apuesta, boolean zero){
			if(zero){
				this.opciones = new LinkedList<OpcionJugada>();
				this.opciones.add(apuesta.getOpciones().get(0));
			}
			else{
				List<OpcionJugada> opcionesTemp = new LinkedList<OpcionJugada>();
				for(OpcionJugada opAp : apuesta.getOpciones()){
					opcionesTemp.add(new OpcionJugadawebAdapter(opAp));
				}
				opcionesTemp.remove(0);			
				this.opciones = opcionesTemp;
			}
			
			this.tipoApuesta = apuesta.getTipoApuesta();
		}
		
		public class OpcionJugadawebAdapter extends OpcionJugada{
			OpcionJugada jugada;
			
			public OpcionJugadawebAdapter(OpcionJugada jugada){				
				super();
				this.jugada = jugada;
			}

			public int getValor() {
				return this.jugada.getValor();
			}
			
			public String getNombre() {
				return this.jugada.getNombre();
			}
			
			public String getClase() {
				Integer vl = this.jugada.getValor();				
				if((((vl>11 & vl<19) | vl>29) & (vl%2 == 0)) | ((vl<10 | (vl>18 & vl<28)) & (vl%2 != 0))){
					return "rojo";
				}				
				return "negro";
			}
			
			
		}

		public List<OpcionJugada> getOpciones() {
			return opciones;
		}

		public String getTipoApuesta() {
			return tipoApuesta;
		}	
	}
	
	
	
	
	
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public ApuestaWebAdapter getPleno() {
		return pleno;
	}

	public ApuestaWebAdapter getParidad() {
		return paridad;
	}

	public ApuestaWebAdapter getFila() {
		return fila;
	}

	public ApuestaWebAdapter getColumna() {
		return columna;
	}
	
	public ApuestaWebAdapter getZero() {
		return zero;
	}




	public static List<ApuestaWeb> staticApuestas = getApuestas();


	private static List<ApuestaWeb> getApuestas() {
		List<ApuestaWeb> apuestas = new LinkedList<ApuestaWeb>();
		apuestas.add(new ColumnaWeb());
		apuestas.add(new FilaWeb());
		apuestas.add(new PlenoWeb());
		apuestas.add(new ParImparWeb());
		return apuestas;
	}
	
	public static abstract class ApuestaWeb{
		public Apuesta apuesta = new Columna();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}		
		public abstract Apuesta create();
	}
	
	public static class ColumnaWeb extends ApuestaWeb{
		public Apuesta apuesta = new Columna();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Columna();
		}
		
	}
	
	public static class FilaWeb extends ApuestaWeb{
		public Apuesta apuesta = new Fila();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Fila();
		}
		
	}
	
	public static class PlenoWeb extends ApuestaWeb{
		public Apuesta apuesta = new Pleno();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Pleno();
		}
		
	}
	
	public static class ParImparWeb extends ApuestaWeb{
		public Apuesta apuesta = new ParImpar();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new ParImpar();
		}
		
	}

	public static boolean isNumber(String dineroJugadorS) {
		try{
			Integer.parseInt(dineroJugadorS);
		} catch(NumberFormatException nfe) {
			return false;
		}
			return true;
	}

	public static boolean isText(String nombreJugadorS) {
		for (int i = 0; i < nombreJugadorS.length(); i++) {
			 if ((nombreJugadorS.charAt(i) < 'A') || (nombreJugadorS.charAt(i) > 'z') || ((nombreJugadorS.charAt(i) > 'Z')&(nombreJugadorS.charAt(i) < 'a'))){
				 return false;}
		}
		return true;
	}

	public static boolean esApuesta(String apuesta) {
	    for(ApuestaWeb apuestaTemp: staticApuestas){
	    	if(apuestaTemp.getTipoApuesta().equals(apuesta)){
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public static Apuesta getApuesta(String apuesta) throws RuletaException {
	    for(ApuestaWeb apuestaTemp: staticApuestas){
	    	if(apuestaTemp.getTipoApuesta().equals(apuesta)){
	    		return apuestaTemp.create();
	    	}
	    }
	    throw new RuletaException("Se envio como parametro un tipo de apuesta no existente [Apuesta = " + apuesta + "]");
	}

	public static boolean esJugadaPosible(Apuesta apuestaTemp, String jugada) {
		for(OpcionJugada opcionJugada : apuestaTemp.getOpciones())
			if(opcionJugada.getNombre().equals(jugada)){
				return true;
			}
		return false;
	}

	public static OpcionJugada getOpcionJugada(Apuesta apuestaTemp, String jugada)  throws RuletaException {
		for(OpcionJugada opcionJugada : apuestaTemp.getOpciones())
			if(opcionJugada.getNombre().equals(jugada)){
				return opcionJugada;
			}
		throw new RuletaException("Se envio como parametro un valor de apuesta no existente [Apuesta = " + apuestaTemp.getTipoApuesta() + "], [Numero = " + jugada + "]");
	}


	
	
}
