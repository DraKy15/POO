/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.main3;

/**
 *
 * @author ameti
 */
public class Main3 {

    public static void main(String[] args) {
        EnvioNacional envioNacional = new EnvioNacional(6.0, 300, 600);
        envioNacional.validarPeso();
        envioNacional.calcularTiempoyCostoEntrega();
        envioNacional.mostrarDetallesEnvioNacional();
        
        System.out.println("/**************/");
        
        EnvioInternacional envioInternacional = new EnvioInternacional(6.0, 500, "España");
        envioInternacional.validarPeso();
        envioInternacional.calcularTiempoyCostoEntrega();
        envioInternacional.mostrarDetallesEnvioInternacional();
    }
}
