package com.example.lager;

public interface ArtikelRepository {
	
	public Artikel findById(ArtikelId artikelId);
	public void save(Artikel artikel);

}
