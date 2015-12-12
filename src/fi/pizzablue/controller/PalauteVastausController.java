package fi.pizzablue.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/palautevastaus")
public class PalauteVastausController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//siirrytään palauteVastaus sivulle
		request.getRequestDispatcher("WEB-INF/jsp/palautevastaus.jsp").forward(request, response);	
	}
}
