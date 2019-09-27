package com.hck.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hck.app.models.entity.Heroes;

public interface HeroesRepository extends CrudRepository<Heroes, Long > {
	//moving a JPQL
}
