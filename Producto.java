package com.mycompany.main;

import java.util.Scanner;

public class Producto {

    Scanner read = new Scanner(System.in);
    private String nombre;
    private Double precio;
    private int stock;
    public int idCategoria;

    public Producto(String nombre, Double precio, int stock, int idCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

// Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null) {
            System.out.println("Nombre invalido. Ingrese una opcion valida: ");
        }
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        if (precio == 0) {
            System.out.println("Precio no valido. Ingrese una opcion valida: ");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock <= 0) {
            System.out.println("Stock invalido. Ingrese una opcion valida: ");
        } else {
            this.stock = stock;
        }
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    //Fin de Getters y Setters
    public void aumentarStock(int stock) {
        System.out.println("Ingrese el numero de stock que desee aumentar: ");
        int stockMas = read.nextInt();
        if (stockMas > 0) {
            this.stock += stockMas;
            System.out.println("Stock aumentado en " + stockMas + ". Nuevo stock: " + this.stock);
        } else if (stockMas <= 0) {
            System.out.println("Ingrese una opcion valida");
        }
    }

    public void reducirStock(int stock) {
        System.out.println("Ingrese el numero de stock que desee reducir: ");
        int stockMenos = read.nextInt();
        if (stockMenos > 0 && stockMenos <= this.stock) {
            this.stock -= stockMenos;
            System.out.println("Stock reducido en " + stockMenos + ". Nuevo stock: " + this.stock);
        } else if (stockMenos > this.stock) {
            System.out.println("No es posible reducir mas del stock disponible");
        } else {
            System.out.println("Ingrese una opcion valida");
        }
    }

    public void mostrarProducto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

}
