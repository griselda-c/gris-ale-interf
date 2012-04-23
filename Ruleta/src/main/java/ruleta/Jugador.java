package ruleta;

import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.ObservableObject;
import org.uqbar.commons.model.UserException;

public class Jugador extends ObservableObject{
	
	private int fichas;
	int dinero;
	int fichasMas;
	private Mesa mesa;
	String nombre;
	public List<Apuesta> apuestas = new LinkedList<Apuesta>();
	public Apuesta selected;


	public final String SELECTED = "selected";
	public final String APUESTAS = "apuestas";
	public static final String NOMBRE = "nombre";
	public static final String DINERO = "dinero";
	public static final String FICHAS = "fichas";
	public static final String MONTOAPUESTA = "montoApuestaActual";
	public static final String FICHASMAS = "fichasMas";
	
	public Mesa getMesa() {
		return mesa;
	}



	public Jugador(int dineroT, String nombreT){
		this.setDinero(dineroT);
		this.setNombre(nombreT);		
		/*para comentar*/
		this.mesa = new Mesa();
		this.apuestas.add(new Pleno(this));
		this.apuestas.add(new ParImpar(this));
		this.apuestas.add(new Fila(this));
	}

	public void sumarFichas(int cantidad) {
		this.setFichas(this.getFichas() + cantidad);
	}
	
	public void sumarFichas(){
		/* la cantidad de fichas que se suma
		   no puede ser mayor a la cantidad de dinero
		   del jugador
		*/
		
		if(this.fichasMas > this.getDinero())
		{
			throw new UserException("no tiene dinero suficiente para esa cantidad");
		}
		
		else{
		
		this.sumarFichas(fichasMas);
		this.dinero = (this.dinero - fichasMas) ;
		}
	}

	public void restarFichas(int cantidad) {
		this.setFichas(this.getFichas() - cantidad);
	}

	public int unirAMesa(Mesa mesa) {
		this.mesa = mesa;
		int fichasTemp = dinero*80/100;
		this.fichas += fichasTemp;
		this.dinero -= fichasTemp;		
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
	
	public void borrarApuestas(Apuesta apuesta){
	this.apuestas.remove(apuesta);
	this.firePropertyChange(APUESTAS, null, this.apuestas);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//get & set
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dineroT) {
		this.setProperty(DINERO, dineroT);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.setProperty(NOMBRE, nombre);
	}
	
	public void setFichas(int fichas) {
		this.setProperty(FICHAS, fichas);
	}

	public int getFichas() {
		return fichas;
	}

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.setProperty(APUESTAS, apuestas);
	}

	public Apuesta getSelected() {
		return selected;
	}

	public void setSelected(Apuesta selected) {
		this.setProperty(SELECTED, selected);
	}	
	
	public int getFichasMas(){
		return this.fichasMas;
	}
	
	public void setFichasMas(int cantidad){
       this.setProperty(FICHASMAS, cantidad);
		
	}

}
