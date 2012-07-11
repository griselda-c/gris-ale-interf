package ruleta.extras;

import java.io.Serializable;

public class Validador  implements Serializable{	
	private static final long serialVersionUID = -5614618002835237145L;


	public static boolean isText(String nombreJugadorS) {
		if(!(nombreJugadorS.length() > 0)){
			return false;
		}
		for (int i = 0; i < nombreJugadorS.length(); i++) {
			if ((nombreJugadorS.charAt(i) < 'A') || (nombreJugadorS.charAt(i) > 'z') || ((nombreJugadorS.charAt(i) > 'Z')&(nombreJugadorS.charAt(i) < 'a'))){
				 return false;
			}
		}
		return true;
	}

	
	public static boolean isNumber(String dineroJugadorS) {
		try{
			Integer.parseInt(dineroJugadorS);
		} catch(NumberFormatException nfe) {
			return false;
		}
			return true;
	}
}
