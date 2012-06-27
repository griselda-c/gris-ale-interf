package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.protocol.http.WebApplication;

import ruleta.Jugador;

public class HomeApplicationModel {

	
	
	public static Integer CANTIDADMAXIMAJUGADORES = 3;
	public String nombreloggin = "";
	public String dinerologgin = "";
	public String feedback1 = "Ingrese sus datos";
	public String feedback2 = "para iniciar sesion.";
	public HomePage homePage;
	public WicketApplication aplicacion;
	
	
	
	public HomeApplicationModel(HomePage homePage) {
		this.homePage = homePage;
		this.aplicacion = (WicketApplication) WebApplication.get();		
	}

	public void validarJugador() {
		if(!HomeApplicationModel.isText(nombreloggin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Formato de nombre incorrecto");
			this.setFeedback2("Intentelo nuevamente");
			this.homePage.setResponsePage(this.homePage);	
		}else if(!WicketApplication.isNumber(dinerologgin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Formato de dinero incorrecto");
			this.setFeedback2("Intentelo nuevamente");
			this.homePage.setResponsePage(this.homePage);	
		}else if(existeJugador(nombreloggin)){
			homePage.setErrorFeedback();
			this.setFeedback1("Ya existe un jugador con ese nombre");
			this.setFeedback2("Intente con otro nombre");
			this.homePage.setResponsePage(this.homePage);			
		}else if(!hayLugar()){
			homePage.setErrorFeedback();
			this.setFeedback1("La mesa esta completa");
			this.setFeedback2("Intente mas tarde");
			this.homePage.setResponsePage(this.homePage);
		}
		else {
			Jugador nuevoJugador = new Jugador(Integer.parseInt(dinerologgin), nombreloggin);
			aplicacion.mesaServidor.unirJugador(nuevoJugador);
			this.homePage.setResponsePage(new JugarPage(aplicacion.mesaServidor, nuevoJugador));			
		}
	}
	
	private boolean hayLugar() {
		return aplicacion.mesaServidor.jugadores.size() < HomeApplicationModel.CANTIDADMAXIMAJUGADORES;
	}

	public static boolean isText(String nombreJugadorS) {
		for (int i = 0; i < nombreJugadorS.length(); i++) {
			 if ((nombreJugadorS.charAt(i) < 'A') || (nombreJugadorS.charAt(i) > 'z') || ((nombreJugadorS.charAt(i) > 'Z')&(nombreJugadorS.charAt(i) < 'a'))){
				 return false;}
		}
		return true;
	}

	public boolean existeJugador(String nombreloggin) {
		for(Jugador jugador : aplicacion.mesaServidor.getJugadores()){
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
