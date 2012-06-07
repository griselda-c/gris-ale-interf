package griselda.alejandro.ruleta_ui_wk;

import griselda.alejandro.ruleta_ui_wk.ApuestaModel.ApuestaWeb;

import java.io.Serializable;
import java.util.List;

import ruleta.Apuesta;
import ruleta.Columna;
import ruleta.Fila;
import ruleta.OpcionJugada;
import ruleta.ParImpar;
import ruleta.Pleno;

public abstract class ApuestaWeb implements Serializable{
	public Apuesta apuesta = new Columna();
	public String tipo = apuesta.getTipoApuesta();
	public List<OpcionJugada> opciones = apuesta.getOpciones();
	public String getTipoApuesta(){
		return apuesta.getTipoApuesta();
	}		
	public abstract Apuesta create();
}

public class ColumnaWeb extends ApuestaWeb{
	public Apuesta apuesta = new Columna();
	public String tipo = apuesta.getTipoApuesta();
	public List<OpcionJugada> opciones = apuesta.getOpciones();
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
	public List<OpcionJugada> opciones = apuesta.getOpciones();
	public String getTipoApuesta(){
		return apuesta.getTipoApuesta();
	}
	public Apuesta create(){
		return new Fila();
	}
	
}

public static class PlenoWeb extends ApuestaWeb{
	public Apuesta apuesta = new Pleno();
	public List<OpcionJugada> opciones = apuesta.getOpciones();
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
	public List<OpcionJugada> opciones = apuesta.getOpciones();
	public String getTipoApuesta(){
		return apuesta.getTipoApuesta();
	}
	public Apuesta create(){
		return new ParImpar();
	}
	
}

public static Apuesta getApuesta(String apuesta) throws RuntimeException {
    for(ApuestaWeb apuestaTemp: staticApuestas){
    	if(apuestaTemp.getTipoApuesta().equals(apuesta)){
    		System.out.println(" se creo una apuesta "  +apuesta);
    		return apuestaTemp.create();
    	}
    }
    throw new RuntimeException("Se envio como parametro un tipo de apuesta no existente [Apuesta = " + apuesta + "]");
}
