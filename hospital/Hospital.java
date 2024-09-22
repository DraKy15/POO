/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.hospital;

import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.consultorio.Consultorio;
import com.mycompany.main.medicos.Medico;
import com.mycompany.pacientes.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ameti
 */
public class Hospital {

    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    ValidadorHospital VH = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);

    }

    public void registrarConsulta(Consulta consulta) {

        if (!VH.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha en el consultorio especificado.");
            return;
        }

        if (!VH.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico(), consulta.getId(), this.listaConsultas)) {
            System.out.println("El médico no está disponible en la fecha y hora seleccionadas.");
            return;
        }

        this.listaConsultas.add(consulta);
        System.out.println("Consulta registrada con éxito para la fecha y hora: " + consulta.getFechaHora());
    }

    public void mostrarPacientes() {
        System.out.println("\n Pacientes del Hospital \n");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    public void mostrarMedicos() {
        System.out.println("\n Medicos del Hospital \n");
        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatosMedico());
        }
    }

    public void mostrarConsultorios() {
        System.out.println("\n Consultorios del Hospital \n");
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarConsultorios());
        }
    }

    public String generarIDPaciente() {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPaciente = this.listaPacientes.size() + 1;
        int numeroAleatorio = alea.nextInt(1, 100000);
        String id = String.format("P%d%d%d%d", anoActual, mesActual, longitudPaciente, numeroAleatorio);
        return id;
    }

    public String generarIDMedico(String ApellidoMedico) {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        String apellidoMedico = ApellidoMedico;
        String inicialesMedico = apellidoMedico.length() >= 2 ? apellidoMedico.substring(0, 2) : apellidoMedico;
        int longitudMedico = this.listaMedicos.size() + 1;
        int numeroAleatorio = alea.nextInt(50, 700000);
        String idMedico = String.format("M%s%d%d%d", inicialesMedico, anoActual, longitudMedico, numeroAleatorio);
        return idMedico;
    }

    public String generarIDConsultorio(int pisoConsultorio, int numConsultorio) {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int longitudConsultorios = this.listaConsultorios.size() + 1;
        int numeroAleatorio = alea.nextInt(1, 500000);
        String idConsultorio = String.format("C%s%d%d%d", longitudConsultorios, diaActual, anoActual, numeroAleatorio);
        return idConsultorio;
    }

    public void mostrarPacientePorId(String id) {

        for (Paciente paciente : this.listaPacientes) {
            if (paciente.getId().equals(id)) {
                System.out.println(paciente.mostrarDatos());
                return;
            }
        }
        System.out.println("Paciente no encontrado");
    }

    public void mostrarMedicoPorId(String id) {

        for (Medico medico : this.listaMedicos) {
            if (medico.getId().equals(id)) {
                System.out.println(medico.mostrarDatosMedico());
                return;
            }
        }
        System.out.println("Medico no encontrado");
    }

    public void mostrarConsultorioPorId(String id) {

        for (Consultorio consultorio : this.listaConsultorios) {
            if (consultorio.getId().equals(id)) {
                System.out.println(consultorio.mostrarConsultorios());
                return;
            }
        }
        System.out.println("Consultorio no encontrado");
    }

}
