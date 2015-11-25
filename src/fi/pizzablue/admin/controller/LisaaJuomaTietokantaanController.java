package fi.pizzablue.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.admin.service.JuomaAdminService;

@WebServlet("/lisaajuoma")
public class LisaaJuomaTietokantaanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String syoteNimi = request.getParameter("jnimi");
		String syoteMaara = request.getParameter("jmaara");
		String syoteHinta = request.getParameter("jhinta");
		String syoteEnergia = request.getParameter("jenergia");
		String syoteProteiini = request.getParameter("jproteiini");
		String syoteHiilihydraatti = request.getParameter("jhiilihydraatti");
		String syoteRasva = request.getParameter("jrasva");
		
		//haetaan viimeksi syötetyn juoman numero kannasta
		System.out.println(request.getParameter("jnimi"));
		System.out.println(request.getParameter("jmaara"));

		int jNumero = 0;
		
		try {
			JuomaAdminService jservice = new JuomaAdminService();
			jNumero = jservice.haeJuomaNumero();
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		jNumero += 1;

		//muutetaan määrä, hinta, energia, proteiini ja hiilihydraatti desimaaliluvuksi
		int maara = Integer.parseInt(syoteMaara);
		Double hinta = Double.parseDouble(syoteHinta);
		int energia = Integer.parseInt(syoteEnergia);
		Double proteiini = Double.parseDouble(syoteProteiini);
		Double hiilihydraatti = Double.parseDouble(syoteHiilihydraatti);
		Double rasva = Double.parseDouble(syoteRasva);
		
		
		Juoma j = new Juoma(0, jNumero, syoteNimi, maara, hinta, energia, proteiini, hiilihydraatti, rasva);
		
		System.out.println(j.toString());
		
		try {
			JuomaAdminService service = new JuomaAdminService();
			service.lisaaJuoma(j);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect("admin?lisatty=true");
	}
	
}
