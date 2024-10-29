/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main3;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ameti
 */
public class EnvioInternacional extends Envio {

    int numDias;
    double costoAdicional;
    String destino;
    int tiempoEntrega = 10;
    boolean internacional;
    private List<String> destinosNacionales = Arrays.asList("Ciudad de México", "Guadalajara", "Monterrey", "Puebla");

    public EnvioInternacional(double peso, double costoBase, String internacional) {
        super(peso, costoBase);
    }

    private boolean esDestinoInternacional(String destino) {
        return !destinosNacionales.contains(destino);
    }

    @Override
    public void calcularTiempoyCostoEntrega() {
        if (peso > 10) {
            tiempoEntrega += 3;
            if (internacional) {
                costoAdicional = costoBase * 0.20;
                costoBase += costoAdicional;

            }
        }
    }

    public void mostrarDetallesEnvioInternacional() {
        System.out.println("Peso validado: " + peso);
        System.out.println("Costo Total: " + costoBase);
        System.out.println("Tiempo de Entrega: " + tiempoEntrega + " días");
    }
}
