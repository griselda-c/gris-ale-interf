package ruleta;

import org.junit.Test;

import junit.framework.Assert;


public class TestParImpar {
	
	@Test
	public void ganaParaNumeroTest(){
		Jugador jugador = new Jugador(30, "carlos");
		ParImpar jugada = new ParImpar(jugador, 30, 3);
		Assert.assertTrue(jugada.ganaParaNumero(17));
		Assert.assertTrue(jugada.ganaParaNumero(3));
		Assert.assertFalse(jugada.ganaParaNumero(20));
		Assert.assertFalse(jugada.ganaParaNumero(10));		
	}

}
