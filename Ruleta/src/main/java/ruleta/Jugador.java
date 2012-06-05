package ruleta;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;
import org.uqbar.commons.model.UserException;

public class Jugador extends ObservableObject implements Serializable{
	

	public Mesa mesa;
	public Integer fichas;
	public Integer dinero;
	public Integer fichasMas;
	public String nombre;
	public List<Apuesta> apuestas = new LinkedList<Apuesta>();
	public List<Apuesta> apuestasFake = new LinkedList<Apuesta>();
	public Apuesta selected;


	public final String SELECTED = "selected";
	public final String APUESTAS = "apuestas";
	public static final String NOMBRE = "nombre";
	public static final String DINERO = "dinero";
	public static final String FICHAS = "fichas";
	public static final String MONTOAPUESTA = "montoApuestaActual";
	public static final String FICHASMAS = "fichasMas";
	



	public Jugador(Integer dineroT, String nombreT){
		this.setDinero(dineroT);
		this.setNombre(nombreT);	
		this.setFichas(0);
		/*para comentar
		this.mesa = new Mesa();
		this.apuestasFake.add(new Fila(this));
		this.apuestasFake.add(new Fila(this));
		this.apuestasFake.add(new Fila(this));
		this.apuestasFake.add(new Fila(this));
		this.apuestasFake.add(new Fila(this));
		this.apuestasFake.add(new Fila(this));*/
	}

	public void sumarFichas(Integer cantidad) {
		this.setFichas(this.getFichas() + cantidad);
	}
	
	public void sumarFichas(){
		/* la cantidad de fichas que se suma no puede ser mayor a la cantidad de dinero del jugador */
		if(this.fichasMas > this.getDinero())		{
			throw new UserException("no tiene dinero suficiente para esa cantidad");
		}		
		else{		
			this.sumarFichas(fichasMas);
			this.dinero = (this.dinero - fichasMas) ;
		}
	}

	public void restarFichas(Integer cantidad) {
		if(cantidad > this.getFichas()){
			throw new UserException("cantidad de fichas no valido");
		}
		else{		
			this.setFichas(this.getFichas() - cantidad);
		}
	}

	public Integer unirAMesa(Mesa mesa) {
		this.mesa = mesa;
		Integer fichasTemp = this.getDinero()*80/100;
		this.setFichas(this.getFichas() + fichasTemp);
		this.setDinero(this.getDinero() - fichasTemp);
		return fichasTemp;
	}

	public Apuesta nuevaApuestaPleno() {
		return new Pleno(this);
	}
	public Apuesta nuevaApuestaParImpar() {
		return new ParImpar(this);
	}
	public Apuesta nuevaApuestaFila() {
		return new Fila(this);
	}
	public Apuesta nuevaApuestaColumna() {
		return new Columna(this);
	}

	public void apostar(Apuesta apuesta) {		
		this.getMesa().registrarJugada(apuesta);
		this.apuestas.add(apuesta);	
		this.firePropertyChange(APUESTAS, null, this.apuestas);
	}	
	
	public void borrarApuesta(Apuesta apuesta){
	this.apuestas.remove(apuesta);
	this.firePropertyChange(APUESTAS, null, this.apuestas);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//get & set
	
	public Mesa getMesa() {
		return mesa;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dineroT) {
		this.setFieldValue(DINERO, dineroT);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.setFieldValue(NOMBRE, nombre);
	}
	
	public void setFichas(Integer fichas) {
		this.setFieldValue(FICHAS, fichas);
	}

	public Integer getFichas() {
		return fichas;
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.setFieldValue(APUESTAS, apuestas);
	}

	public Apuesta getSelected() {
		return selected;
	}

	public void setSelected(Apuesta selected) {
		this.setFieldValue(SELECTED, selected);
	}	
	
	public Integer getFichasMas(){
		return this.fichasMas;
	}
	
	public void setFichasMas(Integer fichasMas) {
		this.setFieldValue(FICHASMAS, fichasMas);
	}

	public void sumarDinero(int dinero) {
		this.setDinero(this.getDinero() + dinero);
	}
	
	

}
