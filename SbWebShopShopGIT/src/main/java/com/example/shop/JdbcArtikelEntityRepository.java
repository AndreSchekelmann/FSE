package com.example.shop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcArtikelEntityRepository 
	extends CrudRepository<ArtikelEntity, Integer> {

}
