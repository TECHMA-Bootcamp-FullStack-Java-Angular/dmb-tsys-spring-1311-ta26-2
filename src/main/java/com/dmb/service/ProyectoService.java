package com.dmb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Proyecto;
import com.dmb.repository.ProyectoDAO;

@Service
public class ProyectoService  implements IServiceProyecto{
	
	@Autowired
	private ProyectoDAO dao;

	@Override
	public List<Proyecto> getAllProyecto() {
		return dao.findAll();
	}

	@Override
	public Optional<Proyecto> getOneProyecto(String id) {
		return dao.findById(id);
	}

	@Override
	public Proyecto createProyecto(Proyecto entity) {
		return dao.save(entity);
	}

	@Override
	public Proyecto updateProyecto(Proyecto entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteProyecto(String id) {
		dao.deleteById(id);
	}

}
