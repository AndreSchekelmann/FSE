package com.example.shop;

import org.springframework.data.annotation.Id;
public class ArtikelEntity {

	@Id
	int id;
	int preis;
	int bestand;
	
	public ArtikelEntity() {	
	}
	
	public ArtikelEntity(int id, int preis, int bestand) {
		super();
		this.id = id;
		this.preis = preis;
		this.bestand = bestand;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}
	public int getBestand() {
		return bestand;
	}
	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	public ArtikelEntity (Artikel artikel) {
		this.id = artikel.getArtikelId().getId();
		this.bestand = artikel.getBestand();
		this.preis = artikel.getPreis();	
		}
	
	public Artikel toDomain() {
		return new Artikel (new ArtikelId (id), bestand, preis);
		
	}
	
	
	
	
}