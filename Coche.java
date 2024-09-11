/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author ameti
 */
public class Coche {

    String marca;
    int ano;
    String modelo;
    int añoActual;

    public Coche(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void mostrarinformacion() {

        System.out.println("Marca: " + marca + " - Año: " + ano + " - Modelo: " + modelo);
    }

    public void calcularEdadDelCoche(int añoActual) {
        int edad = añoActual - ano;
        System.out.println("La edad del coche es: " + edad + " años.");
    }
}
