package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.JuomalistaService;
import fi.pizzablue.service.PizzalistaService;

@WebServlet("/site")
public class SiteController extends HttpServlet {

	public static final String FRONT_PAGE = "WEB-INF/jsp/admin/kirjautuminen.jsp";
	private static final String INSIDE_PAGE = "WEB-INF/jsp/admin/admin.jsp";

	public static final String SESSION_ATTR_WEBUSER = "kayttajatiedot";

	private static final long serialVersionUID = 1L;

	public SiteController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
			
			List<Pizza> pizzat;
			List<Juoma> juomat;
			
			try {
				PizzalistaService pService = new PizzalistaService();
				JuomalistaService jService = new JuomalistaService();
				juomat = jService.haeJuomalista();
				pizzat = pService.haePizzalista();
			} catch(DAOPoikkeus e) {
				throw new ServletException(e);
			}
			
			//asetetaan listat requestin attribuuteiksi
			request.setAttribute("pizzat", pizzat);
			request.setAttribute("juomat", juomat);
			
			request.getRequestDispatcher(INSIDE_PAGE).forward(request, response);
		}
	}
}
