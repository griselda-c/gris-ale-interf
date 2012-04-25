package ruleta;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

public class RuletaApplication extends Application{

	@Override
	protected Window<Mesa> createMainWindow() {
		return new MesaWindow(this, new Mesa(10000));
	}

	public static void main(String[] args)  {
		new RuletaApplication().start();
	}
}
