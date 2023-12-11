package com.example.shop;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DbArtikelRepository implements ArtikelRepository {
	
	private final JdbcArtikelEntityRepository jdbcArtikelEntityRepository;
	
	@Autowired
	public DbArtikelRepository(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
		this.jdbcArtikelEntityRepository = jdbcArtikelEntityRepository;
}


	@Override
	public Artikel findById(ArtikelId artikelId) {
		  Optional<ArtikelEntity> artikelEntity = jdbcArtikelEntityRepository.findById(artikelId.getId());
	        if (artikelEntity.isPresent()) {
	            return artikelEntity.get().toDomain();
	        } else {
	            return null;
	        }
	}

	@Override
	public void save(Artikel artikel) {
		jdbcArtikelEntityRepository.save(new ArtikelEntity(artikel));

	}

	

}