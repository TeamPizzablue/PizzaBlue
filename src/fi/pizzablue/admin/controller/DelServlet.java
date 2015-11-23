package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;



@WebServlet("/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String syoteID = request.getParameter("id");
		
		//muutetaan string syöte intiksi
		int id = Integer.parseInt(syoteID);
		
		//luodaan pizzaolio poistoa varten
		Pizza p = new Pizza(id);

		/*try {
			PizzaDAO pDao = new PizzaDAO();
			pDao.poista(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}*/
		response.sendRedirect("list?deleted=true");
	}
	
}
