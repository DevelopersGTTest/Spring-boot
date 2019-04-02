package com.hck.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hck.app.models.entity.Users;

public interface UsersRepository extends CrudRepository<Users , Long >  {

}
