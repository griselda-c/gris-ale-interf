package griselda.alejandro.ruleta_ui_wicket.extras;

import java.io.Serializable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

public class Styler  implements Serializable{
	private static final long serialVersionUID = -3898115578951084257L;

	public static IModel<String> setRedColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = -222550028286190189L;

			public String getObject() {
				return "color: red;";
			}
		};
		return colorModel;
	}
	
	public static IModel<String> setWhiteColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 8620440809070175770L;

			public String getObject() {
				return "color: white;";
			}
		};
		return colorModel;
	}

	public static void setErrorFeedback(Component feedback) {
		feedback.add(new AttributeModifier("style", setRedColor()));		
	}

	public static void setOkFeedback(Component feedback) {		
		feedback.add(new AttributeModifier("style", setWhiteColor()));	
		
	}

}
