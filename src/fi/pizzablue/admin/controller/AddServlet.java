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
import fi.pizzablue.admin.service.PizzaAdminService;
import fi.pizzablue.service.PizzalistaService;



@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String syoteNimi = request.getParameter("nimi");
		String syoteHinta = request.getParameter("hinta");
		
		//haetaan viimeksi syötetyn pizzan numero kannasta
		int numero = 0;

		//muutetaan hinta desimaaliluvuksi
		Double hinta = Double.parseDouble(syoteHinta);
		
		Pizza p = new Pizza(0, numero, syoteNimi, hinta);
		
		System.out.println(p.toString());
		
		try {
			PizzaAdminService service = new PizzaAdminService();
			service.lisaaPizza(p);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("admin?added=true");
	}
	
}
