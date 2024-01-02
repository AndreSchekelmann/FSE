package com.example.shop;

public class BestellItemTO {
	
	int id;
	int menge;
	
	public BestellItemTO() {
	}  
	
	public BestellItemTO(int id, int menge) {
		this.id = id;
		this.menge = menge;
	}
	
	public BestellItemTO(BestellItem bestellItem) {
		this.id = bestellItem.getArtikelId().getId();
		this.menge = bestellItem.getMenge();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	public BestellItem toDomain() {
		return new BestellItem(new ArtikelId(this.id), this.menge);
	}
	
}
