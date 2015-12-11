package fi.pizzablue.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;

@WebServlet("/site")
public class SiteController extends HttpServlet {

	public static final String FRONT_PAGE = "WEB-INF/jsp/admin/kirjautuminen.jsp";
	private static final String ADMIN_INSIDE_PAGE = "admin.jsp";
	private static final String TYONTEKIJA_INSIDE_PAGE = "tilaustenseuranta.jsp";

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
		} else if(user.getUsername().equals("admin")) {
			response.sendRedirect(ADMIN_INSIDE_PAGE);
		} else if (user.getUsername().equals("tyontekija")) {
			response.sendRedirect(TYONTEKIJA_INSIDE_PAGE);
		}
	}
}
