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

        CalculadoraImpuestos calcuImpuestos = new CalculadoraImpuestos();

        int ingresos = 10000;
        double resultado1 = calcuImpuestos.calcularImpuestos(ingresos);
        System.out.println("Impuestos con solo ingresos: " + resultado1);

        double porcentajeImpuestos = 20.0;
        double resultado2 = calcuImpuestos.calcularImpuestos(ingresos, porcentajeImpuestos);
        System.out.println("Impuestos con ingresos y porcentaje: " + resultado2);

        double dividendos = 5000.0;
        double exencion = 200.0;
        double resultado3 = calcuImpuestos.calcularImpuestos(porcentajeImpuestos, dividendos, exencion);
        System.out.println("Impuestos con dividendos, porcentaje y exención: " + resultado3);
    }
}
