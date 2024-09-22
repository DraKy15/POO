/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.hospital;

import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.medicos.Medico;
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

    public boolean validarDisponibilidadMedico(String fechaDeseada, Medico medico, int IDMedico, ArrayList<Consulta> listaConsultas) {
        if (fechaDeseada == null || medico == null || listaConsultas == null || listaConsultas.isEmpty()) {
            return true;
        }

        for (Consulta consulta : listaConsultas) {
            if (consulta != null && consulta.getMedico() != null && consulta.getFechaHora() != null) {
                if (consulta.getFechaHora().trim().equals(fechaDeseada.trim()) && consulta.getMedico().getId() == IDMedico) {
                    return false;
                }
            }
        }
        return true;
    }
}
