package br.com.mmaciel.clouduino.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ClouduinoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String msg = req.getParameter("mensagem");
		System.out.println(msg);
		resp.getWriter().println(msg);
		resp.sendRedirect("index.jsp?msgsucesso=Mensagem enviada com sucesso!");
	}
}
