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

    public boolean validarDisponibilidadEnFechaConsulta
            (LocalDateTime fechaDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {

        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().isEqual(fechaDeseada)&& numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
                return false;
            }
        }
        return true;
    }

    public boolean validarDisponibilidadMedico(LocalDateTime fechaDeseada, String idMedico,ArrayList<Consulta> listaConsultas){
        for(Consulta consulta : listaConsultas){
            if (consulta.getFechaHora().isEqual(fechaDeseada)&&consulta.getMedico().getId().equals(idMedico)) {
                return false;
            }
        }
        return true;
    }
    public boolean validarFechaCorrecta( LocalDateTime fechaDeseada
    ){
        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaDeseada.isBefore(fechaActual)) return false;
        return true;
    }
}