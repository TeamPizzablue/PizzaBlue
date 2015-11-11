package fi.pizzablue.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.TilausDAO;
import fi.pizzablue.dao.Yhteys;

@WebServlet("/laheta_tilaus")
public class TallennaTilausTietokantaanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TallennaTilausTietokantaanController() {
        super();
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		
		try {
			Connection yhteys = Yhteys.avaaYhteys();
			TilausDAO tDao = new TilausDAO();
			tDao.lisaaTilaus(tilaus, yhteys);
			Yhteys.suljeYhteys(yhteys);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		//try {
		//	Connection yhteys = Yhteys.avaaYhteys();
		//	TilausDAO tDao = new TilausDAO();
		//	tDao.lisaaTilausrivit(tilaus, yhteys);
		//	Yhteys.suljeYhteys(yhteys);
		//} catch (DAOPoikkeus e) {
		//	throw new ServletException(e);
		//}
		
		System.out.println(tilaus.getTilausrivit().size());
		System.out.println(tilaus.toString());
		request.getRequestDispatcher("WEB-INF/jsp/tilausvahvistus.jsp").forward(request,response);
		
	}
}
