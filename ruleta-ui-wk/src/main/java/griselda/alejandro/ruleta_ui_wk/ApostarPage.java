package griselda.alejandro.ruleta_ui_wk;

import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;

import java.awt.Label;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ruleta.Apuesta;
import ruleta.Jugador;
import ruleta.OpcionJugada;

public class ApostarPage extends WebPage{

	private static final long serialVersionUID = 1L;

	private Jugador jugador;
	private WebPage paginaAnterior;
	public ApuestaModel apuestaM;
	private FeedbackPanel feedbackPanel;
	private String fichasApuesta;
	private String apuestaNombre;
	private String jugadaNombre;
	private String jugadorNombre;
	private Apuesta apuesta;
	private List<OpcionJugada>opciones = new LinkedList<OpcionJugada>();
	
	public ApostarPage(Jugador j,AdjuntarJugadorPage mainPage){
	     paginaAnterior = mainPage;	
	     jugador = j;
	     jugadorNombre = jugador.getNombre();
	     this.apuestaM = new ApuestaModel();
		Form<ApuestaModel> apuestaForm = new Form<ApuestaModel>("apuestaForm",this.createModel());
		this.add(apuestaForm);
		this.addFields(apuestaForm);
		
		
	}
	
	private void addFields(Form<ApuestaModel> form) {
		form.add(new TextField<String>("fichas",new PropertyModel<String>(this, "fichasApuesta")));
		form.add(new FeedbackPanel("feedbackPanel"));		
		ChoiceRenderer choiceRender = new ChoiceRenderer("tipo");
		form.add(new DropDownChoice<ApuestaWeb>("tipoApuesta", new PropertyModel(this, "apuestaNombre"),apuestaM.staticApuestas,choiceRender));
		System.out.println("se aposto" +apuestaNombre);
	
		ChoiceRenderer choiceJugada = new ChoiceRenderer("nombre");
		form.add(new DropDownChoice<OpcionJugada>("jugada", new PropertyModel(this, "jugadaNombre"),opciones,choiceJugada));
		
	}
	
	
	
	
protected CompoundPropertyModel<ApuestaModel> createModel() {
		
		return new CompoundPropertyModel<ApuestaModel>(this.apuestaM);
	}
	
}
