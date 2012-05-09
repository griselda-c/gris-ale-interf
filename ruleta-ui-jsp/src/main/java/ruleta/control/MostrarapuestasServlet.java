package ruleta.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Mesa;

public class MostrarapuestasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String apuesta = request.getParameter("apuesta");
		String tipo = request.getParameter("tipo");
		
		
		
		
		request.getSession().setAttribute("mostrarapuesta", apuesta);
		
		request //
		.getRequestDispatcher("jugar.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
