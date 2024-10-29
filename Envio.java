/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main3;

/**
 *
 * @author ameti
 */
public abstract class Envio {

    double peso;
    double costoBase;

    public Envio(double peso, double costoBase) {
        this.peso = peso;
        this.costoBase = costoBase;
    }

    public abstract void calcularTiempoyCostoEntrega();

    public void validarPeso() {
        if (peso <= 0) {
            System.out.println("Peso ingresado invalido");
        } else {
            System.out.println("Peso ingresado correctamente");
        }
    }

}
