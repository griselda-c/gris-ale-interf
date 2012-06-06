package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.util.resource.locator.IResourceStreamLocator;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see griselda.alejandro.ruleta_ui_wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    
	
	@Override
	protected void init() {
		super.init();

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
