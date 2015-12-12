package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;

@WebServlet(urlPatterns={"/ostoskorinsisalto"})
public class SiirryOstoskorinSisaltoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pyydetään sessiosta tilausta
		Tilaus tilaus = (Tilaus) request.getSession().getAttribute("tilaus");
		
		double tilausrivienyhteenlaskettuhinta = 0;
		
		//loopataan läpi tilausrivit
		for(int i = 0; i < tilaus.getTilausrivit().size(); i++) {
		
			//jos tilausrivi on pizzarivi
			if(tilaus.getTilausrivit().get(i) instanceof Pizzarivi) {
				Pizzarivi pizzarivi = (Pizzarivi)tilaus.getTilausrivit().get(i);
				//lisätään pizzan hinta tilauksen kokonaishintaan
				tilausrivienyhteenlaskettuhinta += pizzarivi.getPizza().getHinta();
			}
			
			//jos tilausrivi on juomarivi
			if (tilaus.getTilausrivit().get(i) instanceof Juomarivi) {
				Juomarivi juomarivi = (Juomarivi)tilaus.getTilausrivit().get(i);
				//lisätään juoman hinta tilauksen kokonaishintaan
				tilausrivienyhteenlaskettuhinta += juomarivi.getJuoma().getHinta();
			}
		}
		System.out.println(tilausrivienyhteenlaskettuhinta);
		
		//asetetaan laskettu kokonaishinta tilaus-olioon
		tilaus.setHinta(tilausrivienyhteenlaskettuhinta);
		
		//lisätään sessioon attribuutiksi tilaus
		request.getSession().setAttribute("tilaus", tilaus);
		
		//siirrytään ostoskorin sisältö sivulle
		request.getRequestDispatcher("WEB-INF/jsp/ostoskorinsisalto.jsp").forward(request, response);
	}
}