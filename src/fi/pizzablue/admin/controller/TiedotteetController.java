package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.bean.Tiedote;
import fi.pizzablue.admin.service.TiedoteService;
import fi.pizzablue.dao.DAOPoikkeus;

/**
 * Servlet implementation class TiedotteetController
 */
@WebServlet(urlPatterns={"/tiedotteet.jsp","/tiedotteet"})
public class TiedotteetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TiedotteetController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tiedote> tiedotteet;
		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else if(user.getUsername().equals("admin")) {// mikäli käyttäjätiedot löytyvät, päästetään sisään
		
			try {
				TiedoteService tService = new TiedoteService();
				tiedotteet = tService.haeTiedotteet();
			} catch (DAOPoikkeus e) {
				throw new ServletException(e);
			}
			request.setAttribute("tiedotteet", tiedotteet);
			request.getRequestDispatcher("WEB-INF/jsp/admin/tiedotteet.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Ei oikeuksia!");
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		}
	}
}
