package fi.pizzablue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Tilaus;


@WebServlet("/siirry_tilausvahvistukseen")
public class TallennaToimitustiedotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String katuosoite = request.getParameter("katuosoite");
		String postinro = request.getParameter("postinumero");
		String postitmp = request.getParameter("paikkakunta");
		String puhelinnumero = request.getParameter("puhelinnumero");
		String sahkoposti = request.getParameter("sahkoposti");
		String lisatiedot = request.getParameter("lisatietoja");
		
		Tilaus tilaus = (Tilaus)request.getSession().getAttribute("tilaus");
		
		tilaus.setEtunimi(etunimi);
		tilaus.setSukunimi(sukunimi);
		tilaus.setKatuosoite(katuosoite);
		tilaus.setPostinro(postinro);
		tilaus.setPostitmp(postitmp);
		tilaus.setPuhelinnumero(puhelinnumero);
		tilaus.setSahkoposti(sahkoposti);
		tilaus.setLisatiedot(lisatiedot);
		
		System.out.println(tilaus.getTilausrivit().size());
		
		System.out.println(tilaus.toString());
		
		request.getSession().setAttribute("tilaus", tilaus);
		response.sendRedirect("vahvistus");
	}
}
