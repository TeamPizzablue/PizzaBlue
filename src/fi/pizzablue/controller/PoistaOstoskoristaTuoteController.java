package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;

@WebServlet("/poista_tuote_ostoskorista")
public class PoistaOstoskoristaTuoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PoistaOstoskoristaTuoteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poistettavaPizzaStringina = request.getParameter("id");
		int poistettavanPizzanId;
		
		
		try {
			poistettavanPizzanId = Integer.parseInt(poistettavaPizzaStringina);
			
			
			//tilaus.getTilausrivit().remove(poistettavanPizzanId);
			
			response.sendRedirect("index.jsp");
			
			
		} catch(NumberFormatException e) {
			System.out.println("Pizzan poisto ostoskorista epäonnistui!");
			request.setAttribute("error", "Pizzan lisäys epäonnistui");
			request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
		}

	}


}
