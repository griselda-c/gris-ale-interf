package ruleta;

public class Pleno extends Apuesta{
	
	public static final String OPCIONSELECCIONADA = "opcionSeleccionada";
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADA = "jugada";
	
	public Jugador jugador;
	public int fichas;
	public int jugada;
	public VALOR opcionSeleccionada;

	public Pleno(Jugador unJugador, int fichas, int numero) {
		super(unJugador, fichas, numero);
	}

	public Pleno(Jugador j) {
		super(j);
	}

	public boolean ganaParaNumero(int numero)
	{
		return (this.jugada == numero);
	}

	public int fichasGanadas()
	{
		return ((this.fichas * 36) + 1);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.setProperty(JUGADOR, jugador);
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.setProperty(FICHAS, fichas);
		System.out.println("se setea fichas en " + this.fichas);
	}

	public int getJugada() {
		return jugada;
	}
   
	public void setJugada(int jugada) {
		this.setProperty(JUGADA, jugada);
	}
	
	public VALOR getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(VALOR opcionSeleccionada) {
		this.setProperty(OPCIONSELECCIONADA, opcionSeleccionada);
	}
	
	

}
