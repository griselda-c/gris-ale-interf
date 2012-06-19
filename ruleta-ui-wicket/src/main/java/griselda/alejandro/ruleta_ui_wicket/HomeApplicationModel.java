package griselda.alejandro.ruleta_ui_wicket;

import ruleta.Jugador;
import ruleta.Mesa;

public class HomeApplicationModel {

	public static Integer cantidadMaximaDeJugadores = 1;
	public String nombreloggin = "";
	public String dinerologgin = "";
	public String feedback1 = "Ingrese sus datos";
	public String feedback2 = "para iniciar sesion.";
	public HomePage homePage;
	
	
	
	public HomeApplicationModel(HomePage homePage) {
		this.homePage = homePage;
	}

	public void validarJugador() {
		if(!HomeApplicationModel.isText(nombreloggin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Formato de nombre incorrecto");
			this.setFeedback2("Intentelo nuevamente");
			this.homePage.setResponsePage(this.homePage);	
		}else if(!HomeApplicationModel.isNumber(dinerologgin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Formato de dinero incorrecto");
			this.setFeedback2("Intentelo nuevamente");
			this.homePage.setResponsePage(this.homePage);	
		}else if(HomeApplicationModel.existeJugador(nombreloggin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Ya existe un jugador con ese nombre");
			this.setFeedback2("Intente con otro nombre");
			this.homePage.setResponsePage(this.homePage);			
		}else if(!HomeApplicationModel.hayLugar()){
			homePage.setErrorFeedback();
			this.setFeedback1("La mesa esta completa");
			this.setFeedback2("Intente mas tarde");
			this.homePage.setResponsePage(this.homePage);
		}
		else {
			Mesa mesa = WicketApplication.staticGetMesa();
			Jugador nuevoJugador = new Jugador(Integer.parseInt(dinerologgin), nombreloggin);
			mesa.unirJugador(nuevoJugador);
			WicketApplication.actualizarJugadoresModel();
			this.homePage.setResponsePage(new JugarPage(mesa, nuevoJugador));			
		}
	}
	
	private static boolean hayLugar() {
		return WicketApplication.staticGetMesa().jugadores.size() < cantidadMaximaDeJugadores;
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

	

	public static boolean existeJugador(String nombreloggin) {
		for(Jugador jugador : WicketApplication.staticGetMesa().getJugadores()){
			if(nombreloggin.equals(jugador.getNombre())){
				return true;
			}
		}
		return false;
	}

	
	public String getNombreloggin() {
		return nombreloggin;
	}

	public void setNombreloggin(String nombreLoggin) {
		this.nombreloggin = nombreLoggin;
	}

	public String getDinerologgin() {
		return dinerologgin;
	}

	public void setDinerologgin(String dineroLoggin) {
		this.dinerologgin = dineroLoggin;
	}	

	public String getFeedback1() {
		return feedback1;
	}

	public void setFeedback1(String feedback1) {
		this.feedback1 = feedback1;
	}

	public String getFeedback2() {
		return feedback2;
	}

	public void setFeedback2(String feedback2) {
		this.feedback2 = feedback2;
	}

}
