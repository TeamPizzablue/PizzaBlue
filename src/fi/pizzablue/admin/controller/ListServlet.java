package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.sql.Connection;
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
import fi.pizzablue.dao.Yhteys;



@WebServlet(urlPatterns={"/index.jsp","/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection yhteys = Yhteys.avaaYhteys();
	
		List<Pizza> pizzat;
		
		try {
			//tietokannasta pizzat
			PizzaDAO hDao = new PizzaDAO();
			pizzat = hDao.haeKaikki(yhteys);
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		//requestiin talteen
		request.setAttribute("pizzat", pizzat);
		
			
		Date aloitusaika = (Date)request.getSession().getAttribute("aloitus");
		
		if (aloitusaika == null) {
			aloitusaika = new Date();
			request.getSession().setAttribute("aloitus", aloitusaika);
		}
		//siirret��n list.jsp:lle requesti
		request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
		
	}

}
