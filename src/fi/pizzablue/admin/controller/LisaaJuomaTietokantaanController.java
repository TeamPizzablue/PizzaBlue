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

		String syoteNimi = request.getParameter("nimi");
		String syoteMaara = request.getParameter("maara");
		String syoteHinta = request.getParameter("hinta");
		String syoteEnergia = request.getParameter("energia");
		String syoteProteiini = request.getParameter("proteiini");
		String syoteHiilihydraatti = request.getParameter("hiilihydraatti");
		String syoteRasva = request.getParameter("rasva");
		
		//haetaan viimeksi syötetyn juoman numero kannasta

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
		
		response.sendRedirect("admin?added=true");
	}
	
}
