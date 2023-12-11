package com.example.lager;

public class BestellItemTO {
		
	int id;
	int menge;
	
	public BestellItemTO() {
		
	}
	
	public BestellItemTO(int id, int menge) {
		this.id = id;
		this.menge = menge;
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
}
