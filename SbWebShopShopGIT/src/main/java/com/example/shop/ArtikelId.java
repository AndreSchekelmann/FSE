package com.example.shop;

public class ArtikelId {
int id;

	
	public ArtikelId(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	
	public boolean equals (Object o) {
		ArtikelId a = (ArtikelId)o;
		return (this.id == a.id);
	}
	
	public int hashCode() {
		return this.id; 
	}
	

}
