package br.com.mmaciel.clouduino.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author marcomaciel
 */
public class GravaDadosServlet extends HttpServlet {

	private static final long serialVersionUID = -8825679404925601066L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String mensagem = request.getParameter("mensagem");

		// salva no contexto global da aplicação
		ServletContext sc = getServletContext();
		sc.setAttribute("mensagem", mensagem);

		response.sendRedirect("index.jsp");

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
