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
		
		
		
		
		System.out.println("se invoco getApuestas");
		String girarRuleta = request.getParameter("girarruleta");
		if(girarRuleta.equals("true")){
			RuletaWebModel modeloWeb = RuletaWebModel.getModel(request);
			System.out.println("se giro ruleta");
			modeloWeb.mesa.girarRuleta();
			
		}
		request //
		.getRequestDispatcher("getapuestas.jsp").forward(request, response);
	}
}
