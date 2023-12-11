package com.example.shop;

public class BestellId {
	
	int id;

	public BestellId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	
	public boolean equals (Object o) {
		BestellId a = (BestellId)o;
		return (this.id == a.id);
	}
	
	public int hashCode() {
		return this.id; 
	}
	
}
