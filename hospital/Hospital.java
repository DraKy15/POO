/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.hospital;

import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.consultorio.Consultorio;
import usuarios.medicos.Medico;
import usuarios.medicos.Paciente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public ArrayList<Paciente> numerosTelefonicosOcupados = new ArrayList<>();
    public ArrayList<Paciente> numerosTelefonicosOcupadosMed = new ArrayList<>();
    public ArrayList<Medico> RFCSMedicosOcupados = new ArrayList<>();

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String fechaHoraConsulta = consulta.getFechaHora().format(formatter);

        if (!VH.validarDisponibilidadEnFechaConsulta(fechaHoraConsulta, consulta.getConsultorio().getNumConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha en el consultorio especificado.");
            return;
        }

        if (!VH.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico(), consulta.getId(), this.listaConsultas)) {
            System.out.println("El médico no está disponible en la fecha y hora seleccionadas.");
            return;
        } else {
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

    public String generarIDConsulta() {
        Random alea = new Random();
        int diaActual = LocalDate.now().getDayOfMonth();
        int numAlea = alea.nextInt(100000 - 50) + 50;
        return String.format("C0-%d-%d", listaConsultorios.size() + 1, numAlea, diaActual);

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

    public Paciente obtenerPacientePorId(String id) {

        return listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst().orElse(null);
    }

    public Medico obtenerMedicoPorId(String id) {

        return listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst().orElse(null);
    }

    public Consultorio obtenerConsultorioPorId(String id) {

        return listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean validarFechaConsulta(LocalDateTime fechaDeseada) {
        return this.VH.validarFechaValida(fechaDeseada);

    }

    public boolean validarNumeroTelefonicoPaciente(String numeroPaciente) {

        return numerosTelefonicosOcupados.contains(numeroPaciente);
    }

    public boolean validarNumeroTelefonicoMedico(String numeroMedico) {

        return numerosTelefonicosOcupadosMed.contains(numeroMedico);
    }

    public boolean validarRFCMedicoOcupado(String RFCMedico) {

        return RFCSMedicosOcupados.contains(RFCMedico);
    }

    public void mostrarConsultas() {
        if (this.listaConsultas.isEmpty()) {
            System.out.println("\n No hay consultas registradas");
        } else {
            System.out.println("\n Lista de Consultas");
            for (Consulta consulta : this.listaConsultas) {
                consulta.mostrarInfo();
            }
        }
    }

}
