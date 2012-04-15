package ruleta;

public class Pleno extends Apuesta{
	
	

	public Pleno(Jugador unJugador, int fichas, int numero) {
		super(unJugador, fichas, numero);
		// TODO Auto-generated constructor stub
	}
	
	public Pleno(int fichas, int numero)
	{
		super();
		this.setFichas(fichas);
		this.setJugada(numero);
	}

	public boolean ganaParaNumero(int numero)
	{
		return this.jugada == numero;
	}
	
	public int fichasGanadas()
	{
		return (this.fichas * 36) + 1;
		
	}
	

}
