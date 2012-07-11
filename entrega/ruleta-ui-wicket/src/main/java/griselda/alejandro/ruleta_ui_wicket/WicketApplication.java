package griselda.alejandro.ruleta_ui_wicket;


import griselda.alejandro.ruleta_ui_wicket.extras.PathStripperLocator;

import java.io.Serializable;

import org.apache.wicket.core.util.resource.locator.IResourceStreamLocator;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;


public class WicketApplication extends WebApplication  implements Serializable{   	
	private static final long serialVersionUID = 1L;

	protected void init() {		
		super.init();		
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

}
