package fi.pizzablue.admin.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.JuomalistaService;
import fi.pizzablue.service.PizzalistaService;



@WebServlet(urlPatterns={"/admin.jsp","/admin"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//otetaan käyttäjätiedot sessiosta
		Kayttaja user = (Kayttaja) request.getSession().getAttribute(SiteController.SESSION_ATTR_WEBUSER);

		if (user == null) { //jos käyttäjätietoja ei löydy, heitetään etusivulle
			request.getRequestDispatcher(SiteController.FRONT_PAGE).forward(request, response);
		} else {// mikäli käyttäjätiedot löytyvät, päästetään sisään
	
			List<Pizza> pizzat;
			List<Juoma> juomat;
		
			try {
				PizzalistaService pService = new PizzalistaService();
				JuomalistaService jService = new JuomalistaService();
				juomat = jService.haeJuomalista();
				pizzat = pService.haePizzalista();
			} catch(DAOPoikkeus e) {
				throw new ServletException(e);
			}
		
			//asetetaan listat requestin attribuuteiksi
			request.setAttribute("pizzat", pizzat);
			request.setAttribute("juomat", juomat);
		
			//siirretään request list.jsplle
			request.getRequestDispatcher("WEB-INF/jsp/admin/admin.jsp").forward(request, response);
		}
	}
}
