/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.main_6;

import java.util.Scanner;

/**
 *
 * @author ameti
 */
public class Main_6 {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int opcion = 0;
        Escribir_Y_Leer_Tareas Escribir_Leer_Tareas = new Escribir_Y_Leer_Tareas();

        do {
            System.out.println("\n/* SISTEMA DE RESERVA DE HABITACIONES */");
            System.out.println("1. Escribir Tarea");
            System.out.println("2. Leer Tareas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = read.nextInt();
            read.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa la tarea: ");
                    String tarea = read.nextLine();
                    Escribir_Leer_Tareas.EscribirTareas(tarea);
                    break;
                case 2:
                    Escribir_Leer_Tareas.LeerTareas();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese una opción válida.");
                    break;
            }
        } while (opcion != 3);

        read.close();
    }
}
