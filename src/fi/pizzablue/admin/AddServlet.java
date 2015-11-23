package fi.pizzablue.admin;

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



@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String syoteNimi = request.getParameter("nimi");
		String syoteHinta = request.getParameter("hinta");

		//muutetaan hinta desimaaliluvuksi
		Double hinta = Double.parseDouble(syoteHinta);
		
		//Pizza p = new Pizza(id);
		
		System.out.println(p.toString());
		
		try {
			PizzaDAO pDao = new PizzaDAO();
			pDao.lisaa(p, yhteys);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("list?added=true");
	}
	
}
