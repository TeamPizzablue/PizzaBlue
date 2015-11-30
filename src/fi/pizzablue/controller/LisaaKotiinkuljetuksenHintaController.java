package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Tilaus;


@WebServlet("/LisaaKotiinkuljetuksenHintaController")
public class LisaaKotiinkuljetuksenHintaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LisaaKotiinkuljetuksenHintaController() {
        super();
        
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		double tilauksenkokonaishinta = tilaus.getHinta();
		tilauksenkokonaishinta += 2.99;
		
		request.getSession().setAttribute("tilaus", tilaus);
		response.sendRedirect("ostoskorinSisalto.jsp");
	}

}
