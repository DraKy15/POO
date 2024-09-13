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

        Empleado empleado1 = new Empleado(2000.0, 500.0, 10);
        System.out.println("Salario (sueldo base): " + empleado1.calcularSalario());
        System.out.println("Salario (sueldo base + bonificación): " + empleado1.calcularSalario(500.0));
        System.out.println("Salario (sueldo base + bonificación + horas extras): " + empleado1.calcularSalario(500.0, 10));
    }
}
