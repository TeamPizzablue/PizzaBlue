package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.bean.Tilausrivi;
import fi.pizzablue.service.PizzalistaService;

/**
 * Servlet implementation class PoistaTuoteOstoskorista
 */
@WebServlet("/poista_tuote_ostoskorista")
public class PoistaTuoteOstoskorista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PoistaTuoteOstoskorista() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String poistettavanTuotteenJarjNrStringina = request.getParameter("ordernr");
		
		int poistettavanTuotteenJarjNr = Integer.parseInt(poistettavanTuotteenJarjNrStringina);

		Tilaus tilaus = (Tilaus) request.getSession().getAttribute("tilaus");

		tilaus.getTilausrivit().remove(poistettavanTuotteenJarjNr);

		System.out.println("Tilausrivit size: "+ tilaus.getTilausrivit().size());

		request.getSession().setAttribute("tilaus", tilaus);
		response.sendRedirect("index.jsp");

	}

}
