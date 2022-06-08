package com.unit.crud_curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unit.crud_curso.model.QuadroAvisos;

public interface QuadroAvisosRepo extends JpaRepository<QuadroAvisos, Long>{
  public String error = "Erro";
}
