package fi.pizzablue.mail;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.bean.Tilausrivi;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.service.TilausIdService;

public class TilausvahvistusMail {
    
	 private static String USER_NAME = "teamblue297";  // GMail user name (just the part before "@gmail.com")
	 private static String PASSWORD = "AnssiIirisJennaMimosaSofiaSusanna"; // GMail password
	
		public void sendFromGMail(Tilaus tilaus) {
			
		DecimalFormat dec = new DecimalFormat("0.00");
		
		TilausIdService tidService = new TilausIdService();
		
		int tilausId = 0;
		
		List<Tilausrivi> tilausrivit = tilaus.getTilausrivit();
		
		String tuotteet = "";
		
		for(int i=0; i < tilausrivit.size(); i++) {
			if(tilausrivit.get(i) instanceof Pizzarivi) {
				Pizzarivi pizzarivi = (Pizzarivi)tilausrivit.get(i);
				tuotteet += pizzarivi.getPizza().getNumero() + ". " + pizzarivi.getPizza().getNimi() + " " + dec.format(pizzarivi.getPizza().getHinta()) + " € " + "\n"; 
			} else {
				Juomarivi juomarivi = (Juomarivi)tilausrivit.get(i);
				tuotteet += juomarivi.getJuoma().getNumero() + ". " + juomarivi.getJuoma().getNimi() +  " " + dec.format(juomarivi.getJuoma().getHinta()) + " €" + "\n";
			}
		}
		
		
			try {
				tilausId = tidService.haeTilausId();
			} catch (DAOPoikkeus e) {
				e.printStackTrace();
			}
		

		        String from = USER_NAME;
		        String pass = PASSWORD;
		        String to = tilaus.getSahkoposti();
		        String subject = "Tilausvahvistus";
		        String body = "Kiitos tilauksestasi!" + "\n\n" +
		        		"Tässä tilauksesi tiedot:" + "\n\n" +
		        		"Tilausnumero: " + tilausId + "\n\n" +
		        		"Tuotteet" + "\n\n" + tuotteet + "\n\n" +
		        		"Yhteishinta: " + dec.format(tilaus.getHinta()) + " €" + "\n" +
						"\nYstävällisin terveisin, " + "\n\nPizza Blue";
		        
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
		            InternetAddress toAddress = new InternetAddress(to);
		            
		            message.addRecipient(Message.RecipientType.TO, toAddress);

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
