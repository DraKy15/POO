/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ameti
 */
public class Categoria {

    int id;
    String nombre;
    Random aleatorio = new Random();
    public ArrayList<Producto> listaProductos = new ArrayList<Producto>(); //Lista que contiene multiples productos

    public Categoria(String nombre) {
        this.id = this.aleatorio.nextInt(1, 1001);
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void registrarProductoEnCategoria(Producto producto) {
        this.listaProductos.add(producto);
    }

    public void mostrarDatos() {
        System.out.println(nombre + id + listaProductos.get(0));
        for (Producto producto : this.listaProductos) {
        }
    }

}
