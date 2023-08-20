package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/02")
public class Servlet02 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=\"black\"><thead><tr><th>Cabecalho</th><th>Valor</th></tr></thead><tbody>");
		
		for (Enumeration<String> headers = request.getHeaderNames(); headers.hasMoreElements();) {
			String name = headers.nextElement();
			for (Enumeration<String> values = request.getHeaders(name); values.hasMoreElements();) {
				String value = values.nextElement();
				out.print(String.format("<tr><td>%s</td><td>%s</td></tr>", name, value));
			}
		}
		
		out.print("</tbody></table>");
		out.print("</body>");
		out.print("</html>");
	}
}
