package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {


	@Id
	private String id;

	private String nombre;

	private int horas;

	@ManyToMany(mappedBy  = "proyectos")
	@JsonIgnoreProperties("cusos")
	private List<Cientifico> cientificos;


	public Proyecto() {
	}


	public Proyecto(String id, String nombre, int horas, List<Cientifico> cientificos) {

		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.cientificos = cientificos;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public List<Cientifico> getCientificos() {
		return cientificos;
	}


	public void setCientificos(List<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}


}