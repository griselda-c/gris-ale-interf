package ruleta;

import junit.framework.Assert;

import org.junit.Test;

public class TestColumna {

		@Test
		public void ganaParaNumeroTest() {
			Jugador jugador = new Jugador();
			Columna columna = null;
			try { columna = new Columna(jugador, 30, 3);}
			catch (Exception e) {e.printStackTrace();}
			Assert.assertTrue(columna.ganaParaNumero(6));
			Assert.assertTrue(columna.ganaParaNumero(3));
			Assert.assertTrue(columna.ganaParaNumero(9));
			Assert.assertFalse(columna.ganaParaNumero(20));
			Assert.assertFalse(columna.ganaParaNumero(10));	
			
			columna.setJugada(5);
			Assert.assertTrue(columna.ganaParaNumero(8));
			Assert.assertTrue(columna.ganaParaNumero(2));
			Assert.assertFalse(columna.ganaParaNumero(19));
			Assert.assertFalse(columna.ganaParaNumero(10));	
			
		}

}
