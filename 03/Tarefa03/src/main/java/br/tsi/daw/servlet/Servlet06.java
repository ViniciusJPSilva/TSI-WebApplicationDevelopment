package br.tsi.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/06")
public class Servlet06 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float peso = Float.parseFloat(request.getParameter("peso")),
				altura = Float.parseFloat(request.getParameter("altura"));
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("</head>");
		out.print("<body>");
		out.print(String.format("<h1 style=\"color: #F00;\">IMC = %.2f</h1>", peso / (altura * altura)));
		out.print(String.format("<h1 style=\"color: #F00;\">%s</h1>", getImcMessage(peso, altura)));
		out.print("</body>");
		out.print("</html>");
	}

	private String getImcMessage(float peso, float altura) {
		float imc = peso / (altura * altura);
		if(imc < 18.5) return "Cuidado! Você está muito abaixo do peso!";
		if(imc < 25.0) return "Parabéns! Você está em seu peso ideal!";
		if(imc < 30.0) return "Atenção! Você está acima de seu peso ideal!";
		if(imc < 35.0) return "Atenção! Obesidade grau 1!";
		if(imc < 40.0) return "Cuidado! Obesidade grau 2!";
		
		return "Cuidado! Obesidade grau 3 ";
	}
}
