package ruleta;

import java.io.Serializable;

public class Ruleta  implements Serializable{
	private static final long serialVersionUID = -1708054528270513829L;

	public int getNumeroGanador()
	{
		int azar = (int) (Math.random()*36);
		return azar;
	}	

}
