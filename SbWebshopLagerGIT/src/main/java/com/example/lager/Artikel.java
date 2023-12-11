package com.example.lager;

public class Artikel {
	
	ArtikelId artikelId;
	int bestand;
	int gewicht;
	int volumen;
	
	public Artikel (ArtikelId artikelId, int bestand, int gewicht, int volumen) {
		this.artikelId = artikelId;
		this.bestand = bestand;
		this.gewicht = gewicht;
		this.volumen = volumen;
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
		
	public int getBestand () {
		return bestand;
	}
	
	public void setGewicht (int gewicht) {
		this.gewicht = gewicht;
	}
	
	public int getGewicht () {
		return gewicht;
	}
	
	public void setVolumen (int volumen) {
		this.volumen = volumen;
	}
	
	public int getVolumen() {
		return volumen;
	}
	
	public boolean equals (Object o) {
		Artikel a = (Artikel)o;
		return (this.artikelId == a.artikelId);
	}
	
	public int hashCode() {
		return artikelId.getId(); 
	}

}
