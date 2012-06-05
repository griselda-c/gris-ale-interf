package ruleta;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Ruleta implements Serializable {
	
	public int getNumeroGanador()
	{
		int azar = (int) (Math.random()*36);
		return azar;
	}

	public static List<Apuesta> getApuestas() {
		List<Apuesta> apuestas = new LinkedList<Apuesta>();
		apuestas.add(new Columna());
		apuestas.add(new Fila());
		apuestas.add(new Pleno());
		apuestas.add(new ParImpar());
		return apuestas;
	}
	
	

}
