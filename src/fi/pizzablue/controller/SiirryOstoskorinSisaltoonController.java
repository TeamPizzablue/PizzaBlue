package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;

/**
 * Servlet implementation class TilaussivuController
 */
@WebServlet(urlPatterns={"/ostoskorinsisalto"})
public class SiirryOstoskorinSisaltoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiirryOstoskorinSisaltoonController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tilaus tilaus = (Tilaus) request.getSession().getAttribute("tilaus");
		
		double tilausrivienyhteenlaskettuhinta = 0;
		
		for(int i = 0; i < tilaus.getTilausrivit().size(); i++) {
			if(tilaus.getTilausrivit().get(i) instanceof Pizzarivi) {
				Pizzarivi pizzarivi = (Pizzarivi)tilaus.getTilausrivit().get(i);
				tilausrivienyhteenlaskettuhinta += pizzarivi.getPizza().getHinta();
			}
			if (tilaus.getTilausrivit().get(i) instanceof Juomarivi) {
				Juomarivi juomarivi = (Juomarivi)tilaus.getTilausrivit().get(i);
				tilausrivienyhteenlaskettuhinta += juomarivi.getJuoma().getHinta();
			}
			
		}
		System.out.println(tilausrivienyhteenlaskettuhinta);
		request.getSession().setAttribute("tilausrivienyhteenlaskettuhinta", tilausrivienyhteenlaskettuhinta);
		
		
		request.getRequestDispatcher("WEB-INF/jsp/ostoskorinSisalto.jsp").forward(request, response);
		
	}
}
