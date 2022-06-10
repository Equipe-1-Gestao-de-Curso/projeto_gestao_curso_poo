package com.unit.crud_curso.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuarios {
  private Long id;
  @NotBlank
  private String name;
  private String email;

  private String cpf;
  private String perfilAcesso;
  private String senha;

  // @OneToMany(mappedBy = "usuarios")
  // private List<QuadroAvisos> quadroAvisos;

  // public List<QuadroAvisos> getAvisos() {
  //   return quadroAvisos;
  // }

  // public void setAvisos(List<QuadroAvisos> quadroAvisos) {
  //   this.quadroAvisos = quadroAvisos;
  // }

  public Usuarios(){
  }

  public Usuarios(Long id, String name, String email, String cpf, String perfilAcesso, String senha){    
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpf = cpf;
    this.perfilAcesso = perfilAcesso;
    this.senha = senha;
  }

  @Id //Annotation
  @GeneratedValue
  public Long getId(){
    return this.id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getEmail(){
    return this.email;
  }

  public void setEmail(String email){
    this.email = email;
  }
  
  public String getCpf(){
    return this.cpf;
  }

  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  public String getPerfilAcesso(){
    return this.perfilAcesso;
  }

  public void setPerfilAcesso(String perfilAcesso){
    this.perfilAcesso = perfilAcesso;
  }

  public String getSenha(){
    return this.senha;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }
}
