package ruleta.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Apuesta;

public class GetApuestasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RuletaWebModel modeloWeb = (RuletaWebModel) request.getSession().getAttribute("model");
		List<Apuesta> apuestas = modeloWeb.jugador.apuestas;
		System.out.println("Apuestas");
		for(Apuesta ap:apuestas){
			System.out.println("se apuesta" + ap.getTipoApuesta() + ap.jugadaSeleccionada.getNombre() + ap.getFichas());
		}
		
		
		
		
		System.out.println();
		request //
		.getRequestDispatcher("getapuestas.jsp").forward(request, response);
	}
}
