package com.talentoTech.producto;

import java.util.Scanner;

import com.talentoTech.producto.controller.ProductoController;
import com.talentoTech.producto.repository.ProductoRepository;
import com.talentoTech.producto.repository.ProductoRepositoryMemoria;
import com.talentoTech.producto.service.ProductoService;
import com.talentoTech.producto.service.ProductoServiceImpl;

public class App {
  public static void main(String[] args) {
    // Instanciamos los componentes
    ProductoRepository repository = new ProductoRepositoryMemoria();
    ProductoService service = new ProductoServiceImpl(repository);
    ProductoController controller = new ProductoController(service);

    Scanner sc = new Scanner(System.in);
    int opcion; // Acá se guarda la opción seleccionada por el usuario en el menú.

    do {
      // Menú principal.
      System.out.println("\n==========================================");
      System.out.println("   SISTEMA BÁSICO DE PRODUCTOS - ARIEL AGUILAR");
      System.out.println("==========================================");
      System.out.println("1 - Ingresar producto");
      System.out.println("2 - Listar producto");
      System.out.println("3 - Consultar un producto");
      System.out.println("4 - Modificar un producto");
      System.out.println("5 - Eliminar un producto");
      System.out.println("0 - Salir");
      System.out.println("==========================================");

      // Leemos la opción elegida
      opcion = sc.nextInt();

      switch (opcion) {
        case 1:
          System.out.println("Ingrese el ID del producto: ");
          int id = sc.nextInt();
          sc.nextLine();

          System.out.println("Ingrese el nombre del producto: ");
          String nombre = sc.nextLine();

          System.out.println("Ingrese el precio del producto");
          double precio = sc.nextDouble();

          System.out.println("==========================================");
          System.out.println(controller.crearProducto(id, nombre, precio));
          System.out.println("Presione ENTER para continuar");
          sc.nextLine();
          sc.nextLine();
          break;
        case 2:
          System.out.println("==========================================");
          System.out.println(controller.listarProductos());
          System.out.println("Presione ENTER para continuar");
          sc.nextLine();
          sc.nextLine();
          break;
        case 3:
          System.out.println("Ingrese el ID del producto a consultar");
          int consultarId = sc.nextInt();
          sc.nextLine();
          System.out.println("==========================================");
          System.out.println(controller.verProducto(consultarId));
          System.out.println("Presione ENTER para continuar");
          sc.nextLine();
          break;
        case 4:
          System.out.println("Ingrese el ID del producto a modificar: ");
          int productoModificar = sc.nextInt();
          sc.nextLine();

          System.out.println("Ingrese el nombre del producto: ");
          String nuevoNombre = sc.nextLine();

          System.out.println("Ingrese el precio del producto");
          double nuevoPrecio = sc.nextDouble();
          System.out.println("==========================================");
          System.out.println(controller.editarProducto(productoModificar, nuevoNombre, nuevoPrecio));
          System.out.println("Presione ENTER para continuar");
          sc.nextLine();
          sc.nextLine();
          break;
        case 5:
          System.out.println("Ingrese el ID del producto a eliminar: ");
          int eliminarId = sc.nextInt();

          System.out.println("==========================================");
          System.out.println(controller.eliminarProducto(eliminarId));
          System.out.println("Presione ENTER para continuar");
          sc.nextLine();
          sc.nextLine();
          break;
        default:
          sc.close();
          break;
      }

    } while (opcion != 0);
  }
}
