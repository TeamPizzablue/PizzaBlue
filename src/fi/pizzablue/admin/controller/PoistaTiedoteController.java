package fi.pizzablue.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Tiedote;
import fi.pizzablue.admin.service.TiedoteService;
import fi.pizzablue.dao.DAOPoikkeus;

@WebServlet("/poista_tiedote")
public class PoistaTiedoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String syoteID = request.getParameter("id");
		
		//muutetaan string syöte intiksi
		int id = Integer.parseInt(syoteID);
		
		//luodaan pizzaolio poistoa varten
		Tiedote t = new Tiedote(id);

		try {
			TiedoteService service = new TiedoteService();
			service.poistaTiedote(t);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		response.sendRedirect("tiedotteet?poistettu=true");
	}

}
