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
		
		String nombreJugadorS = request.getParameter(RuletaWebModel.NOMBREJUGADOR);
		String dineroJugadorS = request.getParameter(RuletaWebModel.DINEROJUGADOR);
		
		//contemplo la recepcion de datos incorrectos
		if(!datosCorrectos(nombreJugadorS, dineroJugadorS)){
			request.getSession().setAttribute(RuletaWebModel.ERRORJUGADOR, "Los datos ingresados son incorrectos, intentelo nuevamente");
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
		else{
			request.setAttribute(RuletaWebModel.ERRORJUGADOR, null);

			//"formateo los argumentos recibidos"
			String nombreJugador = nombreJugadorS;
			Integer dineroJugador = Integer.parseInt(dineroJugadorS);
			
			//singleTon de la mesa
			if(getServletContext().getAttribute(RuletaWebModel.MESA) == null){
				getServletContext().setAttribute(RuletaWebModel.MESA, new Mesa(1000));
			}
			
			//creo el jugador
			Jugador jugadorActual = new Jugador(dineroJugador, nombreJugador);
			
			//obtengo la mesa del servidor
			Mesa mesaGlobal = (Mesa) getServletContext().getAttribute(RuletaWebModel.MESA);			
			
			//uno al jugador a la mesa
			mesaGlobal.unirJugador(jugadorActual);

			//seteo el jugador en la sesion 
			request.getSession().setAttribute(RuletaWebModel.JUGADOR, jugadorActual);
			
			//seteo una instancia de RuletaWebModel a la session
			request.getSession().setAttribute(RuletaWebModel.MODEL, new RuletaWebModel(mesaGlobal, jugadorActual));
						
			request //
			.getRequestDispatcher("jugar.jsp").forward(request, response);
		}
	}

	private boolean datosCorrectos(String nombreJugadorS, String dineroJugadorS) {
		return (RuletaWebModel.isText(nombreJugadorS) & RuletaWebModel.isNumber(dineroJugadorS));
	}

}