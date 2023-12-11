package com.example.shop;

public class BestellItem {
	
	ArtikelId artikelId;
	int menge;
	
	public BestellItem(ArtikelId artikelId, int menge) {
		super();
		this.artikelId = artikelId;
		this.menge = menge;
	}

	public ArtikelId getArtikelId() {
		return artikelId;
	}
	
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}

	
	

}
