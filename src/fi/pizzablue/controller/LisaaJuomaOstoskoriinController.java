package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.JuomalistaService;

/**
 * Servlet implementation class LisaaPizzaOstoskoriinController
 */
@WebServlet("/lisaa_juoma_ostoskoriin")
public class LisaaJuomaOstoskoriinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lisattavanJuomanIdStringina = request.getParameter("id");
		int lisattavanJuomanId;
		
		JuomalistaService service = new JuomalistaService();
		
		try {
			lisattavanJuomanId = Integer.parseInt(lisattavanJuomanIdStringina);
			
			Juoma j = service.haeJuoma(lisattavanJuomanId);
			
			Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
			if (tilaus == null) {
				tilaus = new Tilaus();
			}
			
			tilaus.getTilausrivit().add(new Juomarivi(j));
			
			System.out.println("MONTA: " + tilaus.getTilausrivit().size());
			
			request.getSession().setAttribute("tilaus", tilaus);
			
			response.sendRedirect("index.jsp");
			
		} catch(DAOPoikkeus e) {
			System.out.println("ERROR: Ostoskoriin yritettiin lisätä pizza, jonka id ei ole kokonaisluku. (ID:" + lisattavanJuomanIdStringina + ")");
			request.setAttribute("error", "Pizzan lisäys epäonnistui");
			request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}