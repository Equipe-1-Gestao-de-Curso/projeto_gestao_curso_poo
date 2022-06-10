package com.unit.crud_curso.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.crud_curso.repository.QuadroAvisosRepo;
import com.unit.crud_curso.model.QuadroAvisos;

import com.unit.crud_curso.repository.UserRepo;
import com.unit.crud_curso.model.Usuarios;
@RestController
@RequestMapping(value="/avisos")
public class QuadroAvisosController {

  @Autowired
  private QuadroAvisosRepo quadroAvisosRepo;
  private UserRepo userRepo;
  
  // @GetMapping
  // public List<QuadroAvisos> findAll(@RequestBody Usuarios usuarioLogado){
  //   if(usuarioLogado.getPerfilAcesso() != "Adm"){
  //     return quadroAvisosRepo.findAll();

  //   }
  //   else{
  //     return ;
  //   }
  // }

  @PostMapping
  public QuadroAvisos save(@RequestBody QuadroAvisos novoQuadroAvisos){
    Usuarios userVazio = new Usuarios();
    Usuarios usuarioBD = userRepo.findById(novoQuadroAvisos.getAutor()).orElse(userVazio);
    if(usuarioBD.getPerfilAcesso() == "Coord" || usuarioBD.getPerfilAcesso() == "Prof"){
      String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
      novoQuadroAvisos.setDataCriacao(timeStamp);
      novoQuadroAvisos.setDataModificacao(timeStamp);
      quadroAvisosRepo.save(novoQuadroAvisos);
      return novoQuadroAvisos;
    }
    else{
      QuadroAvisos quadroVazio = new QuadroAvisos();
      return quadroVazio;
    }
   
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
