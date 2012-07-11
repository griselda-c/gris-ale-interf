package ruleta;

import junit.framework.Assert;

import org.junit.Test;

import ruleta.apuestas.Columna;
import ruleta.apuestas.OpcionJugada;

public class TestColumna {

		@Test
		public void ganaParaNumeroTest() {
			Jugador jugador = new Jugador(40, "carlos");
			Columna apuesta = new Columna(jugador);
			
			//columna.setJugada(1);			
			apuesta.setJugadaSeleccionada(new OpcionJugada("3", 3));
			
			Assert.assertTrue(apuesta.ganaParaNumero(6));
			Assert.assertTrue(apuesta.ganaParaNumero(3));
			Assert.assertTrue(apuesta.ganaParaNumero(9));
			Assert.assertFalse(apuesta.ganaParaNumero(20));
			Assert.assertFalse(apuesta.ganaParaNumero(10));	
			
			//columna.setJugada(5);
			apuesta.setJugadaSeleccionada(new OpcionJugada("2", 2));	
			Assert.assertTrue(apuesta.ganaParaNumero(8));
			Assert.assertTrue(apuesta.ganaParaNumero(2));
			Assert.assertFalse(apuesta.ganaParaNumero(19));
			Assert.assertFalse(apuesta.ganaParaNumero(10));
			
		}

}
