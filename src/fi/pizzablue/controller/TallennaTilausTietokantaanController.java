package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.mail.TilausvahvistusMail;
import fi.pizzablue.service.TilausIdService;
import fi.pizzablue.service.TilausService;
import fi.pizzablue.service.TilausrivitService;

@WebServlet("/laheta_tilaus")
public class TallennaTilausTietokantaanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TallennaTilausTietokantaanController() {
        super();
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		
		try {
			if (tilaus == null || tilaus.getHinta() == 0) {
				System.out.println("Tilausta ei voida lähettää se on tyhjä");
				
				//tyhjennetään sessio
				request.getSession().invalidate();
			
				//siirrytään etusivulle KADOTTAA LISTAT
				request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request,response);
			} else {
				TilausService tService = new TilausService();
				tService.lisaaTilaus(tilaus);
			}
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		try {
			if (tilaus == null || tilaus.getHinta() == 0) {
				System.out.println("Tilausta ei voida lähettää se on tyhjä");
			
				//tyhjennetään sessio
				request.getSession().invalidate();
			
				//siirrytään etusivulle KADOTTAA LISTAT
				request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request,response);
			} else {
				TilausrivitService trService = new TilausrivitService();
				trService.lisaaTilausrivit(tilaus);
			}
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		TilausvahvistusMail lahetysSahkopostiin = new TilausvahvistusMail();
		
		lahetysSahkopostiin.sendFromGMail(tilaus);
		
		int tilausId;
		
		try {
			TilausIdService tdService = new TilausIdService();
			tilausId = tdService.haeTilausId();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		System.out.println(tilaus.getTilausrivit().size());
		System.out.println(tilaus.toString());
		
		//tyhjennetään sessio
		request.getSession().invalidate();
		request.setAttribute("vahvistus", "Tilaus on vahvistettu");
		request.setAttribute("tilausid", tilausId);
		request.getRequestDispatcher("WEB-INF/jsp/kiitostilauksesta.jsp").forward(request, response);
		
	}
}
