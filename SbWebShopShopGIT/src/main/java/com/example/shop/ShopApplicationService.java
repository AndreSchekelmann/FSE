package com.example.shop;

import java.util.Collection;


public class ShopApplicationService implements ShopService{

	
	private ArtikelRepository artikelRepository;
	private ShopDomainService shopDomainService;
	
	public ShopApplicationService (ArtikelRepository artikelRepository, ShopDomainService shopDomainService) {
		this.shopDomainService = shopDomainService;
		this.artikelRepository = artikelRepository;
	}
	
	
	// In dieser Klasse müsste viel mehr passieren:
	// Zahlungsabwicklung anstoßen
	// Lieferungsweg klären
	// ...
	
	
	public String zeigeBestand(int id) {
		
		Artikel artikel = artikelRepository.findById(new ArtikelId(id));
			
	 	if (artikel == null)
	 		return "-1";
	 	
	 	return artikel.bewerteBestand();
	}
	
	
	@Override
	public boolean bestellen(Collection<BestellItemTO> itemliste) {
		// Es folgt ein Dummy Implementierung
		// insb. ist 4711 eine Dummy-Bestellnummer, hier müsste die nächste Bestellnummer ermittelt werden
			Bestellung bestellung = new Bestellung (4711);
			for (BestellItemTO item: itemliste)
				bestellung.addItem(item.toDomain());

		// Hier wird der Bestand im Webshop entsprechend reduziert
			
			return shopDomainService.bestandArtikelAktualisieren(bestellung);
			
		
	}
	
	


}
