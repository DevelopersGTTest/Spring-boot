package com.hck.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hck.app.models.dao.UsersRepository;
import com.hck.app.models.entity.Users;

@Service
public class UserService implements IUser  {

	@Autowired
	private UsersRepository userDao;
	
	
	
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return (List<Users>) userDao.findAll();
	}

	@Override
	public Users findByIdUser(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id)
				.orElse(null);
	}

	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		return userDao.save(users);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
