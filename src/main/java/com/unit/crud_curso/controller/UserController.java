package com.unit.crud_curso.controller;
import java.util.List;

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
    if(usuarioBD.getCpf() != usuarioAtualizar.getCpf() && usuarioAtualizar.getCpf() != null){
      usuarioBD.setCpf(usuarioAtualizar.getCpf());
    }
    if(usuarioBD.getPerfilAcesso() != usuarioAtualizar.getPerfilAcesso() && usuarioAtualizar.getPerfilAcesso() != null){
      usuarioBD.setPerfilAcesso(usuarioAtualizar.getPerfilAcesso());
    }
    if(usuarioBD.getSenha() != usuarioAtualizar.getSenha() && usuarioAtualizar.getSenha() != null){
      usuarioBD.setSenha(usuarioAtualizar.getSenha());
    }
   
   
    return userRepo.save(usuarioBD);
  }

  @DeleteMapping
  public String delete(@RequestBody Usuarios usuarioDeletar){
    userRepo.delete(usuarioDeletar);
    return "usuario deletado";
  }
  
}
