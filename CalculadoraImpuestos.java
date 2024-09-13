/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author ameti
 */
public class CalculadoraImpuestos {

    int ingresos;
    double porcentajeImpuestos;
    double dividendos;
    double exencion;
    double Impuestos;

    public double calcularImpuestos(int ingresos) {
        return ingresos * 0.15 + ingresos;
    }

    public double calcularImpuestos(int ingresos, double porcentajeImpuestos) {
        return ingresos * (porcentajeImpuestos / 100);
    }

    public double calcularImpuestos(double porcentajeImpuestos, double dividendos, double exencion) {
        double impuestos = dividendos * (porcentajeImpuestos / 100);
        if (impuestos > exencion) {
            return impuestos - exencion;
        } else {
            return 0;
        }
    }
}
