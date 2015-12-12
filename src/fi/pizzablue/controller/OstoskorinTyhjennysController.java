package fi.pizzablue.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tyhjenna_ostoskori")
public class OstoskorinTyhjennysController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tyhjennetään sessio
		request.getSession().invalidate();
		
		//siirrytään etusivulle
		response.sendRedirect("frontpage");
	}
}

