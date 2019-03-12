package com.hck.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;;

@Entity
@Table(name = "heroes")
public class heroes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	private String Power;
	
	private Integer Popularity;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return Power;
	}
	public void setPower(String power) {
		Power = power;
	}
	public Integer getPopularity() {
		return Popularity;
	}
	public void setPopularity(Integer popularity) {
		Popularity = popularity;
	}
	
	
	
	

}
