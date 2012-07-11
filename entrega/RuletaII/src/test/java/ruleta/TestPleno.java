package ruleta;

import junit.framework.Assert;

import org.junit.Test;

import ruleta.apuestas.OpcionJugada;
import ruleta.apuestas.Pleno;

public class TestPleno {
	
	@Test	
	public void testGanaParaNumero()
	{
		Jugador j= new Jugador(1000, "carlos");
		Pleno apuesta = new Pleno(j);		
		apuesta.setJugadaSeleccionada(new OpcionJugada("10", 10));		
		Integer numeroRuleta1 = 10; // el jugador gana
		Integer numeroRuleta2 = 25; // jugador pierde
		
		Assert.assertTrue(apuesta.ganaParaNumero(numeroRuleta1));
		Assert.assertFalse(apuesta.ganaParaNumero(numeroRuleta2));
	}

}
