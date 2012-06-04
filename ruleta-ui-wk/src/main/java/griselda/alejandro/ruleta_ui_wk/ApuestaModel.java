package griselda.alejandro.ruleta_ui_wk;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.ParImpar;
import ruleta.Pleno;



public class ApuestaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static List<ApuestaWeb> staticApuestas = getApuestas();
	public static List<String> tipoApuestas = getTipoApuestas();
	
	public ApuestaModel(){
		
	}
	
	
	private static List<ApuestaWeb> getApuestas() {
		List<ApuestaWeb> apuestas = new LinkedList<ApuestaWeb>();
		apuestas.add(new ColumnaWeb());
		apuestas.add(new FilaWeb());
		apuestas.add(new PlenoWeb());
		apuestas.add(new ParImparWeb());
		return apuestas;
	}
	
	private static List<String> getTipoApuestas(){
		List<String> tipoApuestas = new LinkedList<String>();
		for(ApuestaWeb aw: staticApuestas){
			tipoApuestas.add(aw.getTipoApuesta());
		}
		return tipoApuestas;
	}
	
	public static abstract class ApuestaWeb{
		public Apuesta apuesta = new Columna();
		public String tipo = apuesta.getTipoApuesta();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}		
		public abstract Apuesta create();
	}
	
	public static class ColumnaWeb extends ApuestaWeb{
		public Apuesta apuesta = new Columna();
		public String tipo = apuesta.getTipoApuesta();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Columna();
		}
		
	}
	
	public static class FilaWeb extends ApuestaWeb{
		public Apuesta apuesta = new Fila();
		public String tipo = apuesta.getTipoApuesta();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Fila();
		}
		
	}
	
	public static class PlenoWeb extends ApuestaWeb{
		public Apuesta apuesta = new Pleno();
		public String tipo = apuesta.getTipoApuesta();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new Pleno();
		}
		
	}
	
	public static class ParImparWeb extends ApuestaWeb{
		public Apuesta apuesta = new ParImpar();
		public String tipo = apuesta.getTipoApuesta();
		public String getTipoApuesta(){
			return apuesta.getTipoApuesta();
		}
		public Apuesta create(){
			return new ParImpar();
		}
		
	}
	
	
	
	

}
