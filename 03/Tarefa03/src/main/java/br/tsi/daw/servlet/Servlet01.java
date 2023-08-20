package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/01")
public class Servlet01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=\"1\"><thead><tr><th>Nome</th><th>Valor</th></tr></thead><tbody>");
		
		for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
			String name = e.nextElement();
			for(String value : request.getParameterValues(name))
				out.print(String.format("<tr><td>%s</td><td>%s</td></tr>", name, value));
		}
		
		out.print("</tbody></table>");
		out.print("</body>");
		out.print("</html>");
	}
}
