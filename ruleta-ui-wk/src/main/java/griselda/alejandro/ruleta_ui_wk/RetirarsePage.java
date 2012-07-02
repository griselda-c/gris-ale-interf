package griselda.alejandro.ruleta_ui_wk;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ruleta.Jugador;

public class RetirarsePage extends WebPage {
private Jugador jugador;
	
  public RetirarsePage(Jugador j){
		jugador = j;
		add(new Label ("mensaje","Gracias por jugar con nosotros "));
		add(new Label ("fichas"," Usted se retira con  "));
		add(new Label ("cantFichas",new PropertyModel<Jugador>(jugador, "fichas")));
		add(new Label ("finFrase"," fichas "));
		
		
	}
	
	
}
