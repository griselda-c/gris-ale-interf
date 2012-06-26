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
	private Mesa mesa=null;
	private boolean giraronRuleta;
    private int numeroAnterior;
   
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
	 	super.init();
	 	getMesa();
		//this.mesa = new Mesa(65000);
	
	}
	
	public Mesa getMesa() {
		if(mesa==null){
			mesa = new Mesa(65000);
		}
		return mesa;
	}
	
	public static RuletaWicketApplication getRuletaApplication() {
		return (RuletaWicketApplication) WebApplication.get();
	}
	
	
	public void girarRuleta(){
		if(giraronRuleta){
			throw new BusinessException("La ruleta ya fue girada");
		}
		giraronRuleta = true;
		numeroAnterior = getMesa().getNumeroGanador();
		getMesa().girarRuleta();
		
	}
	
	
	public int getNumeroGanadorAnterior(){
		return numeroAnterior;
	}
	
}
