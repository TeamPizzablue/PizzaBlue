package fi.pizzablue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.OstoskorinTuote;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.JuomalistaService;
import fi.pizzablue.service.PizzalistaService;


/**
 * Servlet implementation class PizzaListController
 */
@WebServlet("/lisaa_tuote")
public class OstoskoriinLisaysController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 public OstoskoriinLisaysController() {
	        super();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String id = request.getParameter("numero");
		
		int numero = Integer.parseInt(id);
		
		List<Pizza> pizzat;
		//List<Juoma> juomat;
		
		List<OstoskorinTuote> ostoskorinTuotteet = new ArrayList<OstoskorinTuote>();

		
		try {
			PizzalistaService pService = new PizzalistaService();
			//JuomalistaService jService = new JuomalistaService();
			//juomat = jService.haeJuomalista();
			pizzat = pService.haePizzalista();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		OstoskorinTuote tuotteet = new OstoskorinTuote();
		
		/*for (int i = 0; i < juomat.size() + 1; i++) {
			if (numero == i + 1) {
				int num = juomat.get(i).getNumero();
				String nim = juomat.get(i).getNimi();
				double hint = juomat.get(i).getHinta();
				tuotteet.setId(num);
				tuotteet.setNimi(nim);
				tuotteet.setHinta(hint);
			}
			
		}*/
		for (int i = 0; i < pizzat.size() + 1; i++) {
			if (numero == i + 1) {
				int num = pizzat.get(i).getNumero();
				String nim = pizzat.get(i).getNimi();
				double hint = pizzat.get(i).getHinta();
				tuotteet.setId(num);
				tuotteet.setNimi(nim);
				tuotteet.setHinta(hint);
			}
			
		}
		
		ostoskorinTuotteet.add(tuotteet);
		
		request.setAttribute("pizzat", pizzat);
		//request.setAttribute("juomat", juomat);
		
		request.getSession().setAttribute("ostoskori", ostoskorinTuotteet);
	
		request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
	}

}
