package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

@WebServlet("/laheta_tilaus")
public class LahetaTilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LahetaTilausController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] rivinumerot = request.getParameterValues("riviNro");
		
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String katuosite = request.getParameter("katuosoite");
		String postinumero = request.getParameter("postinumero");
		String paikkakunta = request.getParameter("paikkakunta");
		String puhelin = request.getParameter("puhelinumero");
		String sahkoposti = request.getParameter("sahkoposti");
		String lisatietoja = request.getParameter("lisatietoja");
		
		String valkosipuli = request.getParameter("mausteetV");
		String oregano = request.getParameter("mausteetO");
		String pizzapohja = request.getParameter("pizzapohja");
		
		System.out.println(pizzapohja);
		System.out.println(oregano);
		System.out.println(valkosipuli);
		System.out.println(lisatietoja);
		
		response.sendRedirect("index.jsp");
		
	}

}
