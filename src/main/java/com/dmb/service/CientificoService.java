package com.dmb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Cientifico;
import com.dmb.repository.CientificoDAO;

@Service
public class CientificoService implements IServiceCientifico {

	@Autowired
	private CientificoDAO dao;

	@Override
	public List<Cientifico> getAllCientifico() {
		return dao.findAll();
	}

	@Override
	public Optional<Cientifico> getOneCientifico(String id) {
		return dao.findById(id);
	}

	@Override
	public Cientifico createCientifico(Cientifico entity) {
		return null;
	}

	@Override
	public Cientifico updateCientifico(Cientifico entity) {
		return null;
	}

	@Override
	public void deleteCientifico(String id) {
		
	}
}
