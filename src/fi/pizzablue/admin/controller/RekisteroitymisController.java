package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.InvalidKayttajaPoikkeus;
import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.dao.KayttajaDAO;
import fi.pizzablue.admin.dao.UsernameVarattuPoikkeus;
import fi.pizzablue.dao.DAOPoikkeus;

@WebServlet("/rekisteroidy")
public class RekisteroitymisController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RekisteroitymisController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		
		try {
			//luodaan käyttäjä suolalla ja hashilla
			Kayttaja kayttaja = new Kayttaja(username, password, password2);
			//lisätään tietokantaan
			KayttajaDAO dao = new KayttajaDAO();
			dao.lisaa(kayttaja);
			
			//takaisin onnistumisviestillä
			response.sendRedirect("site?onnistui=y");
			
		} catch(InvalidKayttajaPoikkeus e) {
			takaisinVirheviestilla(e.getMessage(), username, request, response);
		} catch(UsernameVarattuPoikkeus e) {
			String virheviesti = "Käyttäjätunnus " +username +" on jo varattu, valitse toinen käyttäjätunnus!";
			takaisinVirheviestilla(virheviesti, username, request, response);
		} catch(DAOPoikkeus e) {
			throw new ServletException("Tietokantavirhe", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException("Salausalgoritmia ei löydy.", e);
		}
	
		
	}
	
	private void takaisinVirheviestilla(String viesti, String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", viesti);
		request.setAttribute("prev_reg_username", username);
		request.getRequestDispatcher(SiteServlet.FRONT_PAGE).forward(request, response);
		
	}

}