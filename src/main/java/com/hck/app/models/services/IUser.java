package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Users;

public interface IUser {
	
	public List<Users> findAll();
	
	public Users findByIdUser(Long id );
	
	public Users save(Users users);
	
	public void delete(Long id );
	
	//Get Data Users For Token
	public Users findByUsername(String username );

}
