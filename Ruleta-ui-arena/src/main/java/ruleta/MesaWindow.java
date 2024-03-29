package ruleta;



import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;



public class MesaWindow extends Window<Mesa>{
	
	public MesaWindow(WindowOwner owner, Mesa model) {
		super(owner, model);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void createContents(Panel mainPanel) {
		this.setTitle("Ruleta el Ocho");		
		mainPanel.setLayout(new VerticalLayout());
						
		Panel mainFrame = new Panel(mainPanel);
		mainFrame.setLayout(new ColumnLayout(2));
		
		Panel estadoMesa = new Panel(mainFrame);
		estadoMesa.setLayout(new VerticalLayout());
		
		Panel infoMesa = new Panel(estadoMesa);
		estadoMesa.setLayout(new VerticalLayout());	
		
		Panel fixinfoMesa1 = new Panel(infoMesa);
		fixinfoMesa1.setLayout(new HorizontalLayout());
		
		new Label(fixinfoMesa1).setText("Banca $ ");
		new Label(fixinfoMesa1).bindValueToProperty(Mesa.BANCA);
		
		Panel fixinfoMesa2 = new Panel(infoMesa);
		fixinfoMesa2.setLayout(new ColumnLayout(2));
		
		new Label(fixinfoMesa2).setText("Número ganador ");
		new Label(fixinfoMesa2).bindValueToProperty(Mesa.NUMEROGANADOR);
		
		
		Table<Jugador> table = new Table<Jugador>(estadoMesa, Jugador.class);
		table.bindContentsToProperty(this.getModel().JUGADORES);
		table.bindSelection(this.getModel().SELECTED);
		this.describeResultsGrid(table);
		
		Panel actionFrame = new Panel(estadoMesa);
		actionFrame.setLayout(new ColumnLayout(3));
		
		Button retirar = new Button(actionFrame);
		retirar.setCaption("Retirar");
		retirar.onClick(new MessageSend(this, "retirarJugador"));
		
		Button apostar = new Button(actionFrame);
		apostar.setCaption("Apostar");
		apostar.onClick(new MessageSend(this, "apostar"));
		
		Button ruleta = new Button(actionFrame);
		ruleta.setCaption("No va mas");
		ruleta.onClick(new MessageSend(this,"noVaMas"));	
		
		Panel nuevoJugador = new Panel(mainFrame);
		nuevoJugador.setLayout(new ColumnLayout(1));

		Label subtituloA = new Label(nuevoJugador);
		subtituloA.setText("Bienvenido a la mesa, ");
		Label subtituloB = new Label(nuevoJugador);
		subtituloB.setText("ingrese sus datos para unirse:");
		
		Panel nombreDinero = new Panel(nuevoJugador);
		nombreDinero.setLayout(new ColumnLayout(2));		
		
		Label nombreLabel = new Label(nombreDinero);
		nombreLabel.setText("Nombre:");

		TextBox nombreJugador = new TextBox(nombreDinero);
		nombreJugador.bindValueToProperty(Mesa.NOMBREJUGADOR);

		Label dineroLabel = new Label(nombreDinero);
		dineroLabel.setText("Dinero:");		
		
		TextBox dineroJugador = new TextBox(nombreDinero);
		dineroJugador.bindValueToProperty(Mesa.DINEROJUGADOR);

		Button unirse = new Button(nuevoJugador);
		unirse.setCaption("Unirse");
		unirse.onClick(new MessageSend(this, "unirJugador"));
		
	}
	
	
	protected void describeResultsGrid(Table<Jugador> table) {
		Column<Jugador> nombreColumn = new Column<Jugador>(table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setFixedSize(100);
		nombreColumn.bindContentsToProperty(Jugador.NOMBRE);
		// table.add(column);

		Column<Jugador> fichasColumn = new Column<Jugador>(table);
		fichasColumn.setTitle("Fichas");
		fichasColumn.setFixedSize(100);
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
		jugador.setMesa(this.getModel());
	}
	
	public void retirarJugador(){
		Jugador jugador = this.getModel().getJugadorActual();
		this.getModel().retirarJugador();
		this.mostrarConfirmacion(jugador);
	}
	
	public void apostar(){
		Jugador jugador = this.getModel().getJugadorActual();
		new JugadorWindow(this, jugador).open();
	}


	private void mostrarConfirmacion(Jugador jugador) {
		new RetirarseWindow(this, jugador).open();	
		
	}
	
	public void noVaMas(){		
		this.getModel().girarRuleta();	
		//new RuletaW(this,mesa).open();		
		//this.close();		
	}





}

