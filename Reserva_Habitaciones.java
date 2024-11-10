/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.reserva_habitaciones;

import java.util.Scanner;

/**
 *
 * @author ameti
 */
public class Reserva_Habitaciones {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String tipoHabitacion;
        double precioPorNoche;
        boolean disponible = true;

        do {
            System.out.print("Ingrese el tipo de habitación (Individual, Doble, Suite): ");
            tipoHabitacion = read.nextLine().trim();
            if (!tipoHabitacion.equalsIgnoreCase("Individual")
                    && !tipoHabitacion.equalsIgnoreCase("Doble")
                    && !tipoHabitacion.equalsIgnoreCase("Suite")) {
                System.out.println("Tipo de habitación inválido. Intente de nuevo.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Ingresa el precio por noche de la habitación: ");
            precioPorNoche = read.nextDouble();
            read.nextLine(); 
            if (precioPorNoche <= 0) {
                System.out.println("El precio debe ser un valor positivo. Intente de nuevo.");
            } else {
                break;
            }
        } while (true);

        read.nextLine();

        Habitacion habitacion = new Habitacion(tipoHabitacion, precioPorNoche);

        int opcion;
        do {
            System.out.println("\n/* SISTEMA DE RESERVA DE HABITACIONES */");
            System.out.println("1. Mostrar detalles de la habitación");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Liberar una habitación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = read.nextInt();

            switch (opcion) {

                case 1:
                    habitacion.mostrarDetalles();
                    break;
                case 2:
                    try {
                    validarDisponibilidad(habitacion.isDisponible());
                    System.out.print("Ingresa el número de noches: ");
                    int noches = read.nextInt();
                    validarNochesIngresadas(noches);
                    habitacion.reservar(noches);
                } catch (HabitacionNoDisponibleException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumeroDeNochesInvalidoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                case 3:
                    habitacion.liberar();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema de reservas...");
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese una opción válida.");
                    break;
            }
        } while (opcion != 4);

        read.close();
    }

    public static void validarDisponibilidad(boolean disponible) throws HabitacionNoDisponibleException {
        if (!disponible) {
            throw new HabitacionNoDisponibleException("La habitación no está disponible.");
        }
    }

    public static void validarNochesIngresadas(int noches) throws NumeroDeNochesInvalidoException {
        if (noches <= 0) {
            throw new NumeroDeNochesInvalidoException("El número de noches ingresado es inválido.");
        }
    }
}
