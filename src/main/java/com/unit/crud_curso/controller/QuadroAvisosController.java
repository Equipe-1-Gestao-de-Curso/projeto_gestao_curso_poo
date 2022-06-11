package com.unit.crud_curso.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.unit.crud_curso.model.QuadroAvisos;
import com.unit.crud_curso.model.Usuarios;
import com.unit.crud_curso.repository.QuadroAvisosRepo;
import com.unit.crud_curso.repository.UserRepo;

@RestController
@RequestMapping(value = "/avisos")
public class QuadroAvisosController {
  
  @Autowired
  private QuadroAvisosRepo quadroAvisosRepo;

  @Autowired
  private UserRepo userRepo;
  
  @GetMapping(value = "/{id}") List<QuadroAvisos> verQuadrosAvisos(@PathVariable Long id){
    Usuarios usuarioDB = userRepo.findById(id).get();
    String perfil = usuarioDB.getPerfilAcesso();
    if(!perfil.equals("Adm")){
      return quadroAvisosRepo.findAll();
    }
    else{
      ArrayList<QuadroAvisos> avisoVazio = new ArrayList<>();
      return avisoVazio;
    }
  }

  @PostMapping(value = "/{id}") String cadastrarQuadrosAvisos(@RequestBody QuadroAvisos entity, @PathVariable Long id){
    Usuarios usuarioDB = userRepo.findById(id).get();
    String perfil = usuarioDB.getPerfilAcesso();
    if(!perfil.equals("Adm") && !perfil.equals("Aluno")){
      Date data = new Date();
      SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      String dataAtual = formatador.format(data);
      entity.setDataCriacao(dataAtual);
      entity.setDataModificacao(dataAtual);
      quadroAvisosRepo.save(entity);
      return "QUADRO DE AVISO CRIADO!!!!";
    }
    return "VOCÊ NÃO TEM PERMISSÃO";
  
  }

  @PutMapping(value = "/{userId}={id}") String atualizarQuadroAvisos(@RequestBody QuadroAvisos entity, @PathVariable Long id, @PathVariable Long userId){
    Usuarios usuarioDB = userRepo.findById(userId).get();
    String perfil = usuarioDB.getPerfilAcesso();
    if(!perfil.equals("Adm") && !perfil.equals("Aluno")){
      QuadroAvisos quadroAvisosDB = quadroAvisosRepo.findById(id).get();
      Date data = new Date();
      SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      String dataAtual = formatador.format(data);
      quadroAvisosDB.setDataModificacao(dataAtual);

      if(quadroAvisosDB.getTitulo() != entity.getTitulo() && entity.getTitulo() != null){
        quadroAvisosDB.setTitulo(entity.getTitulo());
      }
      if(quadroAvisosDB.getPrioridade() != entity.getPrioridade() && entity.getPrioridade() != null){
        quadroAvisosDB.setPrioridade(entity.getPrioridade());
      }
      if(quadroAvisosDB.getDescricao() != entity.getDescricao() && entity.getDescricao() != null){
        quadroAvisosDB.setDescricao(entity.getDescricao());
      }
      if(quadroAvisosDB.getAutor() != entity.getAutor() && entity.getAutor() != null){
        quadroAvisosDB.setAutor(entity.getAutor());
      }
      quadroAvisosRepo.save(quadroAvisosDB);
      return "QUADRO DE AVISOS ATUALIZADO COM SUCESSO!!!";
    }
    return "VOCÊ NÃO POSSUI PERMISSÃO!!!!";

  }

  @DeleteMapping(value = "/delete/{userId}={id}")
  public String delete(@PathVariable Long id, @PathVariable Long userId){
    Usuarios usuarioDB = userRepo.findById(userId).get();
    String perfil = usuarioDB.getPerfilAcesso();
    if(!perfil.equals("Adm") && !perfil.equals("Aluno")){
      QuadroAvisos avisos = quadroAvisosRepo.findById(id).orElse(null);
      if(avisos == null){
        return "QUADRO DE AVISOS NÃO EXISTE!!!!";
      }
      else{
        quadroAvisosRepo.delete(avisos);
        return "QUADRO DE AVISOS DELETADO COM SUCESSO!!!!";
      }
    }
    return "VOCÊ NÃO TEM PERMISSÃO PARA DELETAR!!!!"; 
  }
}
