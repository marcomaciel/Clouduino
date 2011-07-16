package br.com.mmaciel.clouduino.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author marcomaciel
 */
public class ObtemDadosServlet extends HttpServlet {

	private static final long serialVersionUID = -4334913499515096588L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			ServletContext sc = getServletContext();

			// obtém os dados do contexto da aplicação
			String mensagem = String.valueOf(sc.getAttribute("mensagem")).trim();

			if (mensagem.equals("")) {
				// escreve no formato JSON um objeto nulo
				out.print("{");
				out.print("\"mensagem\": \"\"");
				out.print("}");

			} else {
				// escreve no formato JSON a mensagem do contexto
				out.print("{");
				out.print("\"mensagem\": \"" + mensagem + "\"");
				out.print("}");

			}

			// os dados foram lidos, então apaga todos
			sc.setAttribute("mensagem", "");

		} finally {
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
