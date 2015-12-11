package fi.pizzablue.tyontekija.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.controller.SiteController;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.tyontekija.service.TilauksenTilaService;

@WebServlet("/muuta_valmistetuksi")
public class TilausValmistettuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
			
			String syoteid = request.getParameter("tilausId");
			int id = Integer.parseInt(syoteid);
			
			try {
				TilauksenTilaService tService = new TilauksenTilaService();
				tService.muutaTilaValmistetuksi(id);	
			} catch (DAOPoikkeus e) {
				throw new ServletException(e);	
			}
			response.sendRedirect("tilaustenseuranta.jsp?vaihdettu=true");
		}
	}

}
