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
	
	
	
	
	public RuletaWicketModel(Mesa mesa, Jugador jugador) {
		this.jugador = jugador;
		this.mesa = mesa;
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
		public Apuesta apuesta;
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
