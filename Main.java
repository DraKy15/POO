/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author
 */
public class Main {

    public static void main(String[] args) {

        Rectangulo rect1 = new Rectangulo(5.0, 3.0);
        System.out.println("Área (double): " + rect1.area());
        System.out.println("Perímetro (double): " + rect1.perimetro());

        int baseInt = 5;
        int alturaInt = 3;
        Rectangulo rect2 = new Rectangulo(baseInt, alturaInt);
        System.out.println("Área (int): " + rect2.area(baseInt, alturaInt));
        System.out.println("Perímetro (int): " + rect2.perimetro(baseInt, alturaInt));
    }
}
