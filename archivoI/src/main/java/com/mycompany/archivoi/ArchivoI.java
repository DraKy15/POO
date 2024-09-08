package com.mycompany.archivoi;

import java.util.Scanner;

/**
 *
 *
 */
public class ArchivoI {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num1 = read.nextInt();
        System.out.println("Ingrese otro numero: ");
        int num2 = read.nextInt();

        int num3 = num1 + num2;

        System.out.println("La suma de ambos numeros es: " +num3);
    }
}
