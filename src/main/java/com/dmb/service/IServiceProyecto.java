package com.dmb.service;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Proyecto;

public interface IServiceProyecto {
	
	//CRUD 

	//Read All
	public List<Proyecto> getAllProyecto();

	//Read One
	public Optional<Proyecto> getOneProyecto(String id); 
	//Create

	public Proyecto createProyecto(Proyecto entity);

	//Update
	public Proyecto updateProyecto(Proyecto entity);

	//Delete
	public void deleteProyecto(String id);

}
