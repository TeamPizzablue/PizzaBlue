package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.service.KayttajaService;
import fi.pizzablue.dao.DAOPoikkeus;


@WebServlet("/kirjaudu")
public class SisaankirjautumisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SisaankirjautumisController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			//haetaan käyttäjä tietokannasta
			KayttajaService kService = new KayttajaService();
			Kayttaja kayttajaKannasta;
			kayttajaKannasta = kService.haeKayttaja(username);
			
			boolean validiKayttaja = kayttajaKannasta.vertaaSalasanaa(password);
			
			if(validiKayttaja) {
				request.getSession().setAttribute(SiteController.SESSION_ATTR_WEBUSER, kayttajaKannasta);
				response.sendRedirect("site");
			} else {
				request.setAttribute("error", "Käyttäjätunnus tai salasana väärin!");
				request.setAttribute("prev_login_username", username);
				request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
			}
		} catch(DAOPoikkeus e) {
			throw new ServletException("Tietokantavirhe", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException("Salausalgoritmia ei löydy.", e);
		}
			
			
			
	}

}

