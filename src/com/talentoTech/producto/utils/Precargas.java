package com.talentoTech.producto.utils;

import java.util.ArrayList;

import com.talentoTech.producto.model.Categoria;

public class Precargas {
  public static void PrecargarCategorias(ArrayList<Categoria> categorias) {
    categorias.add(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
    categorias.add(new Categoria(2, "Periféricos", "Accesorios para computadora"));
    categorias.add(new Categoria(3, "Alimentos", "Productos alimenticios"));
    categorias.add(new Categoria(4, "Limpieza", "Artículos de limpieza del hogar"));
  }
}
