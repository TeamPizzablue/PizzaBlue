package fi.pizzablue.tyontekija.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.pizzablue.dao.DAOPoikkeus;

import fi.pizzablue.tyontekija.bean.KokoTilaus;
import fi.pizzablue.tyontekija.service.KokoTilausService;


@WebServlet(urlPatterns={"/tilaustenseuranta.jsp","/tilaustenseuranta"})
public class TilaustenSeurantaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TilaustenSeurantaController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// luodaan lista
				List<KokoTilaus> tilaus;

				//haetaan servicen avulla juomat ja pizzat listoille
				try {
					KokoTilausService ktService = new KokoTilausService();
					tilaus = ktService.haeTilaukset();
				} catch(DAOPoikkeus e) {
					throw new ServletException(e);
				}
				
		
		//otetaan käyttäjätiedot sessiosta
		/*Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
			request.getRequestDispatcher("WEB-INF/jsp/admin/tilaustenseuranta.jsp").forward(request, response);
		} */
		request.getRequestDispatcher("WEB-INF/jsp/tyontekija/tilaustenseuranta.jsp").forward(request, response);
	}
}
