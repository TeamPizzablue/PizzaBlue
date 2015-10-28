package fi.pizzablue.bean;

import java.awt.List;
import java.util.ArrayList;

public class Ostoskori {

	private ArrayList ostoskorinTuotteet = new ArrayList();
	private double kokonaishinta;

	public int tuotteidenMaara() {
		return ostoskorinTuotteet.size();
	}

	public void poistaOstoskorista(String tuotenumero) {
		int numero = 0;
		try {
			numero = Integer.parseInt(tuotenumero);
			ostoskorinTuotteet.remove(numero - 1);
			laskeKokonaishinta();
		} catch(NumberFormatException nfe) {
			System.out.println("Virhe poistettaessa ostoskorista tuotetta " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	/* public void updateCartItem(String strItemIndex, String strQuantity) {
	  double dblTotalCost = 0.0;
	  double dblUnitCost = 0.0;
	  int iQuantity = 0;
	  int iItemIndex = 0;
	  CartItemBean cartItem = null;
	  try {
	   iItemIndex = Integer.parseInt(strItemIndex);
	   iQuantity = Integer.parseInt(strQuantity);
	   if(iQuantity>0) {
	    cartItem = (CartItemBean)alCartItems.get(iItemIndex-1);
	    dblUnitCost = cartItem.getUnitCost();
	    dblTotalCost = dblUnitCost*iQuantity;
	    cartItem.setQuantity(iQuantity);
	    cartItem.setTotalCost(dblTotalCost);
	    calculateOrderTotal();
	   }
	  } catch (NumberFormatException nfe) {
	   System.out.println("Error while updating cart: "+nfe.getMessage());
	   nfe.printStackTrace();
	  }

	 }*/

	public void lisaaOstoskoriin(String id, String nimi, String hinta, String maara) {
		int tuotteenId = 0;
		double yksikkohinta = 0.00;
		int kokonaismaara = 0;
		OstoskorinTuote tuote = new OstoskorinTuote();

		try {
			yksikkohinta = Double.parseDouble(hinta);
			kokonaismaara = Integer.parseInt(maara);
			tuotteenId = Integer.parseInt(id);
			if (kokonaismaara > 0) {
				tuote.setId(tuotteenId);
				tuote.setNimi(nimi);
				tuote.setHinta(yksikkohinta);
				tuote.setMaara(kokonaismaara);
				ostoskorinTuotteet.add(tuote);
				laskeKokonaishinta();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types: "+nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void addCartItem(OstoskorinTuote tuote) {
		ostoskorinTuotteet.add(tuote);
	}

	public OstoskorinTuote haeTuote(int tuoteId) {
		OstoskorinTuote tuote = null;
		if(ostoskorinTuotteet.size() > tuoteId) {
			tuote = (OstoskorinTuote) ostoskorinTuotteet.get(tuoteId);
		}
		return tuote;
	}

	public ArrayList haeTuotteet() {
		return ostoskorinTuotteet;
	}

	public void setCartItems(ArrayList alCartItems) {
		this.ostoskorinTuotteet = alCartItems;
	}

	public double getOrderTotal() {
		return kokonaishinta;
	}

	public void setOrderTotal(double dblOrderTotal) {
		this.kokonaishinta = dblOrderTotal;
	}

	protected void laskeKokonaishinta() {
		double kokonaishinta = 0;
		for(int i= 0; i < ostoskorinTuotteet.size(); i++) {
			OstoskorinTuote tuote = (OstoskorinTuote) ostoskorinTuotteet.get(i);
			kokonaishinta += tuote.getHinta();
		}
		setOrderTotal(kokonaishinta);
	}
}
