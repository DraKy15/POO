/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reserva_habitaciones;

/**
 *
 * @author ameti
 */
public class Habitacion {

    private String tipoHabitacion;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(String tipoHabitacion, double precioPorNoche) {
        if (precioPorNoche <= 0) {
            throw new IllegalArgumentException("El precio por noche debe ser mayor que cero.");
        }
        this.tipoHabitacion = tipoHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;

    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar(int noches) {
        if (disponible) {
            disponible = false;
            double costoTotal = precioPorNoche * noches;
            System.out.println("Habitación reservada exitosamente por " + noches + " noches.");
            System.out.println("Costo total: $" + costoTotal);
        } else {
            System.out.println("La habitación no está disponible para reservar.");
        }
    }

    public void liberar() {
        if (!disponible) {
            disponible = true;
            System.out.println("Habitación liberada exitosamente.");
        } else {
            System.out.println("La habitación ya está disponible.");
        }
    }

    public void mostrarDetalles() {

        System.out.println("Tipo de Habitacion: " + tipoHabitacion);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Disponibilidad: " + (disponible ? "Disponible" : "No disponible"));
    }

}
