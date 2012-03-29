package ruleta;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class Testmesa {

	Jugador jugador1;
	Jugador jugador2;
	Mesa ruleta;
	
	
	@Before
	public void setUp(){
		ruleta = new Mesa(800);
		
	}
	
	@Test
	public void agregarJugadorTest(){
		jugador1 = new Jugador(10);
		jugador2 = new Jugador(33);
		Jugador jugador1Prima = ruleta.unirJugador(jugador1);
		Assert.assertEquals(jugador1Prima, jugador1);
		Assert.assertTrue(jugador1.getDinero() == 2);
		Assert.assertTrue(jugador1.getFichas() == 8);
		Jugador jugador2Prima = ruleta.unirJugador(jugador2);
		Assert.assertEquals(jugador2Prima, jugador2);
		Assert.assertTrue(jugador2.getDinero() == 7);
		Assert.assertTrue(jugador2.getFichas() == 26);		
		
	}

	@Test
	public void pagarApuesta(){
		jugador1 = new Jugador(10);
		jugador2 = new Jugador(33);
		
	}
	

}
