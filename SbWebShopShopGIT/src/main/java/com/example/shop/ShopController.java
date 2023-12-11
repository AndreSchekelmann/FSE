package com.example.shop;



import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/shop")
public class ShopController {

	
	private ShopService shopService;
	
	public ShopController (ShopService shopService) {
		this.shopService = shopService;
	}
			
	@GetMapping("artikel/{id}")
	public String artikel (@PathVariable ("id") int id) {
		return shopService.zeigeBestand(id);
	}
	
	/*
	 * curl -X POST http://localhost:8080/shop/bestellung -H "Content-Type:application/json" -d "[{ \"id\":4711,\"menge\":10} , {\"id\":4712, \"menge\":10}]
	 */
	@PostMapping(value = "/bestellung", consumes = {"application/json"})
	public String bestellen(@RequestBody Collection<BestellItemTO> itemliste) {
		
		if (shopService.bestellen(itemliste))
			return "Bestellung erfolgreich";
		else
			return "Bestellung nicht erfolgreich";
			
	    	
	 }

}
