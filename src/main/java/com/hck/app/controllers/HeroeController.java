package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Heroes;
import com.hck.app.models.services.HeroeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class HeroeController {
	
	@Autowired
	private HeroeService heroeService;
	
	@GetMapping("/heroes")
	public List<Heroes> index(){
		
		return heroeService.findAll();
	}
	
	@GetMapping("/heroes/{id}")
	public ResponseEntity<?> showHeroes(@PathVariable Long id ) {
		
		Heroes heroes = null;
		
		try {
			heroes = heroeService.findById(id);
		}catch(DataAccessException e) {
			return new ResponseEntity<>("{ \"message\" : \"DB Errors\"}"
					.concat(e.getMostSpecificCause().getMessage()),
						HttpStatus.CONFLICT);
		}
		
		if(heroes == null) {
			 return new ResponseEntity<>("{ \"message\" : \"Debe enviar un id valido\"}",
					 HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Heroes>(heroes, HttpStatus.OK);
	}
	
	@PostMapping("/heroes")
	public Heroes storedHeroe(@RequestBody Heroes heroes ) {
		return heroeService.save(heroes);
	}
	
	@PutMapping("/heroes/{id}")
	public Heroes updateHero(@RequestBody Heroes heroe, @PathVariable Long id ) {
		
		Heroes heroeDB = heroeService.findById(id);
		
		heroeDB.setName(heroe.getName());
		heroeDB.setPopularity(heroe.getPopularity());
		heroeDB.setPower(heroe.getPower());
		
		return heroeService.save(heroeDB);
	}
	
	@DeleteMapping("/heroes/{id}")
	public void deleteHero(@PathVariable Long id) {
		heroeService.delete(id);
		//implements https://stackoverflow.com/questions/30895286/spring-mvc-how-to-return-simple-string-as-json-in-rest-controller
	}
	
}
