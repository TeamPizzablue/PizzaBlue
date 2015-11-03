package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Juoma;

public class JuomaDAO {
	

	
	//Hakee pizzat kannasta 
	public List<Juoma> haeJuomat(Connection yhteys) throws DAOPoikkeus{		
		
		ArrayList<Juoma> juomat = new ArrayList<Juoma>();
		
		try {
			
			//suoritetaan haku
			String sql = "select j.id, j.numero, j.nimi, j.maara, j.hinta, j.energia, j.proteiini, j.hiilihydraatti, j.rasva from juoma j;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				int id = tulokset.getInt("j.id");
				int numero = tulokset.getInt("j.numero");
				String nimi = tulokset.getString("j.nimi");
				int maara = tulokset.getInt("j.maara");
				double hinta = tulokset.getDouble("j.hinta");
				int energia = tulokset.getInt("j.energia");
				double proteiini = tulokset.getDouble("j.proteiini");
				double hiilihydraatti = tulokset.getDouble("j.hiilihydraatti");
				double rasva = tulokset.getDouble("j.rasva");
				
				
				//lisätään pizza listaan
				Juoma j = new Juoma(id, numero, nimi, maara, hinta, energia, proteiini, hiilihydraatti, rasva);
				juomat.add(j);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA JUOMAT: " + juomat.toString());
		
		return juomat;
	}
}
