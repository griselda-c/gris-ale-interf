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
		jugador1 = new Jugador(10, "carlos");
		jugador2 = new Jugador(33, "carlos");
		ruleta.unirJugador(jugador1);
		Assert.assertTrue(jugador1.getDinero() == 2);
		Assert.assertTrue(jugador1.getFichas() == 8);
		ruleta.unirJugador(jugador2);
		Assert.assertEquals(7, jugador2.getDinero());
		Assert.assertTrue(jugador2.getFichas() == 26);		
		
	}

	@Test
	public void pagarApuesta(){
		jugador1 = new Jugador(10, "carlos");
		jugador2 = new Jugador(33, "carlos");
		
		/*Apuesta apuestaJugada = new ParImpar(jugador1, 5, 1);
		ruleta.registrarJugada(apuestaJugada);
		ruleta.setNumeroGanador(1);
		ruleta.pagarApuestas();
		System.out.println(jugador1.getFichas());
		Assert.assertEquals(jugador1.getFichas(), 6);*/
		
	}
	

}
