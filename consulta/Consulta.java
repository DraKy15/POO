/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.consulta;

import com.mycompany.main.consultorio.Consultorio;
import usuarios.medicos.Medico;
import usuarios.medicos.Paciente;
import java.time.LocalDateTime;

/**
 *
 * @author ameti
 */
public class Consulta {

    int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(String idConsulta, LocalDateTime fechaConsulta, Paciente pacienteII, Medico medicoII, Consultorio consultorioII) {

    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public String mostrarInfo() {
        String info = String.format("ID: %s, Fecha: %s, IDPaciente: %s,Nombre del Paciente: %s,IDMedico: %s, Nombre del Medico: %s, Consultorio: %s", id, fechaHora, paciente.getId(), paciente.getNombre(), medico.getId(), medico.getNombre(), consultorio.getId());

        return info;
    }

}
