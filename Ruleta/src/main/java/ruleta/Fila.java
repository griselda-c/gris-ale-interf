package ruleta;

public class Fila extends Apuesta{	
	
	
	public Fila(Jugador unJugador, int fichas, int numero) {
		super(unJugador, fichas, numero);
		// TODO Auto-generated constructor stub
	}

	public Fila(Jugador j) {
		super(j);
	}

	public boolean ganaParaNumero(int numero)
	{
		int filaSalio = calcularFila(numero);
		
		return filaSalio ==  this.calcularFila(this.jugada);// numero equivale a una fila 
		
	}
	
	private int calcularFila(int numero)
	{
		int fila;
		if(numero % 3 == 0)
		{
			fila = (numero / 3) - 1;
		}
		else
		{
			fila = numero / 3 ;
		}
		
		return fila;
	}
	
	
	public int fichasGanadas(){
		
		return 12 * this.fichas;
		
	}
	

}
