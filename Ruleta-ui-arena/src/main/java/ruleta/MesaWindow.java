package ruleta;



import java.text.SimpleDateFormat;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


import com.uqbar.commons.collections.Transformer;



public class MesaWindow extends Window<Mesa>{
	
	public MesaWindow(WindowOwner owner, Mesa model) {
		super(owner, model);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void createContents(Panel mainPanel) {
		//this.setTitle("Ruleta el Ocho");
		
		mainPanel.setLayout(new VerticalLayout());


		Label subtitulo = new Label(mainPanel);
		subtitulo.setText("Bienvenido a la mesa, ingrese sus datos para unirse:");

		//panel horizantal x2
		
		Panel mainFrame = new Panel(mainPanel);
		mainFrame.setLayout(new ColumnLayout(2));
		
		Table<Jugador> table = new Table<Jugador>(mainFrame, Jugador.class);

		table.bindContentsToProperty(this.getModel().JUGADORES);
		table.bindSelection(this.getModel().SELECTED);

		this.describeResultsGrid(table);
		
		

		Panel nombreDinero = new Panel(mainFrame);
		nombreDinero.setLayout(new ColumnLayout(2));

		Label nombreLabel = new Label(nombreDinero);
		nombreLabel.setText("Nombre:");

		TextBox nombreJugador = new TextBox(nombreDinero);
		nombreJugador.bindValueToProperty(Mesa.NOMBREJUGADOR);

		Label dineroLabel = new Label(nombreDinero);
		dineroLabel.setText("Dinero:");

		TextBox dineroJugador = new TextBox(nombreDinero);
		dineroJugador.bindValueToProperty(Mesa.DINEROJUGADOR);
		

		Button unirse = new Button(mainPanel);
		unirse.setCaption("Unirse");
		unirse.onClick(new MessageSend(this, "unirJugador"));
		
		
	
	}
	
	
	protected void describeResultsGrid(Table<Jugador> table) {
		Column<Jugador> nombreColumn = new Column<Jugador>(table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setPreferredSize(100);
		nombreColumn.bindContentsToProperty(Jugador.NOMBRE);
		// table.add(column);

		Column<Jugador> fichasColumn = new Column<Jugador>(table);
		fichasColumn.setTitle("Fichas");
		fichasColumn.setPreferredSize(100);
		fichasColumn.bindContentsToProperty(Jugador.FICHAS);
		/*Column<Jugador> ingresoColumn = new Column<Jugador>(table);
		ingresoColumn.setTitle("Fecha de ingreso");
		ingresoColumn.setPreferredSize(100);
		ingresoColumn.bindContentsToTransformer(new Transformer<Jugador, String>() {
			@Override
			public String transform(Jugador jugador) {
				return new SimpleDateFormat("dd/MM/yyyy").format(Jugador.getFecha());
			}
		});

		Column<Jugador> direccionColumn = new Column<Jugador>(table);
		direccionColumn.setTitle("Direccion");
		direccionColumn.setPreferredSize(200);
		direccionColumn.bindContentsToProperty(Jugador.DIRECCION);*/
	}


	public void unirJugador() {
		this.getModel().unirJugadorActual();
		Jugador jugador = this.getModel().getJugadorActual();
		//this.getModel().anularJugadorActual();
		
		jugador.setMesa(this.getModel());
		new JugadorWindow(this, jugador).open();
	}
	
	public void retirarJugador(Jugador jugador){
		this.getModel().retirarJugador(jugador);
		this.mostrarConfirmacion(jugador);
	}


	private void mostrarConfirmacion(Jugador jugador) {
		// TODO Auto-generated method stub
	
		new RetirarseWindow(this,jugador).open();
		
	}





}
