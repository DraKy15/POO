/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main3;

/**
 *
 * @author ameti
 */
public class EnvioNacional extends Envio {

    int distanciaKm;
    int numDias;
    double costoAdicional;

    public EnvioNacional(double peso, double costoBase, int distanciaKm) {
        super(peso, costoBase);
        this.distanciaKm = distanciaKm;

    }

    @Override
    public void calcularTiempoyCostoEntrega() {
        numDias += distanciaKm / 200.0;
        if (distanciaKm == 200) {
            numDias += 1;
            if (peso > 5) {
                costoAdicional = costoBase * 0.05;
                costoBase += costoAdicional;
            }
        }
    }

    public void mostrarDetallesEnvioNacional() {
        System.out.println("Peso validado: " + peso);
        System.out.println("Costo Total: " + costoBase);
        System.out.println("Tiempo de Entrega: " + numDias + " días");
    }
}
