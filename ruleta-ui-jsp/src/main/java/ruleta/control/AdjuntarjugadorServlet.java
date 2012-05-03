package ruleta.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Jugador;
import ruleta.Mesa;


public class AdjuntarjugadorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, //
			HttpServletResponse response) //
			throws ServletException, IOException {
		
		String nombreJugadorS = request.getParameter("nombreJugador");
		String dineroJugadorS = request.getParameter("dineroJugador");
		
		
		if(!datosCorrectos(nombreJugadorS, dineroJugadorS)){
			request.setAttribute("error", "Los datos ingresados son incorrectos, intentelo nuevamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
		else{

			// Adaptar lo que la vista nos da para que el negocio lo reciba
			String nombreJugador = nombreJugadorS;
			Integer dineroJugador = Integer.parseInt(dineroJugadorS);


			// Manejar el estado --> usamos como contenedor el scope request
			//request.setAttribute("resultado", resultado);
		
			if(getServletContext().getAttribute("mesa") == null){
				getServletContext().setAttribute("mesa", new Mesa(1000));
			}
		
			Mesa mesaGlobal = (Mesa) getServletContext().getAttribute("mesa");
		
			Jugador jugadorActual = new Jugador(dineroJugador, nombreJugador);
		
			mesaGlobal.unirJugador(jugadorActual);

			request.getSession().setAttribute("jugador", jugadorActual);
			//request.setAttribute("jugador", new Jugador(dineroJugador, nombreJugador));
			// Manejar la navegación, forwardeando el pedido al jsp con
			// el resultado generado
			request //
			.getRequestDispatcher("ruleta.jsp").forward(request, response);
		}
	}

	private boolean datosCorrectos(String nombreJugadorS, String dineroJugadorS) {
		return (isText(nombreJugadorS) & isNumber(dineroJugadorS));
	}

	private boolean isNumber(String dineroJugadorS) {
		try{
			Integer.parseInt(dineroJugadorS);
		} catch(NumberFormatException nfe) {
			return false;
		}
			return true;
	}

	private boolean isText(String nombreJugadorS) {
		for (int i = 0; i < nombreJugadorS.length(); i++) {
			 if ((nombreJugadorS.charAt(i) < 'A') || (nombreJugadorS.charAt(i) > 'z') || ((nombreJugadorS.charAt(i) > 'Z')&(nombreJugadorS.charAt(i) < 'a'))){
				 return false;}
		}
		return true;
	}
	
	
	

}