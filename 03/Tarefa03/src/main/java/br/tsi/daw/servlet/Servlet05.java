package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/05")
public class Servlet05 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul border=\"1\">");
		
		try {
			int max = Integer.parseInt(request.getParameter("maximo"));
			
			out.print(String.format("<li>0! = %,d</li>", 0));
			long fat = 1;
			for(int i = 1; i <= max; i++) {
				fat *= i;
				out.print(String.format("<li>%,d! = %,d</li>", i, fat));
			}
		} catch (NumberFormatException e) {
			out.print("<h3 style=\"color: #F00;\">Forneca um valor valido!</h3>");
		}
		
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}
}
