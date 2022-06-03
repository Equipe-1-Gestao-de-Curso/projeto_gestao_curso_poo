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

  public Usuarios(){
  }

  public Usuarios(Long id, String name, String email){
    this.id = id;
    this.name = name;
    this.email = email;
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
  
}
