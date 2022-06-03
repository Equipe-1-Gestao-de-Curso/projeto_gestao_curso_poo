package com.unit.crud_curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unit.crud_curso.model.Usuarios;

public interface UserRepo extends JpaRepository<Usuarios, Long>{
  
}
