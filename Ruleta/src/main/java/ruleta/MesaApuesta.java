package ruleta;

public class MesaApuesta extends Mesa{
	
	public MesaApuesta(int numero)
	{
		super(numero);
	}
	
	//unir Jugada
	int fichasJugada;
	int numero = 0;
	Jugador jugadorActual;
	Apuesta apuestaActual;

	public static final String JUGADORACTUAL = "jugadorActual";
	public static final String FICHASJUGADA = "fichasJugada";
	public static final String NUMERO = "numero";
	public static final String APOSTARPLENO = "apostarPleno";
	public static final String APUESTAACTUAL = "apuestaActual";
	////
	
//getter and setter Apuesta
	
	public int getFichasJugada(){
		return this.fichasJugada;
	}
	
	public void setFichasJugada(int fichaJugadaT){
		this.setProperty(FICHASJUGADA, fichaJugadaT);
	}
	
	public Apuesta getApuestaActual(){
		return this.apuestaActual;
		
	}
	
	public void setApuestaActual(Apuesta apuestaActualT){
		
		this.setProperty(APUESTAACTUAL, apuestaActualT);
	}
	
	public int getNumero(){
		
	  return this.numero;
	}
	
	public void setNumeroApuesta(int numeroT){
		this.setProperty(NUMERO, numeroT);
	}
	
	public Jugador getJugadorActual(){
		return this.jugadorActual;
	}
	
	public void setJugadorActual(Jugador j){
		this.setProperty(JUGADORACTUAL, j);
		
	}
	
	
	//////////////////////////
	//metodos apostar pleno
	
	public void apostarPleno(){
		
		//pequeña trampa
		Jugador jugadorActual = new Jugador(1000,"Mario");
	    Pleno apuesta =  new Pleno(jugadorActual,this.fichasJugada, this.numero);
		this.registrarJugada(apuesta);
		this.setApuestaActual(apuesta);
		
	}
	
	public void apostarColumna(){
		
		//pequeña trampa
		Jugador jugadorActual = new Jugador(1000,"Mario");
	    Columna apuesta =  new Columna(jugadorActual,this.fichasJugada, this.numero);
		this.registrarJugada(apuesta);
		this.setApuestaActual(apuesta);
		
	}

public void apostarFila(){
	
	//pequeña trampa
	Jugador jugadorActual = new Jugador(1000,"Mario");
    Fila apuesta =  new Fila(jugadorActual,this.fichasJugada, this.numero);
	this.registrarJugada(apuesta);
	this.setApuestaActual(apuesta);
	
}

public void apostarParImpar(){
	
	//pequeña trampa
	Jugador jugadorActual = new Jugador(1000,"Mario");
    ParImpar apuesta =  new ParImpar(jugadorActual,this.fichasJugada, this.numero);
	this.registrarJugada(apuesta);
	this.setApuestaActual(apuesta);
	
}

	
	///


}
