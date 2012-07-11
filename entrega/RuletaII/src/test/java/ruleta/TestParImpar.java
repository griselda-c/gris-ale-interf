package ruleta;

import junit.framework.Assert;

import org.junit.Test;

import ruleta.apuestas.OpcionJugada;
import ruleta.apuestas.ParImpar;


public class TestParImpar {
	
	@Test
	public void ganaParaNumeroTest(){
		Jugador jugador = new Jugador(30, "carlos");
		ParImpar apuesta = new ParImpar(jugador);
		apuesta.setJugadaSeleccionada(new OpcionJugada("Impar", 37));		
		Assert.assertTrue(apuesta.ganaParaNumero(17));
		Assert.assertTrue(apuesta.ganaParaNumero(3));
		Assert.assertFalse(apuesta.ganaParaNumero(20));
		Assert.assertFalse(apuesta.ganaParaNumero(10));		
	}

}
