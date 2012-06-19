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
	
	public class SlotApuestas {		
		public List<Apuesta> apuestasSlot;
		public SlotApuestas(){
			this.apuestasSlot = new LinkedList<Apuesta>();
		}
	}	

	public SlotApuestas apuestasActuales[];
	
	public SlotApuestas apuestasPartidaAnterior[]; 
	
	public Integer resultadoPartidaAnterior;
	
	public List<JugadorModel> jugadoresModel;
	public Mesa mesaServidor;
		
	static public Mesa staticGetMesa(){
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		return aplicacion.getMesa();
	}
	
	static public List<JugadorModel> staticGetJugadores(){
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		return aplicacion.getJugadoresModel();
	}
	
	static public void staticSetJugadores(List<JugadorModel> jugadores){
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		aplicacion.setJugadoresModel(jugadores);
	}
	
	
	
	public List<JugadorModel> getJugadoresModel() {
		return jugadoresModel;
	}

	public void setJugadoresModel(List<JugadorModel> jugadoresModel) {
		this.jugadoresModel = jugadoresModel;
	}

	public Mesa getMesa() {
		return this.mesaServidor;
	}

	@Override
	protected void init() {		
		super.init();
		this.mesaServidor = new Mesa(10000);
		// the full path to your folder, relative to the context root
		this.getResourceSettings().addResourceFolder("pages");

		IResourceSettings resourceSettings = getResourceSettings();
		resourceSettings.addResourceFolder("pages");
		resourceSettings.setResourceStreamLocator((IResourceStreamLocator) new PathStripperLocator());
		
		//inicializar las listas del array slot
		apuestasActuales = new SlotApuestas[39];
		inicializarSlots(apuestasActuales);
		apuestasPartidaAnterior = new SlotApuestas[39];
		inicializarSlots(apuestasPartidaAnterior);
		
	}
	
    public void inicializarSlots(SlotApuestas[] slotArray) {
		for (int i = 0; i < slotArray.length; i++) {
			slotArray[i] = new SlotApuestas();
		}		
	}
    
    

	/**
     * Constructor
     */
	public WicketApplication()
	{
		
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	public static void actualizarJugadoresModel() {
		List<JugadorModel> nuevaLista = new LinkedList<JugadorModel>();
		for (Jugador jugador : staticGetMesa().jugadores) {
			nuevaLista.add(new JugadorModel(jugador));
		}		
		staticSetJugadores(nuevaLista);
	}

}
