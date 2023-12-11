package com.example.lager;

import java.util.Collection;

public interface LagerService {

	public boolean artikelEinlagern(int id, int menge);
	public boolean artikelAuslagern(int id, int menge);
	public int bestandErmitteln(int Id);
	public boolean bestellungVerarbeiten (Collection<BestellItemTO> bestelllisteTO);
	
}
