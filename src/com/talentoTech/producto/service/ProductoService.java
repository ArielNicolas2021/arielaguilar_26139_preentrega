package com.talentoTech.producto.service;

import java.util.List;

import com.talentoTech.producto.model.Producto;

public interface ProductoService {
  Producto crearProducto(Producto producto);
  Producto obtenerporId(int id);
  List<Producto> obtenerProductos();
  Producto modificarProductos(int id, Producto productoActualizado);
  void eliminarProducto(int id);
}
