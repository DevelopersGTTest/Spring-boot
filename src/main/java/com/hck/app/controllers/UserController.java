package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Users;
import com.hck.app.models.services.UserService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<Users> index(){
		return userService.findAll();	
	} 
	
	@PostMapping("/users")
	public ResponseEntity<?> storedUser(@RequestBody Users user ){
		
		Users newUser = null;
		
		try {
			
			newUser = userService.save(user);
			
		}catch(DataAccessException e ) {
			
			return new ResponseEntity<>("{ \"message\" : \"DB Errors\"}"
					.concat(e.getMostSpecificCause().getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Users>(newUser, HttpStatus.CREATED);
	}   

	
	
}
