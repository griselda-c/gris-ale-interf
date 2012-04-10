package ruleta;
import org.junit.Test;

import junit.framework.Assert;


public class TestFila {
	
	@Test	
	public void testGanaConNumero(){
		
		Jugador j= new Jugador(1000, "carlos");
		Fila f = new Fila(j , 2 , 18);
		int numeroRuleta1 = 18; // el jugador gana
		int numeroRuleta2 = 25; // jugador pierde
		
		Assert.assertTrue(f.ganaParaNumero(numeroRuleta1));
		Assert.assertFalse(f.ganaParaNumero(numeroRuleta2));
		
		
	}
	
	
	
	
	

}
