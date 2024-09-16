/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.main;

public class Main {

    public static void main(String[] args) {
        Producto productoI = new Producto("Samsung S24 Ultra", 37999.00, 10);
        Producto productoII = new Producto("Monitor LG 29WQ500-B", 4279.00);

        productoI.mostrarProducto();

        productoI.aumentarStock(0);
        productoI.mostrarProducto();

        productoI.reducirStock(0);
        productoI.mostrarProducto();

        productoII.mostrarProducto();

        productoII.aumentarStock(0);
        productoII.mostrarProducto();

        productoII.reducirStock(0);
        productoII.mostrarProducto();
    }

}
