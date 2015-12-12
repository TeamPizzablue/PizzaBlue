package fi.pizzablue.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.admin.service.PizzaAdminService;

@WebServlet("/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String syoteID = request.getParameter("id");
		
		//muutetaan string syöte intiksi
		int id = Integer.parseInt(syoteID);
		
		//luodaan pizzaolio poistoa varten
		Pizza p = new Pizza(id);

		try {
			PizzaAdminService service = new PizzaAdminService();
			service.poistaPizza(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		response.sendRedirect("admin?deleted=true");
	}
	
}
