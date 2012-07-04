package ruleta;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class RuletaApplication implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private RuletaApplication  instance;
private List<JugadorPartida>jugadores = new LinkedList<JugadorPartida>();
private Mesa actual;
	
public  RuletaApplication getInstance(){

	if(instance == null){
		instance = new RuletaApplication();
	}
	return instance;
	
	
}

public boolean existeJugador(Jugador j){
	boolean res = false;
	for(JugadorPartida jugador:jugadores){
		if(jugador.getJugador()==j){
			res = true;
		}
	}
	return res;
}

private synchronized Mesa getMesaActual(){
	if(actual==null){
		actual = new Mesa(6500);
	}
	else if(actual.getMesaCerrada()){
		actual = new Mesa(6500);
	}
	return actual;
}

private Mesa getMesaJugador(Jugador j){
   Mesa res = null;	

	for(JugadorPartida jugador:jugadores){
		if(jugador.getJugador()==j){
			res = jugador.getMesa();
			System.out.println("mesa jugador " +jugador.getJugador().getNombre() + jugador.getMesa());
		}
   }
	return res;
}

public synchronized Mesa getMesa(Jugador j){
	Mesa mesa = null;
	if(existeJugador(j)){
		mesa= getMesaJugador(j);
	}
	else{
		mesa = getMesaActual();
		jugadores.add(new JugadorPartida(j, this.getMesaActual()));
	}
	return mesa;
}

public void cambiarMesa(Jugador j){
	for(JugadorPartida jp:jugadores){
		if(jp.getJugador() == j){
			System.out.println("era mesa " + this.getMesaJugador(jp.getJugador()));
			getMesaActual().unir(jp.getJugador());
			jp.setMesa(getMesaActual());
			jp.getJugador().borrarApuestas();
			System.out.println("es mesa " + this.getMesaJugador(jp.getJugador()));
		}
		
	}
}




}
