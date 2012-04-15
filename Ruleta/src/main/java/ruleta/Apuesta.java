package ruleta;

// quito todos los metodos observableObject
abstract class Apuesta{
	
	protected Jugador jugador;
	protected int fichas;
	protected int jugada;
	
	//variables
	
	public static final String JUGADOR = "jugador";
	public static final String FICHAS = "fichas";
	public static final String JUGADA = "jugada";
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public int getJugada() {
		return jugada;
	}
   
	public void setJugada(int jugada) {
		this.jugada = jugada;
	}




	public Apuesta(Jugador unJugador, int fichas, int numero){

		
		if(jugada > 36 | jugada < 0){
			throw new RuntimeException("Digito de apuesta fuera de rango de ruleta");
		}
		
		this.jugador = unJugador;
		this.fichas = fichas;
		this.jugada = numero;
	}
	
	public Apuesta() {
		// TODO Auto-generated constructor stub
	}

	abstract boolean ganaParaNumero(int numero);
	abstract int fichasGanadas();
	
	

}
