package fi.pizzablue.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.JuomalistaService;
import fi.pizzablue.service.PizzalistaService;


@WebServlet(urlPatterns={"/frontpage","/index.jsp"})
public class FrontPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// luodaan uudet listat juomille ja pizzoille 
		List<Pizza> pizzat;
		List<Juoma> juomat;

		//haetaan servicen avulla juomat ja pizzat listoille
		try {
			PizzalistaService pService = new PizzalistaService();
			JuomalistaService jService = new JuomalistaService();
			juomat = jService.haeJuomalista();
			pizzat = pService.haePizzalista();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		//asetetaan listat requestin attribuuteiksi
		request.setAttribute("pizzat", pizzat);
		request.setAttribute("juomat", juomat);
		
		//siirrytään etusivulle
		request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
	}

}
