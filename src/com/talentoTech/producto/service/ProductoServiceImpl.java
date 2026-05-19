package com.talentoTech.producto.service;

import java.util.List;

import com.talentoTech.producto.model.Producto;
import com.talentoTech.producto.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService {
  private final ProductoRepository productoRepository;

  public ProductoServiceImpl(ProductoRepository productoRepository) {
    this.productoRepository = productoRepository;
  }

  @Override
  public Producto crearProducto(Producto producto) {
    // Validar que el producto tenga un nombre válido
    if (producto.getNombre() == null || producto.getNombre().isBlank()) {
      throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
    }

    // Validar que el producto no exista
    if (productoRepository.buscarPorId(producto.getId()).isPresent()) {
      throw new IllegalArgumentException("Ya existe un producto con ese ID.");
    }

    // Validar precio positivo
    if (producto.getPrecio() < 0) {
      throw new IllegalArgumentException("El precio no puede ser negativo.");
    }

    return productoRepository.guardar(producto);
  }

  @Override
  public Producto obtenerporId(int id) {
    return productoRepository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
  };

  @Override
  public List<Producto> obtenerProductos() {
    return productoRepository.buscarProductos();
  };

  @Override
  public Producto modificarProductos(int id, Producto productoActualizado) {
    Producto productoExiste = obtenerporId(id);

    productoExiste.setNombre(productoActualizado.getNombre());
    productoExiste.setPrecio(productoActualizado.getPrecio());

    return productoRepository.actualizar(productoExiste);
  };

  @Override
  public void eliminarProducto(int id) {
    Producto producto = obtenerporId(id);
    productoRepository.eliminarPorId(producto.getId());
  };
}
