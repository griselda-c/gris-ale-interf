package ruleta.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.OpcionJugada;
import ruleta.Ruleta;

public class RuletaWebModel {
	
	public static final String MESA = "mesa";

	public static final String ERRORJUGADOR = "errorJugador";

	public static final String NOMBREJUGADOR = "nombreJugador";

	public static final String DINEROJUGADOR = "dineroJugador";

	public static final String JUGADOR = "jugador";

	public static final String MODEL = "model";

	public static final String ERRORAPUESTA = "errorApuesta";

	public Jugador jugador;

	public Mesa mesa;	

	public RuletaWebModel(Mesa mesa, Jugador jugador) {
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

	



























	public static List<Apuesta> staticApuestas = Ruleta.getApuestas();
	
	public static RuletaWebModel getModel(HttpServletRequest request) {
		return (RuletaWebModel) request.getSession().getAttribute(RuletaWebModel.MODEL);
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
	    for(Apuesta apuestaTemp:staticApuestas){
	    	if(apuestaTemp.getTipoApuesta() == apuesta){
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public static Apuesta getApuesta(String apuesta) throws RuletaException {
	    for(Apuesta apuestaTemp:staticApuestas){
	    	if(apuestaTemp.getTipoApuesta() == apuesta){
	    		return apuestaTemp;
	    	}
	    }
	    throw new RuletaException("Se envio como parametro un tipo de apuesta no existente [Apuesta = " + apuesta + "]");
	}

	public static boolean esJugadaPosible(Apuesta apuestaTemp, String jugada) {
		for(OpcionJugada opcionJugada : apuestaTemp.getOpciones())
			if(opcionJugada.getNombre() == jugada){
				return true;
			}
		return false;
	}

	public static OpcionJugada getOpcionJugada(Apuesta apuestaTemp, String jugada)  throws RuletaException {
		for(OpcionJugada opcionJugada : apuestaTemp.getOpciones())
			if(opcionJugada.getNombre() == jugada){
				return opcionJugada;
			}
		throw new RuletaException("Se envio como parametro un valor de apuesta no existente [Apuesta = " + apuestaTemp.getTipoApuesta() + "], [Numero = " + jugada + "]");
	}

}
