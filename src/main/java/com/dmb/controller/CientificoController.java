package com.dmb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dmb.entities.Cientifico;
import com.dmb.entities.Proyecto;
import com.dmb.service.CientificoService;
import com.dmb.service.ProyectoService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class CientificoController {

	@Autowired
	private CientificoService serv;
	
	private ProyectoService proyetoServ;
	
	@Autowired
    private EntityManager entityManager;

	
	@GetMapping("/cientificos")
	public ResponseEntity<List<Cientifico>> getAllCientifico() {
		return ResponseEntity.ok(serv.getAllCientifico());
	}
	@GetMapping("/cientifico/{id}")
	public ResponseEntity<Cientifico> getOneCientifico(@PathVariable(name = "id") String id) {
		 Optional<Cientifico> entity = serv.getOneCientifico(id);

		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/cientifico")
	
	public ResponseEntity<Cientifico> saveCientifico(@RequestBody Cientifico entity) {
		return ResponseEntity.ok(serv.createCientifico(entity));
	}
	
	@PutMapping("/cientifico/{id}")
	public ResponseEntity<Cientifico> updateCientifico(@PathVariable(name = "id") String id, @RequestBody Cientifico entity) {
		Optional<Cientifico> entityOld = serv.getOneCientifico(id);
		if (entityOld.isPresent()) {	
			serv.createCientifico(entity);
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/cientifico/{id}")
	public ResponseEntity<Void> deleteCientifico(@PathVariable(name = "id") String id) { 
		Optional<Cientifico> entity = serv.getOneCientifico(id);
		if (entity.isPresent()) {
			serv.deleteCientifico(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/cientifico-proyecyo/{id}")
	@Transactional
	public ResponseEntity<String> salvarEstudianteCurso(@RequestBody Cientifico cientifico, @PathVariable(name="id")String id) {
	
	    Optional<Proyecto> proyecto = proyetoServ.getOneProyecto(id);
		
		if (proyecto.isPresent()) {
			
			 serv.createCientifico(cientifico);
			 cientifico.getProyecyos().add(proyecto.get());
			 entityManager.persist(cientifico);
		     entityManager.persist(proyecto.get());
			 
		   return ResponseEntity.ok("Estudiante asociado con éxito al curso");
		   
		} else {
			
			return ResponseEntity.status(404).body("Estudiante debe asociarse aun proyeto existente");
		}
		
	 
	     
	}
}
