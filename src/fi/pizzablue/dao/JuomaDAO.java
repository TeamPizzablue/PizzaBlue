package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;

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
				
				
				//lisätään juoma listaan
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
	
	public Juoma haeYksiJuoma(int id, Connection yhteys) throws DAOPoikkeus {
		Juoma j = null;
		
		try {
			
			//suoritetaan haku
			String sql = "select j.id, j.numero, j.nimi, j.maara, j.hinta, j.energia, j.proteiini, j.hiilihydraatti, j.rasva from juoma j where j.id = ?;";
			PreparedStatement haku = yhteys.prepareStatement(sql);
			haku.setInt(1, id);
			ResultSet tulokset = haku.executeQuery();
			
			//käydään hakutulokset läpi
			if(tulokset.next()) {
				int numero = tulokset.getInt("j.numero");
				String nimi = tulokset.getString("j.nimi");
				int maara = tulokset.getInt("j.maara");
				double hinta = tulokset.getDouble("j.hinta");
				int energia = tulokset.getInt("j.energia");
				double proteiini = tulokset.getDouble("j.proteiini");
				double hiilihydraatti = tulokset.getDouble("j.hiilihydraatti");
				double rasva = tulokset.getDouble("j.rasva");
				
				j = new Juoma(id, numero, nimi, maara, hinta, energia, proteiini, hiilihydraatti, rasva);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA JUOMA: " + j.toString());
		
		return j;
	}
	public void lisaa(Juoma j, Connection yhteys) throws DAOPoikkeus{
		
		
		try {
			//suoritetaan haku
			//alustetaan sql-lause. HUOM! values kohdassa tulee olla (?,?) muuten sovellus on haavoittuvainen, sillä sqllää voi syöttää syötekenttiin
			//älä ikinä katenoi käyttäjien syöttämiä tietoja sql komentoihin!
			String sql = "insert into juoma(numero, nimi, maara, hinta, energia, proteiini, hiilihydraatti, rasva) values(?,?,?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			lause.setInt(1, j.getNumero());
			lause.setString(2, j.getNimi());
			lause.setInt(3, j.getMaara());
			lause.setDouble(4, j.getHinta());
			lause.setDouble(5, j.getEnergia());
			lause.setDouble(6, j.getProteiini());
			lause.setDouble(7, j.getHiilihydraatti());
			lause.setDouble(8, j.getRasva());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("Lisättiin tietokantaan juoma: "+ j);
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Juoman lisäämisyritys aiheutti virheen", e);
		} 

	}
	public void poista(Juoma j, Connection yhteys) throws DAOPoikkeus{

		try {
			
			//suoritetaan haku
			
			//alustetaan sql-lause, huom pitää olla ? ja seuraavassa kohtaa täydennetään tiedot
			String sql = "delete from juoma where id = ?";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			lause.setInt(1, j.getId());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("Poistettiin tietokannasta juoma: "+ j);
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Juoman lisäämisyritys aiheutti virheen", e);
		} 
		

	}
}
