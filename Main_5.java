/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.main_5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ameti
 */
public class Main_5 {

    public static void main(String[] args) {
        String nombreP = "";
        double precioP = 0.0;
        int cantidadP = 0;
        Scanner read = new Scanner(System.in);
        try {
            System.out.print("Ingresa el nombre del producto: ");
            nombreP = read.nextLine();
            validarString(nombreP); 
        } catch (InvalidStringNameException e) {
            System.out.println("Error: " + e.getMessage());
            return; 
        }
        try {
            System.out.print("Ingresa el precio del producto: ");
            precioP = read.nextDouble();
            if (precioP <= 0) {
                throw new ArithmeticException("El precio debe ser mayor que 0.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número para el precio.");
            return;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
         try {
            System.out.print("Ingresa la cantidad de producto: ");
            cantidadP = read.nextInt();
            if (cantidadP <= 0) {
                throw new ArithmeticException("La cantidad debe ser mayor que 0.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número entero para la cantidad.");
            return;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    Clase_Producto clase_Producto = new Clase_Producto(nombreP, precioP, cantidadP);
        System.out.println(clase_Producto.mostrarDetalles());
    }

   public static void validarString(String nombre) throws InvalidStringNameException {
        if (nombre == null || nombre.isEmpty()) {
            throw new InvalidStringNameException("El nombre no puede estar vacío.");
        }
    }
}
