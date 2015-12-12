package fi.pizzablue.tyontekija.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.controller.SiteController;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.tyontekija.bean.KokoTilaus;
import fi.pizzablue.tyontekija.service.KokoTilausService;

@WebServlet(urlPatterns={"/tilaustenseuranta.jsp","/tilaustenseuranta"})
public class TilaustenSeurantaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
			// luodaan lista
			List<KokoTilaus> tilaukset;

			//haetaan servicen avulla juomat ja pizzat listoille
			try {
				KokoTilausService ktService = new KokoTilausService();
				tilaukset = ktService.haeTilaukset();
			} catch(DAOPoikkeus e) {
				throw new ServletException(e);
			}
			
			int pizzojenMaara = 0;
			int juomienMaara = 0;
			
			for (int i = 0; i < tilaukset.size(); i++) {
				pizzojenMaara = tilaukset.get(i).getPizzat().size();
				juomienMaara = tilaukset.get(i).getJuomat().size();
				tilaukset.get(i).setPizzojenMaara(pizzojenMaara);
				tilaukset.get(i).setJuomienMaara(juomienMaara);
			}
			request.setAttribute("tilaus", tilaukset);
			request.getRequestDispatcher("WEB-INF/jsp/tyontekija/tilaustenseuranta.jsp").forward(request, response);
		}
	}
}
