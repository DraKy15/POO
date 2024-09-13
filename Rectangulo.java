/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author ameti
 */
public class Rectangulo {

    double base;
    double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }

    public int area(int base, int altura) {
        return base * altura;
    }

    public int perimetro(int base, int altura) {
        return 2 * (base + altura);
    }
}
