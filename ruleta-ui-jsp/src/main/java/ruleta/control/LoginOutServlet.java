package ruleta.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginOutServlet
 */
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute(RuletaWebModel.MODEL);
		request.getSession().removeAttribute(RuletaWebModel.JUGADOR);
		request //
		.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


}
