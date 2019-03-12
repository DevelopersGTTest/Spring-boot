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

}
