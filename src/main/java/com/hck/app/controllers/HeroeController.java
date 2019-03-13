package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Heroes;
import com.hck.app.models.services.HeroeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class HeroeController {
	
	@Autowired
	private HeroeService heroeService;
	
	@GetMapping("/heroes")
	public List<Heroes> index(){
		
		return heroeService.findAll();
	}
	
}
