package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;

/**
 * Servlet implementation class LisaaPizzaOstoskoriinController
 */
@WebServlet("/lisaa_pizza_ostoskoriin")
public class LisaaPizzaOstoskoriinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lisattavanPizzanIdStringina = request.getParameter("id");
		int lisattavanPizzanId;
		try {
			lisattavanPizzanId = Integer.parseInt(lisattavanPizzanIdStringina);
			
			Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
			if (tilaus == null) {
				tilaus = new Tilaus();
			}
			tilaus.getTilausrivit().add(new Pizzarivi(new Pizza(lisattavanPizzanId)));
			response.sendRedirect("index.jsp");
		} catch(NumberFormatException e) {
			System.out.println("ERROR: Ostoskoriin yritettiin lisätä pizza, jonka id ei ole kokonaisluku. (ID:" +lisattavanPizzanIdStringina+")");
			request.setAttribute("error", "Pizzan lisäys epäonnistui");
			request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
