package fi.pizzablue.tyontekija.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;

	


	public class HaeTilausDAO {
		
		public void haeTilaukset(Tilaus tilaus, Connection yhteys) throws DAOPoikkeus {

			try {
				String sql = "SELECT t.id, t.aikaleima, COUNT(p.pizza_id) AS pizzamaara, t.kotiinkuljetus FROM tilaus t JOIN pizzarivi p ON t.id = p.tilaus_id GROUP BY t.id ORDER BY t.id DESC;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int tilausId = tulokset.getInt("t.id");
					Date aikaleima = tulokset.getDate("t.aikaleima");
					int pizzaid = tulokset.getInt("pizzamaara");
					boolean kotiinkuljetus = tulokset.getBoolean("t.kotiinkuljetus");
					
			//lisätään tilaus listaan
					//Tilaus tilaus = new Tilaus();
					//pizzat.add(p);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilaukset: " + tilaus.toString());
				
		}

	} 
