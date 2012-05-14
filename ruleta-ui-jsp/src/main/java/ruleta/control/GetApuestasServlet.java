package ruleta.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Apuesta;

public class GetApuestasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apuestasText = "";
		for(Apuesta apuesta: RuletaWebModel.getModel(request).getJugador().getApuestas()){
			apuestasText += "Tipo: " + apuesta.getTipoApuesta() + "| OpcionSeleccionada: " + apuesta.getJugadaSeleccionada().getNombre() + "| Fichas: " + apuesta.getFichas() + "\n"; 
		}
		
		request.getSession().setAttribute("apuestas", apuestasText);
		request //
		.getRequestDispatcher("getapuestas.jsp").forward(request, response);
	}



}
