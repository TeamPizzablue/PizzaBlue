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

/**
 * Servlet implementation class TulostaTilausController
 */
@WebServlet("/tulosta_tilaus")
public class TulostaTilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TulostaTilausController() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
		
		// luodaan lista
		List<KokoTilaus> tilaukset;
			
		String tulostettavaTilausStringina = request.getParameter("ordernr");
		int tulostettavanTilauksenJarjnro = Integer.parseInt(tulostettavaTilausStringina);

		//haetaan servicen avulla juomat ja pizzat listoille
		try {
			KokoTilausService ktService = new KokoTilausService();
			tilaukset = ktService.haeTilaukset();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		KokoTilaus ktilaus = new KokoTilaus();
		
		for (int i = 0; i < tilaukset.size(); i++) {
			if(tulostettavanTilauksenJarjnro == tilaukset.get(i).getId()) {
				ktilaus = tilaukset.get(i);
			}
		}
	
		System.out.println(ktilaus.toString());
		request.setAttribute("tilaus", ktilaus);
		request.getRequestDispatcher("WEB-INF/jsp/tyontekija/tulostus.jsp").forward(request, response);
		}

	}
}
