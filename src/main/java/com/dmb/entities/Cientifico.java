package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cientificos")
public class Cientifico {

	@Id
	private String dni;

	private String nombre_completo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "cientifico-proyecyo",
			joinColumns = @JoinColumn(name = "cientifico_id"),
			inverseJoinColumns = @JoinColumn(name = "proyecto_id")
	)
	
	@JsonIgnoreProperties("cientificos")
	private List<Proyecto> proyectos;


	public Cientifico() {
	}


	public Cientifico(String dni, String nombre_completo) {
		this.dni = dni;
		this.nombre_completo = nombre_completo;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre_completo() {
		return nombre_completo;
	}


	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}


	public List<Proyecto> getProyecyos() {
		return proyectos;
	}


	public void setProyecyos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}


}