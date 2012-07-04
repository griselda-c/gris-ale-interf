package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.protocol.http.WebApplication;

import ruleta.Mesa;
import ruleta.RuletaApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see griselda.alejandro.ruleta_ui_wk.Start#main(String[])
 */
public class RuletaWicketApplication extends WebApplication {
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
	}
	
	public RuletaApplication getRuletaApplication() {
		return RuletaApplication.getInstance();
	}
	
	public static RuletaWicketApplication getRuletaWicketApplication() {
		return (RuletaWicketApplication) WebApplication.get();
	}
	/*
	public boolean mesaEstaAbierta(){
		return !(giraronRuleta);
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
	*/
}
