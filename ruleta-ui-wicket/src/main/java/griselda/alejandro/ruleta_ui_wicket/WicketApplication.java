package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.util.resource.locator.IResourceStreamLocator;

import ruleta.Mesa;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see griselda.alejandro.ruleta_ui_wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{   
	
	public Mesa mesaServidor;
		
	static public Mesa staticGetMesa(){
		WicketApplication aplicacion = (WicketApplication) WebApplication.get();
		return aplicacion.getMesa();
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

}
