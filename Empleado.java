/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author ameti
 */
public class Empleado {
   

    double sueldoBase;
    double bonificacion;
    int horasExtras;

    public Empleado(double sueldoBase, double bonificacion, int horasExtras) {
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
        this.horasExtras = horasExtras;
    }


    public double calcularSalario() {
        return sueldoBase;
    }

  
    public double calcularSalario(double bonificacion) {
        return sueldoBase + bonificacion;
    }


    public double calcularSalario(double bonificacion, int horasExtras) {
        return sueldoBase + bonificacion + (horasExtras * 20);
    }
}
