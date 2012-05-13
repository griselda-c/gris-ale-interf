package ruleta.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruleta.Apuesta;

/**
 * Servlet implementation class GetApuestasServlet
 */
public class GetApuestasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetApuestasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apuestasText = "";
		for(Apuesta apuesta: RuletaWebModel.getModel(request).getJugador().getApuestas()){
			apuestasText += "Tipo: " + apuesta.getTipoApuesta() + "| OpcionSeleccionada: " + apuesta.getJugadaSeleccionada().getNombre() + "| Fichas: " + apuesta.getFichasString() + "\n"; 
		}
		
		request.getSession().setAttribute("apuestas", apuestasText);
		request //
		.getRequestDispatcher("getapuestas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
