package griselda.alejandro.ruleta_ui_wicket;

import ruleta.Apuesta;

public class ApuestaAnteriorModel {
	
	public Apuesta apuesta;
	public Integer numeroGanador;

	public ApuestaAnteriorModel(Apuesta apuesta, Integer numeroGanador){
		this.apuesta = apuesta;
		this.numeroGanador = numeroGanador;		
	}
	
	public String getTipoApuesta() {
		return apuesta.getTipoApuesta();
	}
	public String getJugada() {
		return apuesta.getJugadaSeleccionada().getNombre();
	}
	public String getApostadas() {
		return String.valueOf(apuesta.getFichas());
	}
	public String getGanadas() {
		if(apuesta.ganaParaNumero(numeroGanador)){
			return String.valueOf(apuesta.fichasGanadas());
		}
		return "0";
	}
	
	
}
