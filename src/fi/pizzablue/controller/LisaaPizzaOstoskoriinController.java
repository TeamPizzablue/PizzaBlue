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
import fi.pizzablue.service.PizzalistaService;

@WebServlet("/lisaa_pizza_ostoskoriin")
public class LisaaPizzaOstoskoriinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//haetaan stringinä saatu id
		String lisattavanPizzanIdStringina = request.getParameter("id");
		int lisattavanPizzanId;
		
		PizzalistaService service = new PizzalistaService();
		
		try {
			//muutetaan string intiksi
			lisattavanPizzanId = Integer.parseInt(lisattavanPizzanIdStringina);
			
			//haetaan pizza id:n avulla kannasta ja tallennetaan se pizza olioon
			Pizza p = service.haePizza(lisattavanPizzanId);
			
			//tarkistetaan onko sessiossa tilaus, jos ei ole luodaan uusi tilaus
			Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
			if (tilaus == null) {
				tilaus = new Tilaus();
			}
			
			//tilaus-oliossa olevaan tilausrivit listaan lisätään uusi pizzarivi, joka sisältää pizzan
			tilaus.getTilausrivit().add(new Pizzarivi(p));
			
			System.out.println("MONTA: " + tilaus.getTilausrivit().size());
			
			//lisätään sessioon attribuutiksi tilaus
			request.getSession().setAttribute("tilaus", tilaus);
			
			//siirrytään takaisin etusivun pizzalistaan
			response.sendRedirect("frontpage#pizzalista");
			
		//ohjataan etusivulle jos tulee virhe, jossa myös näkyy virhe viesti
		} catch(DAOPoikkeus e) {
			System.out.println("ERROR: Ostoskoriin yritettiin lisätä pizza, jonka id ei ole kokonaisluku. (ID:" + lisattavanPizzanIdStringina + ")");
			request.setAttribute("error", "Pizzan lisäys epäonnistui");
			request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
		}	
	}
}
