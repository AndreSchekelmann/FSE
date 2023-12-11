package com.example.shop;

public class ShopDomainService {
	
	ArtikelRepository artikelRepository;
	MessageQueue messageQueue;
	
	public ShopDomainService (ArtikelRepository artikelRepository, MessageQueue messageQueue) {
		this.artikelRepository = artikelRepository;
		this.messageQueue = messageQueue;
	}
	
	public boolean bestandArtikelAktualisieren (Bestellung bestellung) {
		
		
		boolean alleArtikelGefunden = true;
		boolean alleArtikelVerfuegbar = true;
		
		for (BestellItem item: bestellung.getItems()) {
				Artikel artikel = artikelRepository.findById(item.getArtikelId());
 			
 	 		if (artikel == null) {
 	 			alleArtikelGefunden = false;
 	 		}
 	 		else if (!artikel.auslagern(item.getMenge()))
 	 			alleArtikelVerfuegbar = false;
		}
		
		if (alleArtikelGefunden && alleArtikelVerfuegbar){
			
			for (BestellItem item: bestellung.getItems()) {
				Artikel artikel = artikelRepository.findById(item.getArtikelId());
				artikel.auslagern(item.getMenge());
				artikelRepository.save(artikel);
			}
			
 	 		
			DomainEvent bestellungAbgeschlossen = new DomainEvent ("bestellungAbgeschlossen", bestellung); 
			messageQueue.send(bestellungAbgeschlossen);
			
			return true;
		}
		
		return false;
		
	}
}

