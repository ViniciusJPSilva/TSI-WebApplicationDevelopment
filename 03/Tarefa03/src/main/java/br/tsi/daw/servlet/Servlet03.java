package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/03")
public class Servlet03 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Calendar date = Calendar.getInstance();
		out.print("<html>");
		out.print("<body>");
		out.print(String.format("Data: %02d/%02d/%04d", date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.MONTH) + 1, date.get(Calendar.YEAR)));
		out.print("<br>");
		out.print(String.format("Hora: %02d:%02d", date.get(Calendar.HOUR), date.get(Calendar.MINUTE)));
		out.print("<br>");
		out.print("</body>");
		out.print("</html>");
	}
}
