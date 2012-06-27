package griselda.alejandro.ruleta_ui_wicket;

import java.util.LinkedList;
import java.util.List;
import ruleta.Apuesta;


public class Partida {
	
	public SlotApuestas slotsApuestas[];
	
	public Integer resultadoPartida;
	
	public List<JugadorModel> jugadoresModel;
	
	public Partida(){
		this.slotsApuestas = new SlotApuestas[39];
		this.inicializarSlots(slotsApuestas);
		this.resultadoPartida = null;
		this.jugadoresModel = new LinkedList<JugadorModel>();
	}
	
    public void inicializarSlots(SlotApuestas[] slotArray) {
		for (int i = 0; i < slotArray.length; i++) {
			slotArray[i] = new SlotApuestas();
		}		
	}
	
	public class SlotApuestas {		
		public List<Apuesta> apuestasSlot;
		public SlotApuestas(){
			this.apuestasSlot = new LinkedList<Apuesta>();
		}
	}

}
