package com.example.shop;


public interface ArtikelRepository {
	
	public Artikel findById(ArtikelId artikelId);
	public void save(Artikel artikel);

}
