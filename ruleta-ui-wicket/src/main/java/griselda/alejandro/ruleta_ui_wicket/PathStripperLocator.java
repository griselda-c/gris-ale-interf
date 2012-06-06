package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;

/**
 * Sacado de la interne'
 * 
 * @author jfernandes
 */
public class PathStripperLocator extends ResourceStreamLocator {

	public PathStripperLocator() {
	}

	public IResourceStream locate(final Class clazz, final String path) {
		IResourceStream located = super.locate(clazz, trimFolders(path));
		if (located != null) {
			return located;
		}
		return super.locate(clazz, path);
	}

	protected String trimFolders(String path) {
		return path.substring(path.lastIndexOf("/") + 1);
	}
}