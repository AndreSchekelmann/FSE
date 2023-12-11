package com.example.lager;

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
//	@Autowired
//	public DbArtikelRepository() {
//	}
	
	
//	public Artikel findById(ArtikelId artikelId) {
//		if (artikelId.getId() == 1) {
//			ArtikelEntity artikelEntity = new ArtikelEntity();
//			artikelEntity.setId(1);
//			artikelEntity.setBestand(4713);
//			return artikelEntity.toDomain();
//		}
//		else return null;
//		
//	}

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