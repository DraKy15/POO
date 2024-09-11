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

        Coche cocheI = new Coche("Toyota", "Supra", 2023);
        cocheI.mostrarinformacion();
        cocheI.calcularEdadDelCoche(2024);

        Coche cocheII = new Coche("Chevrolet", "Silverado", 2017);
        cocheII.mostrarinformacion();
        cocheII.calcularEdadDelCoche(2024);

        Coche cocheIII = new Coche("Mazda", "RX-8", 2004);
        cocheIII.mostrarinformacion();
        cocheIII.calcularEdadDelCoche(2024);

    }
}
