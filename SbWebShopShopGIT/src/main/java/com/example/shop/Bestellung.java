package com.example.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Bestellung {
	
	BestellId id;
	LocalDate bestelldatum;
	Collection<BestellItem> items;
	
	
	public Bestellung(int id) {
		this.id = new BestellId(id);
		this.bestelldatum = LocalDate.now();;
		this.items = new ArrayList<BestellItem>();
	}
	
	public void addItem (BestellItem item) {
		this.items.add(item);
	}
	
	public LocalDate getBestelldatum() {
		return bestelldatum;
	}
	public void setBestelldatum(LocalDate bestelldatum) {
		this.bestelldatum = bestelldatum;
	}
	public Collection<BestellItem> getItems() {
		return items;
	}
	public void setItems(Collection<BestellItem> items) {
		this.items = items;
	}
	public BestellId getId() {
		return id;
	}
	
	
	

}
