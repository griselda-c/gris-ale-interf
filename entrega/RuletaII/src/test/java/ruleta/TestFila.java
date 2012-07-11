package ruleta;
import junit.framework.Assert;

import org.junit.Test;

import ruleta.apuestas.Fila;
import ruleta.apuestas.OpcionJugada;


public class TestFila {
	
	@Test	
	public void testGanaConNumero(){		
		Jugador jugador= new Jugador(1000, "carlos");
		Fila apuesta = new Fila(jugador);
		apuesta.setJugadaSeleccionada(new OpcionJugada("1", 1));
		int numeroRuleta1 = 1; // el jugador gana
		int numeroRuleta2 = 25; // jugador pierde		
		Assert.assertTrue(apuesta.ganaParaNumero(numeroRuleta1));
		Assert.assertFalse(apuesta.ganaParaNumero(numeroRuleta2));		
	}
}
