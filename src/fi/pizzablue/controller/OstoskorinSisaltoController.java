package fi.pizzablue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Pohja;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.bean.Tilausrivi;

@WebServlet("/siirry_toimitustietoihin")
public class OstoskorinSisaltoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OstoskorinSisaltoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String[] rivitJoissaValkosipuli = request.getParameterValues("mausteetV");
		String[] rivitJoissaOregano = request.getParameterValues("mausteetO");
		
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		List<Tilausrivi> tilausrivit = tilaus.getTilausrivit();
		
		List<String> pohjat = new ArrayList<String>();
		for(int i=0; i < tilausrivit.size(); i++) {
			if(tilausrivit.get(i) instanceof Pizzarivi) {
				Pizzarivi pizzarivi = (Pizzarivi)tilausrivit.get(i);
				//pohja
				pizzarivi.setPohja(new Pohja(request.getParameter("pizzapohja-"+i)));
				//oreg
				if (Arrays.asList(rivitJoissaOregano).contains(""+i))
					pizzarivi.setOregano(true);
				//vsip
				if (Arrays.asList(rivitJoissaValkosipuli).contains(""+i))
					pizzarivi.setValkosipuli(true);
				
			}
		}
		
		request.getSession().setAttribute("tilaus", tilaus);
		response.sendRedirect("toimitustiedot");
		
	}

}
