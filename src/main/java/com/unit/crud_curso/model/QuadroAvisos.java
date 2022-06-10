package com.unit.crud_curso.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;


@Entity
public class QuadroAvisos {
  private Long id;
  @NotBlank
  private String titulo;
  private String descricao;

  //@ManyToOne
  private Long autor;
  // public Usuarios getUsuarios() {
  //   return usuarios;
  // }

  // public void setUsuarios(Usuarios usuarios) {
  //   this.usuarios = usuarios;
  // }

  private String prioridade;
  private String dataCriacao;
  private String dataModificacao;

  public QuadroAvisos(){
  }

  public QuadroAvisos(Long id, String titulo, String descricao, Long autor, String prioridade, String dataCriacao, String dataModificacao){    
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    //this.usuarios = usuario;
    this.autor = autor;
    this.prioridade = prioridade;
    this.dataCriacao = dataCriacao;
    this.dataModificacao = dataModificacao;
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

  public String getDataCriacao(){
    return this.dataCriacao;
  }

  public void setDataCriacao(String dataCriacao){
    this.dataCriacao = dataCriacao;
  }

  public String getDataModificacao(){
    return this.dataModificacao;
  }

  public void setDataModificacao(String dataModificacao){
    this.dataModificacao = dataModificacao;
  }
}
