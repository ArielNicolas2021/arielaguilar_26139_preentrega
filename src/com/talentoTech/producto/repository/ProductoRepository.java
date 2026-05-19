package com.talentoTech.producto.repository;

import java.util.List;
import java.util.Optional;

import com.talentoTech.producto.model.Producto;

public interface ProductoRepository {
  Producto guardar(Producto producto); // Crear producto.
  Optional<Producto> buscarPorId(int id); // Mostrar producto por su ID.
  List<Producto> buscarProductos(); // Mostrar productos.
  Producto actualizar(Producto producto); // Modificar producto.
  boolean eliminarPorId(int id); // Eliminar producto.
}
