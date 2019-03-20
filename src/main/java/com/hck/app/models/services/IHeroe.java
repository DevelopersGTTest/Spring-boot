package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Heroes;

public interface IHeroe {
	
	public List<Heroes> findAll();
	
	public Heroes findById(Long id);
	
	public Heroes save(Heroes heroes);
	
	public void delete(Long id);

}
