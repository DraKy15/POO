/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.hospital;

import com.mycompany.main.consulta.Consulta;
import usuarios.medicos.Medico;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ameti
 */
public class ValidadorHospital {

    public boolean validarDisponibilidadEnFechaConsulta(String fechaDeseada, int numConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {

            if (consulta.getFechaHora().equals(fechaDeseada) && numConsultorio == consulta.getConsultorio().getNumConsultorio()) {
                return false;
            }
        }
        return true;
    }

    public boolean validarDisponibilidadMedico(LocalDateTime fechaDeseada, Medico medico, int IDMedico, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fechaDeseada) && consulta.getMedico().getId().equals(IDMedico)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarFechaValida(LocalDateTime fechaDeseada) {
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaDeseada.isBefore(fechaActual)) {
            return false;
        } else {
            return true;
        }
    }
}
