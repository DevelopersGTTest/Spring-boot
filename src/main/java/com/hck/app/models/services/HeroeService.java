package com.hck.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hck.app.models.dao.HeroesRepository;
import com.hck.app.models.entity.Heroes;

@Service
public class HeroeService implements IHeroe {
	
	@Autowired
	private HeroesRepository heroesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Heroes> findAll() {
		// TODO Auto-generated method stub
		return  (List<Heroes>) heroesDao.findAll() ;
	}

	@Override
	public Heroes findById(Long id) {
		// TODO Auto-generated method stub
		return heroesDao.findById(id)
				.orElse(null);
	}

	@Override
	public Heroes save(Heroes heroes) {
		// TODO Auto-generated method stub
		return heroesDao.save(heroes);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		heroesDao.deleteById(id);
	}

}
