/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.consulta;

import com.mycompany.main.consulta.utils.Status;
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
    public Status status;

     public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
        this.status=status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return String.valueOf(id);
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

    public String mostrarInformacion(){
        String info = String.format("\nID: %s, fecha: %s, id paciente: %s, nombre paciente: %s, id medico: %s, piso consultorio: %s,numero onsultorio: %s",
                id,
                fechaHora,
                paciente.getId(),
                medico.getId(),
                medico.getNombre(),
                consultorio.getPiso(),
                consultorio.getNumeroConsultorio()
        );
        return info;
    }
}
