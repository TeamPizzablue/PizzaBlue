package fi.pizzablue.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackMail")
public class FeedbackMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeedbackMail() {
        super();
    }
    
	 private static String USER_NAME = "teamblue297";  // GMail user name (just the part before "@gmail.com")
	 private static String PASSWORD = "AnssiIirisJennaMimosaSofiaSusanna"; // GMail password
	 private static String RECIPIENT = "teamblue297@gmail.com";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WebContent/WEB-INF/jsp/frontpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nimi = request.getParameter("nimi");
		String puhelin = request.getParameter("puhelinumero");
		String sahkoposti = request.getParameter("sahkoposti");
		String viesti = request.getParameter("viesti");
		
		
		response.sendRedirect("http://proto297.haaga-helia.fi:8080/pizzablue/palauteVastaus.jsp");

		        String from = USER_NAME;
		        String pass = PASSWORD;
		        String[] to = { RECIPIENT };
		        String subject = "Palautetta Pizza Bluen sivuilta";
		        String body = viesti + "\n" +
						"\nTerveisin, " +nimi+ "\n" + puhelin + "\n" + sahkoposti;

		        sendFromGMail(from, pass, to, subject, body);
		        
	}

		    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
		        Properties props = System.getProperties();
		        String host = "smtp.gmail.com";
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.user", from);
		        props.put("mail.smtp.password", pass);
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");

		        Session session = Session.getDefaultInstance(props);
		        MimeMessage message = new MimeMessage(session);

		        try {
		            message.setFrom(new InternetAddress(from));
		            InternetAddress[] toAddress = new InternetAddress[to.length];

		            // To get the array of addresses
		            for( int i = 0; i < to.length; i++ ) {
		                toAddress[i] = new InternetAddress(to[i]);
		            }

		            for( int i = 0; i < toAddress.length; i++) {
		                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		            }

		            message.setSubject(subject);
		            message.setText(body);
		            Transport transport = session.getTransport("smtp");
		            transport.connect(host, from, pass);
		            transport.sendMessage(message, message.getAllRecipients());
		            transport.close();
		        }
		        catch (AddressException ae) {
		            ae.printStackTrace();
		        }
		        catch (MessagingException me) {
		            me.printStackTrace();
		        }
		        
		        System.out.println("Lähetetty!");
		    }
	}
