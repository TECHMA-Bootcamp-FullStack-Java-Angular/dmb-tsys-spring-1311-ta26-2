package com.dmb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Proyecto;
import com.dmb.service.ProyectoService;

@RestController
@RequestMapping("api/v1")
public class ProyectoController {
	
	@Autowired
	private ProyectoService serv;
	
	@GetMapping("/proyectos")
	public ResponseEntity<List<Proyecto>> getAllProyecto() {
		return ResponseEntity.ok(serv.getAllProyecto());
	}

	@GetMapping("/proyecto/{id}")
	public ResponseEntity<Proyecto> getOneProyecto(@PathVariable(name = "id") String id) { 
		Optional<Proyecto> entity = serv.getOneProyecto(id);

		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/proyecto")
	public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto entity) {
		return ResponseEntity.ok(serv.createProyecto(entity));
	}
	
	
	@PutMapping("/proyecto/{id}")
	public ResponseEntity<Proyecto> updateProyecto(@PathVariable(name = "id") String id, @RequestBody Proyecto entity) {
		
		Optional<Proyecto> entityOld = serv.getOneProyecto(id);

		if (entityOld.isPresent()) {

			return ResponseEntity.ok(serv.updateProyecto(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/proyecto/{id}")
	public ResponseEntity<Void> deleteProyecto(@PathVariable(name = "id") String id) { // Repasar los parametros
		Optional<Proyecto> entity = serv.getOneProyecto(id);
		if (entity.isPresent()) {
			serv.deleteProyecto(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
