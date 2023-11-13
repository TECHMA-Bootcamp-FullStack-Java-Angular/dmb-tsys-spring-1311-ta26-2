package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Proyecto;
@Repository
public interface ProyectoDAO extends JpaRepository<Proyecto, String> {

}
