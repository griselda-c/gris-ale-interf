package griselda.alejandro.ruleta_ui_wicket;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

public class Styler {
	

	
	public static IModel<String> setRedColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
			public String getObject() {
				return "color: red;";
			}
		};
		return colorModel;
	}
	
	public static IModel<String> setWhiteColor() {
		IModel<String> colorModel = new AbstractReadOnlyModel<String>() {
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
