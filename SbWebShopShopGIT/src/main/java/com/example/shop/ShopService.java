package com.example.shop;

import java.util.Collection;

public interface ShopService {
	
	public boolean bestellen(Collection<BestellItemTO> itemliste);
	public String zeigeBestand(int id);


}
