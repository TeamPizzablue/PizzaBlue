package fi.pizzablue.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.TayteDAO;

/**
 * Servlet implementation class PizzaListController
 */
@WebServlet("/frontpage.jsp")
public class FrontPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pizza> pizzat;
		List<Tayte> taytteet;
		
		try {
			PizzaDAO pDAO = new PizzaDAO();
			pizzat = pDAO.haeKaikki();
			TayteDAO tDAO = new TayteDAO();
			taytteet = tDAO.haeKaikki();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		request.setAttribute("taytteet", taytteet);
		request.setAttribute("pizzat", pizzat);
		
		request.getRequestDispatcher("WEB-INF/jsp/frontpage.jsp").forward(request, response);
	}

}
