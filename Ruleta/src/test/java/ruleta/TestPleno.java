package ruleta;

import junit.framework.Assert;

import org.junit.Test;

public class TestPleno {
	
	@Test
	
	public void testGanaParaNumero()
	{
		Jugador j= new Jugador(1000);
		Pleno p = new Pleno(j , 2 , 18);
		int numeroRuleta1 = 18; // el jugador gana
		int numeroRuleta2 = 25; // jugador pierde
		
		Assert.assertTrue(p.ganaParaNumero(numeroRuleta1));
		Assert.assertFalse(p.ganaParaNumero(numeroRuleta2));
	}

}
