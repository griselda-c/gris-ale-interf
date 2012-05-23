package ruleta.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Apuesta;
import ruleta.OpcionJugada;

public class ApostarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String apuesta = request.getParameter("apuesta"); //Pleno Columna Paridad Fila
		String jugada = request.getParameter("jugada"); //numero al que se apuesta
		String fichas = request.getParameter("fichasapostar");
		
		//falta cotrolar que el usuario este loggeado
		//y que pueda apostar la suma enviada
		
		if(!RuletaWebModel.isNumber(fichas)){
			request.getSession().setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un   incorrecto en fichas");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}		
		else{
			if(!RuletaWebModel.esApuesta(apuesta)){
				request.getSession().setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un parametro incorrecto en tipo de apuesta, [" + apuesta + "]");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			else{
			
				Apuesta apuestaTemp = RuletaWebModel.getApuesta(apuesta);
				if(!RuletaWebModel.esJugadaPosible(apuestaTemp,  jugada)){
					request.getSession().setAttribute(RuletaWebModel.ERRORAPUESTA, "Se ingreso un parametro incorrecto en tipo de jugada [Apuesta: " + jugada  + "]");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else{
					
					//le pido a la clase que me de la instancia asignada a este request
					RuletaWebModel modeloWeb = RuletaWebModel.getModel(request);
						
				
					//obtengo la OpcionJugada a partir de la apuesta y el valor elegido por el cliente
					OpcionJugada jugadaSeleccionada = RuletaWebModel.getOpcionJugada(apuestaTemp,  jugada);
				
				
					//seteo los atributos de la apuesta
					apuestaTemp.setJugador(modeloWeb.getJugador());											
					apuestaTemp.setFichas(Integer.parseInt(fichas));
					apuestaTemp.setJugadaSeleccionada(jugadaSeleccionada);
					apuestaTemp.confirmar();
					
					RuletaWebModel modeloWebprueba = (RuletaWebModel) request.getSession().getAttribute("model");
					List<Apuesta> apuestas = modeloWebprueba.jugador.apuestas;
					request.getSession().setAttribute(RuletaWebModel.ERRORAPUESTA, null);
				
					request //
					.getRequestDispatcher("getapuestas.jsp").forward(request, response);
			
				}
			}
		}		
	}
}
