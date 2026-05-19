package com.talentoTech.producto.utils;

import java.util.Scanner;

public class Validaciones {
  public static int leerEntero(Scanner sc, String msj) {
    while (true) {
      try {
        System.out.println(msj);
        return Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: debe ingresar un número entero válido.");
      }
    }
  }

  public static int leerEnteroNoNegativo(Scanner sc, String msj) {
    while (true) {
      int valor = leerEntero(sc, msj);

      if (valor < 0) {
        System.out.println("Error: el valor no puede ser negativo.");
        continue;
      }

      return valor;
    }
  }

  public static double leerDoubleNoNegativo(Scanner sc, String msj) {
    while (true) {
      try {
        System.out.println(msj);
        double valor = Double.parseDouble(sc.nextLine());

        if (valor < 0) {
          System.out.println("Error: el precio no puede ser negativo.");
          continue;
        }

        return valor;
      } catch (NumberFormatException e) {
        System.out.println("Error: debe ingresar un número decimal válido.");
      }
    }
  }

  public static String leerTextoNoVacio(Scanner sc, String msj) {
    while (true) {
      System.out.print(msj);
      String texto = sc.nextLine();

      if (!texto.trim().isEmpty()) {
        return texto.trim();
      }

      System.out.println("Error: el texto no puede estar vacío.");
    }
  }
}
