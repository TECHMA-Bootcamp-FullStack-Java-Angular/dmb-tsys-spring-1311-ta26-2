package com.dmb.service;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Cientifico;

public interface IServiceCientifico {

	//CRUD 

	//Read All
	public List<Cientifico> getAllCientifico();

	//Read One
	public Optional<Cientifico> getOneCientifico(String id); 
	//Create

	public Cientifico createCientifico(Cientifico entity);

	//Update
	public Cientifico updateCientifico(Cientifico entity);

	//Delete
	public void deleteCientifico(String id); 

}
