package com.example.lager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

	
	 @Bean
	 LagerService lagerService(ArtikelRepository artikelRepository) {
	        return new LagerApplicationService(artikelRepository);
	 } 
	 
	 @Bean
	 EventListener eventListener(LagerService lagerService) {
			return new EventListener(lagerService);
	 };
	 
	 
	 @Bean
	 ArtikelRepository artikelRepository(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
	        return new DbArtikelRepository(jdbcArtikelEntityRepository);
	 }
	
	 	
}

