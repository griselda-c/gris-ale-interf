package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.protocol.http.WebApplication;

import ruleta.Mesa;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see griselda.alejandro.ruleta_ui_wk.Start#main(String[])
 */
public class RuletaWicketApplication extends WebApplication {
	private Mesa mesa;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<AdjuntarJugadorPage> getHomePage() {
		return AdjuntarJugadorPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		this.mesa = new Mesa(65000);
	}
	
	public Mesa getMesa() {
		return mesa;
	}
	
	public static RuletaWicketApplication getRuletaApplication() {
		return (RuletaWicketApplication) WebApplication.get();
	}
	
}
