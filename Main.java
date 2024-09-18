/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n*** BIEVENIDO ***");
            System.out.println("1. Registrar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Mostrar categorias y productos");
            System.out.println("5. Registrar categorias");
            System.out.println("6. Mostrar categorias");
            System.out.println("7. Salir");

            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("\nSeleccionaste la opción para registrar un producto");

                    System.out.println("Ingresa el ID de la categoria: ");
                    int idC = scanner.nextInt();
                    inventario.validarIDProducto(idC);

                    System.out.println("Ingresa el nombre del producto");
                    String nombre = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("Ingresa el precio del producto");
                    double precio = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println("Ingresa la descripción del producto");
                    String descripcion = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("Ingresa la categoría del producto");
                    String categoria = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("Ingresa el stock del producto");
                    int stock = scanner.nextInt();

                    System.out.println(nombre);

                    Producto producto = new Producto("Teclado Mecanico", 750.00, 15, 1234);
                    inventario.registrarProducto(producto);

                    System.out.println("\nProducto registrado correctamente");
                    break;

                case 2:
                    System.out.println("\nSeleccionaste la opción para eliminar un producto");

                    System.out.println("Ingresa el ID del producto: ");
                    int id = scanner.nextInt();

                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    inventario.listarCategoriasConProductos();
                    return;
                case 5:
                    System.out.println("Seleccionaste la opcion para registrar una categoria");
                    System.out.println("Ingresa el nombre de la categoria: ");
                    String nombreCategoria = scanner.nextLine();

                    Categoria nuevaCategoria = new Categoria(nombreCategoria);

                    break;
                case 6:
                    inventario.listarCategorias();
                    break;

                case 7:
                    break;
            }
        }
    }
}
