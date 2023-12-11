package com.example.shop;

public class Artikel {
	
	ArtikelId artikelId;
	int bestand;
	int preis;
	
	
	public Artikel (ArtikelId artikelId, int bestand, int preis) {
		this.artikelId = artikelId;
		this.bestand = bestand;	
		this.preis = preis;
	}
	
	public Artikel (ArtikelId artikelId, int bestand) {
		this.artikelId = artikelId;
		this.bestand = bestand;
	}
	public ArtikelId getArtikelId () {
		return artikelId;
	}
	
	public void einlagern (int menge) {
		bestand += menge;
	}
	
	public boolean auslagern (int menge) {
		
		if (bestand >= menge) {
			bestand -= menge;
			return true;
		}
		
		return false;
	}
	
	public String bewerteBestand() {
	
		int bestand = this.getBestand();
 	
 	if (bestand > 50)
		return "grün";
	else
		return "rot";
	}
	
	public int getBestand () {
		return bestand;
	}
	
	public void setPreis (int preis) {
		this.preis = preis;
	}
	
	public int getPreis () {
		return this.preis;
	}
	
	public boolean equals (Object o) {
		Artikel a = (Artikel)o;
		return (this.artikelId == a.artikelId);
	}
	
	public int hashCode() {
		return artikelId.getId(); 
	}

}
