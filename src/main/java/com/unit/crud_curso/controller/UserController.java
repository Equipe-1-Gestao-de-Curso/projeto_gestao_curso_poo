package com.unit.crud_curso.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.crud_curso.repository.UserRepo;
import com.unit.crud_curso.model.Usuarios;
@RestController
@RequestMapping(value="/users")
public class UserController {
  
  @Autowired
  private UserRepo userRepo;
  
  @GetMapping
  public List<Usuarios> findAll(){
    return userRepo.findAll();
  }

  @PostMapping
  public Usuarios save(@RequestBody Usuarios novoUsuario){
    userRepo.save(novoUsuario);
    return novoUsuario;
  }

  @PutMapping
  public Usuarios update(@RequestBody Usuarios usuarioAtualizar){
    Usuarios usuarioBD = userRepo.findById(usuarioAtualizar.getId()).get();
    
    if(usuarioBD.getName() != usuarioAtualizar.getName() && usuarioAtualizar.getName() != null){
      usuarioBD.setName(usuarioAtualizar.getName());
    }
    if(usuarioBD.getEmail() != usuarioAtualizar.getEmail() && usuarioAtualizar.getEmail() != null){
      usuarioBD.setEmail(usuarioAtualizar.getEmail());
    }
   
   
    return userRepo.save(usuarioBD);
  }

  @DeleteMapping
  public String delete(@RequestBody Usuarios usuarioDeletar){
    userRepo.delete(usuarioDeletar);
    return "usuario deletado";
  }
  
}
