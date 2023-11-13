package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Cientifico;
@Repository
public interface CientificoDAO extends JpaRepository<Cientifico, String>{

}
