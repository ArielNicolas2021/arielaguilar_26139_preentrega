package com.talentoTech.producto.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.talentoTech.producto.model.Producto;

public class ProductoRepositoryMemoria implements ProductoRepository {
  // Este archivo simula ser una base de datos en memoria
  private final List<Producto> productoDB = new ArrayList<>();

  @Override
  public Producto guardar(Producto producto) {
    productoDB.add(producto);
    return producto;
  }

  @Override
  public Optional<Producto> buscarPorId(int id) {
    return productoDB.stream().filter(p -> p.getId() == id).findFirst();
  };

  @Override
  public List<Producto> buscarProductos() {
    return new ArrayList<>(productoDB); // Copiamos para proteger la lista original.
  };

  @Override
  public Producto actualizar(Producto productoActualizado) {
    buscarPorId(productoActualizado.getId()).ifPresent(p -> {
      // Actualizamos los datos
      p.setNombre(productoActualizado.getNombre());
      p.setPrecio(productoActualizado.getPrecio());
    });
    return productoActualizado;
  };

  public boolean eliminarPorId(int id) {
    return productoDB.removeIf(p -> p.getId() == id);
  };
}
