package ruleta;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ColumnBuilder;
import org.uqbar.lacar.ui.model.ControlBuilder;

import com.uqbar.commons.collections.Closure;


public class JugadorWindow extends Window<Jugador>{

	public JugadorWindow(WindowOwner owner, Jugador model) {
		super(owner, model);
	}

	private static final long serialVersionUID = 1L;

	public void createContents(Panel mainPanel) {

		
		mainPanel.setLayout(new VerticalLayout());
		
		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, haga sus apuestas:");
		
		Panel columnas = new Panel(mainPanel);
		columnas.setLayout(new ColumnLayout(2));
		
		Panel grid = new Panel(columnas);
		grid.setLayout(new ColumnLayout(1));
		
		Label sGrid = new Label(grid);
		sGrid.setText("Mesa CIU");
				
		Table<Apuesta> table = new Table<Apuesta>(grid, Apuesta.class);
		table.bindContentsToProperty(this.getModel().APUESTAS);
		table.bindSelection(this.getModel().SELECTED);

		this.describeResultsGrid(table);
		
		Panel datosOpciones = new Panel(columnas);
		datosOpciones.setLayout(new ColumnLayout(1));

		Label nombreLabel = new Label(datosOpciones);
		nombreLabel.setText("Hola");

		Label nombreJugador = new Label(datosOpciones);
		nombreJugador.bindValueToProperty(Jugador.NOMBRE);

		Label dineroLabel = new Label(datosOpciones);
		dineroLabel.setText("Cantidad de fichas:");

		Label dineroJugador = new Label(datosOpciones);
		dineroJugador.bindValueToProperty(Jugador.FICHAS);
		
		Label ask = new Label(datosOpciones);
		ask.setText("¿Qué desea hacer?");		
		
		Button apostar = new Button(datosOpciones);
		apostar.setCaption("Apostar");
		apostar.onClick(new MessageSend(this, "apostar"));
		
		Button cambiar = new Button(datosOpciones);
		cambiar.setCaption("Cambiar fichas");
		cambiar.onClick(new MessageSend(this, "cambioDeFichas"));
		
		Button ruleta = new Button(grid);
		ruleta.setCaption("No va mas");
		ruleta.onClick(new MessageSend(this,"noVaMas"));				
	}
	
	private void describeResultsGrid(Table<Apuesta> table) {
		Column<Apuesta> tipoColumn = new Column<Apuesta>(table);
		tipoColumn.setTitle("Tipo");
		tipoColumn.setFixedSize(100);
		tipoColumn.bindContentsToProperty(Apuesta.TIPO);

		Column<Apuesta> fichasColumn = new Column<Apuesta>(table);
		fichasColumn.setTitle("Fichas");
		fichasColumn.setFixedSize(100);
		fichasColumn.bindContentsToProperty(Apuesta.FICHAS);
		
	}
	
	public void apostar(){
		new ElegirApuestaWindow(this, this.getModel()).open();
	}
	
	public void cambioDeFichas(){	
		new CambioFichasWindow(this, this.getModel()).open();		
	}
	
	public void noVaMas(){		
		Mesa mesa = this.getModel().getMesa();
		new RuletaW(this,mesa).open();		
		//this.close();		
	}
	
}

