package ruleta.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApostarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String apuesta = request.getParameter("apuesta");
		String fichas = request.getParameter("fichasapostar");
		
		if(!Validador.isNumber(fichas)){
			request.setAttribute("errorApuesta", "Se ingreso un parametro incorrecto en fichas");
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
		else{
			
			
			
			
			
			
			request //
			.getRequestDispatcher("jugar.jsp").forward(request, response);
			
		}
		
	}

}
