package griselda.alejandro.ruleta_ui_wicket;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.core.util.resource.locator.IResourceStreamLocator;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.Mesa;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see griselda.alejandro.ruleta_ui_wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{   	
	public Mesa mesaServidor;
	
	public Partida partidaActual;
	public Partida partidaAnterior;		
	

	public List<JugadorModel> getJugadoresModel() {
		return this.partidaActual.jugadoresModel;
	}

	public Mesa getMesa() {
		return this.mesaServidor;
	}

	@Override
	protected void init() {		
		super.init();
		this.mesaServidor = new Mesa(10000);		
		this.partidaActual  = new Partida();
		this.partidaAnterior  = new Partida();
		this.partidaAnterior.resultadoPartida = mesaServidor.getNumeroGanador();
		// the full path to your folder, relative to the context root
		this.getResourceSettings().addResourceFolder("pages");
		IResourceSettings resourceSettings = getResourceSettings();
		resourceSettings.addResourceFolder("pages");
		resourceSettings.setResourceStreamLocator((IResourceStreamLocator) new PathStripperLocator());				
	}	    
    
	public WicketApplication()
	{
		
	}
	
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}
	
	
	public static boolean isNumber(String dineroJugadorS) {
		try{
			Integer.parseInt(dineroJugadorS);
		} catch(NumberFormatException nfe) {
			return false;
		}
			return true;
	}

	public void girarRuleta() {
		this.mesaServidor.girarRuleta();
		this.actualizarPartida();
	}

	public void actualizarPartida(){
		this.partidaAnterior = this.partidaActual;
		this.partidaActual = new Partida();
		partidaActual.resultadoPartida = this.getMesa().getNumeroGanador();
		partidaAnterior.resultadoPartida = this.getMesa().getNumeroGanador();
	}

}
