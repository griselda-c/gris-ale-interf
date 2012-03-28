package ruleta;

import junit.framework.Assert;

import org.junit.Test;


public class Testmesa {
	
	@Test
	public void agregarJugadorTest(){
		Mesa ruleta = new Mesa(20);
		Jugador jugador1 = new Jugador(10);
		Jugador jugador2 = new Jugador(33);
		Jugador jugador1Prima = ruleta.unirJugador(jugador1);
		Assert.assertEquals(jugador1Prima, jugador1);
		Assert.assertTrue(jugador1.getDinero() == 2);
		Assert.assertTrue(jugador1.getFichas() == 8);
		Jugador jugador2Prima = ruleta.unirJugador(jugador2);
		Assert.assertEquals(jugador2Prima, jugador2);
		Assert.assertTrue(jugador2.getDinero() == 7);
		Assert.assertTrue(jugador2.getFichas() == 26);		
		
	}
	

}
