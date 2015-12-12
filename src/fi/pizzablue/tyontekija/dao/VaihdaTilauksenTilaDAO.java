package fi.pizzablue.tyontekija.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import fi.pizzablue.dao.DAOPoikkeus;

public class VaihdaTilauksenTilaDAO {

	public void paivitaTilauksenTilaValmistetuksi(int tilausId, Connection yhteys) throws DAOPoikkeus {

		try {
			String sql = "UPDATE tilaus SET tila_id=2 WHERE id=?";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			//täytetään puuttuvat tiedot
			lause.setInt(1, tilausId);

			//suoritetaan lause
			lause.executeUpdate();
			
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan päivitys aiheutti virheen: ", e);
		} 

		System.out.println("Vaihdettiin tilauksen " + tilausId + " tila kohtaan: valmistettu");
	}
	public void paivitaTilauksenTilaMaksetuksi(int tilausId, Connection yhteys) throws DAOPoikkeus {

		try {
			String sql = "UPDATE tilaus SET tila_id=3 WHERE id=?";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			//täytetään puuttuvat tiedot
			lause.setInt(1, tilausId);

			//suoritetaan lause
			lause.executeUpdate();

		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan päivitys aiheutti virheen: ", e);
		} 
		System.out.println("Vaihdettiin tilauksen " + tilausId + " tila kohtaan: maksettu");
	}
} 
