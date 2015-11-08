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
public class TallennaOstoskorinSisaltoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TallennaOstoskorinSisaltoController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String[] rivitJoissaValkosipuli = null;
		String[] rivitJoissaOregano = null;
		rivitJoissaOregano = request.getParameterValues("mausteetO");
		rivitJoissaValkosipuli = request.getParameterValues("mausteetV");
		
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		List<Tilausrivi> tilausrivit = tilaus.getTilausrivit();
		
		/* List<String> pohjat = new ArrayList<String>(); */
		for(int i=0; i < tilausrivit.size(); i++) {
			if(tilausrivit.get(i) instanceof Pizzarivi) {
				Pizzarivi pizzarivi = (Pizzarivi)tilausrivit.get(i);
				//pohja
				pizzarivi.setPohja(new Pohja(request.getParameter("pizzapohja-"+i)));
				
				if (pizzarivi.getPohja().getNimi().equals("tavallinen")) {
					pizzarivi.getPohja().setId(1);
				} else if (pizzarivi.getPohja().getNimi().equals("taysjyva")) {
					pizzarivi.getPohja().setId(2);
				} else {
					pizzarivi.getPohja().setId(3);
				}
				
				System.out.println(pizzarivi.getPohja().getId());
				System.out.println(pizzarivi.getPohja().getNimi());
				
				//oreg
				if (rivitJoissaOregano != null) {
					if (Arrays.asList(rivitJoissaOregano).contains(""+i)) {
						pizzarivi.setOregano(true); 
					}
				}
				//vsip
				if (rivitJoissaValkosipuli != null) {
					if (Arrays.asList(rivitJoissaValkosipuli).contains(""+i)) {
						pizzarivi.setValkosipuli(true);
					}
				}
			}
		}
		
		
		System.out.println(tilaus.getTilausrivit().size());
		
		request.getSession().setAttribute("tilaus", tilaus);
		response.sendRedirect("toimitustiedot.jsp");
		
	}

}
