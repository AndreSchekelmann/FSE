package com.example.lager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lager")
public class LagerController {
	
	private LagerService lagerService;
	
	public LagerController (LagerService lagerService) {
		this.lagerService = lagerService;
	}
	
	   
	@GetMapping("/artikel/{id}")
	public String bestandErmitteln(@PathVariable int id) {	
	    	return lagerService.bestandErmitteln(id)+"";
	}
	
	
	@PutMapping("/artikel/{id}/{menge}")
	public String einlagern(@PathVariable int id, @PathVariable int menge) {
		if (lagerService.artikelEinlagern( id, menge))
				return "Einlagerung erfolgreich!";
			else
				return "Einlagerung nicht erfolgreich!";
	}
	    

}
