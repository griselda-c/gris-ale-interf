package ruleta;

public class Fila extends Apuesta{	
	
	
	public Fila(Jugador unJugador, int fichas, int numero) {
		super(unJugador, fichas, numero);
		// TODO Auto-generated constructor stub
	}

	public boolean ganaParaNumero(int numero)
	{
		int filaSalio = calcularFila(numero);
		
		return filaSalio == this.jugada;// numero equivale a una fila 
		
	}
	
	public int calcularFila(int numero)
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
