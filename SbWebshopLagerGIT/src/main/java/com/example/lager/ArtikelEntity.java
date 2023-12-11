package com.example.lager;

import org.springframework.data.annotation.Id;


public class ArtikelEntity {

	@Id
	int id;
	int bestand;
	int gewicht;
	int volumen;
	
	public ArtikelEntity() {
		
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getBestand() {
		return bestand;
	}



	public void setBestand(int bestand) {
		this.bestand = bestand;
	}



	public int getGewicht() {
		return gewicht;
	}



	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}



	public int getVolumen() {
		return volumen;
	}



	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}



	public ArtikelEntity (Artikel artikel) {
		this.id = artikel.getArtikelId().getId();
		this.bestand = artikel.getBestand();
		this.gewicht = artikel.getGewicht();
		this.volumen = artikel.getVolumen();
	}
	
	public Artikel toDomain() {
		return new Artikel (new ArtikelId (id), bestand, gewicht, volumen);
		
	}
	
	
	
	
}