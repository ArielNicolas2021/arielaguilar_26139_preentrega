package com.talentoTech.producto.model;

public class Categoria {
  private int id;
  private String nombre;
  private String desc;

  // Constructor
  public Categoria(int id, String nombre, String desc) {
    this.id = id;
    this.nombre = nombre;
    this.desc = desc;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDesc() {
    return desc;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  // Método toString
  @Override
  public String toString() {
    return "ID: " + id +
        " | Nombre: " + nombre +
        " | Descripción: " + desc;
  }
}
