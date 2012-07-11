package griselda.alejandro.ruleta_ui_wicket.models;

import griselda.alejandro.ruleta_ui_wicket.HomePage;
import griselda.alejandro.ruleta_ui_wicket.JugarPage;
import griselda.alejandro.ruleta_ui_wicket.WicketApplication;

import java.io.Serializable;

import org.apache.wicket.protocol.http.WebApplication;

import ruleta.Jugador;
import ruleta.Mesa;
import ruleta.exceptions.RuletaException;

public class HomeApplicationModel  implements Serializable{
	private static final long serialVersionUID = 1L;
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

	public void adjuntarJugador() {
		try{
			Jugador nuevoJugador = Mesa.getInstancia().adjuntarJugador(this.nombreloggin, this.dinerologgin);
			this.homePage.setResponsePage(new JugarPage(nuevoJugador));			
		}
		catch (RuletaException e) {
			System.out.println("se cachea " + e.getError());
			homePage.setErrorFeedback();
			this.setFeedback1(e.getError());
			this.setFeedback2(e.getSugerencia());
		}
	}
	
	//access	
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
