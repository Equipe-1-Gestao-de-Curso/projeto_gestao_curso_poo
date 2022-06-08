package com.unit.crud_curso.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class QuadroAvisos {
  private Long id;
  @NotBlank
  private String titulo;
  private String descricao;

  private Long autor;
  private String prioridade;
  private Date dataCriacao;

  public QuadroAvisos(){
  }

  public QuadroAvisos(Long id, String titulo, String descricao, Long autor, String prioridade, Date dataCriacao){    
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.autor = autor;
    this.prioridade = prioridade;
    this.dataCriacao = dataCriacao;
  }

  @Id //Annotation
  @GeneratedValue
  public Long getId(){
    return this.id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getTitulo(){
    return this.titulo;
  }

  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  public String getDescricao(){
    return this.descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }
  
  public Long getAutor(){
    return this.autor;
  }

  public void setAutor(Long autor){
    this.autor = autor;
  }

  public String getPrioridade(){
    return this.prioridade;
  }

  public void setPrioridade(String prioridade){
    this.prioridade = prioridade;
  }

  public Date getDataCriacao(){
    return this.dataCriacao;
  }

  public void setDataCriacao(Date dataCriacao){
    this.dataCriacao = dataCriacao;
  }
}
