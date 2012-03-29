package ruleta;

public class Ruleta {
	
	public int getNumeroGanador()
	{
		int azar = ((int) (Math.random()*37))- 1;
		return azar;
	}
	
	

}
