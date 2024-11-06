/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_5;

/**
 *
 * @author ameti
 */
public class Clase_Producto {

    String nombre;
    double precio;
    int cantidad;
    double valorTotal;

    public Clase_Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularValorTotal() {
        valorTotal = precio * cantidad;
        return valorTotal;
    }

    public String mostrarDetalles() {
        return "Producto: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + " Valor Total: " + calcularValorTotal();
    }
}
