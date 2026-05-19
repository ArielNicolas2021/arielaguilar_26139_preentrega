package com.talentoTech.producto.controller;

import java.util.List;

import com.talentoTech.producto.model.Producto;
import com.talentoTech.producto.service.ProductoService;

public class ProductoController {
    private final ProductoService productoService;

    // Constructor para inyección de dependencias
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    public String crearProducto(int id, String nombre, double precio) {
        try {
            Producto nuevoProducto = new Producto(id, nombre, precio);
            Producto saveProducto = productoService.crearProducto(nuevoProducto);
            return "Producto '" + saveProducto.getNombre() + "' registrado correctamente.";
        } catch (IllegalArgumentException e) {
            // Captura las validaciones que programamos en el Service
            return "Error de validación: " + e.getMessage();
        }
    }

    public String listarProductos() {
        List<Producto> lista = productoService.obtenerProductos();
        if (lista.isEmpty()) {
            return "No hay productos en el sistema";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("--- Lista de productos ---\n");
            for (Producto producto : lista) {
                sb.append(producto.toString()).append("\n");
            }
            return sb.toString().trim();
        }
    };

    public String verProducto(int id) {
        try {
            Producto producto = productoService.obtenerporId(id);
            return producto.toString();
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String editarProducto(int id, String nuevoNombre, double nuevoPrecio) {
        try {
            Producto nuevoProducto = new Producto(id, nuevoNombre, nuevoPrecio);
            productoService.modificarProductos(id, nuevoProducto);
            return "Producto modificado.";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    };

    public String eliminarProducto(int id) {
        try {
            productoService.eliminarProducto(id);
            return "Producto eliminado.";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    };
}
