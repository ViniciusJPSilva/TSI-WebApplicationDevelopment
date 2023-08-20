package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/04")
public class Servlet04 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul border=\"1\">");
		
		out.print(String.format("<li>0! = %,d</li>", 0));
		int fat = 1;
		for(int i = 1; i <= 10; i++) {
			fat *= i;
			out.print(String.format("<li>%,d! = %,d</li>", i, fat));
		}
		
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}
}
