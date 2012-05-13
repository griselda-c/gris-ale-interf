package ruleta.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Apuesta;
import ruleta.OpcionJugada;

public class ApostarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String apuesta = request.getParameter("apuesta"); //Pleno Columna Paridad Fila
		String jugada = request.getParameter("jugada"); //numero al que se apuesta
		String fichas = request.getParameter("fichasapostar");
		
		if(!RuletaWebModel.isNumber(fichas)){
			request.setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un parametro incorrecto en fichas");
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}		
		else if(!RuletaWebModel.esApuesta(apuesta))
		{
			request.setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un parametro incorrecto en tipo de apuesta");
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}
		else{
			
			Apuesta apuestaTemp = RuletaWebModel.getApuesta(apuesta);
			if(!RuletaWebModel.esJugadaPosible(apuestaTemp,  jugada)){
				request.setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un parametro incorrecto en tipo de apuesta");
				request.getRequestDispatcher("jugar.jsp").forward(request, response);
			}
			else{
					
				//le pido a la clase que me de la instancia asignada a este request
				RuletaWebModel modeloWeb = RuletaWebModel.getModel(request);
						
				
				//obtengo la OpcionJugada a partir de la apuesta y el valor elegido por el cliente
				OpcionJugada jugadaSeleccionada = RuletaWebModel.getOpcionJugada(apuestaTemp,  jugada);
				
				
				//seteo los atributos de la apuesta
				apuestaTemp.setJugador(modeloWeb.getJugador());		
				apuestaTemp.setJugador(modeloWeb.getJugador());											
				apuestaTemp.setFichas(Integer.parseInt(fichas));
				apuestaTemp.setJugadaSeleccionada(jugadaSeleccionada);
				apuestaTemp.confirmar();
				
				request //
				.getRequestDispatcher("jugar.jsp").forward(request, response);
			
			}
		}
		
	}

}
