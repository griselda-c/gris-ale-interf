package ruleta;

public class Ruleta {
	
	public int getNumeroGanador()
	{
		int azar = (int) (Math.random()*36);
		return azar;
	}
	
	

}
