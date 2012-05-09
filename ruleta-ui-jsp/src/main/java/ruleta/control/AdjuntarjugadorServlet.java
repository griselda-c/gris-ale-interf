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
			request.setAttribute("errorJugador", "Los datos ingresados son incorrectos, intentelo nuevamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
		else{
			request.setAttribute("errorJugador", null);

			String nombreJugador = nombreJugadorS;
			Integer dineroJugador = Integer.parseInt(dineroJugadorS);
		
			if(getServletContext().getAttribute("mesa") == null){
				getServletContext().setAttribute("mesa", new Mesa(1000));
			}
		
			Mesa mesaGlobal = (Mesa) getServletContext().getAttribute("mesa");
		
			Jugador jugadorActual = new Jugador(dineroJugador, nombreJugador);
		
			mesaGlobal.unirJugador(jugadorActual);

			request.getSession().setAttribute("jugador", jugadorActual);
			
			request //
			.getRequestDispatcher("jugar.jsp").forward(request, response);
		}
	}

	private boolean datosCorrectos(String nombreJugadorS, String dineroJugadorS) {
		return (Validador.isText(nombreJugadorS) & Validador.isNumber(dineroJugadorS));
	}

}