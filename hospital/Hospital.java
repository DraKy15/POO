/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.hospital;

import com.mycompany.main.consulta.Consulta;
import com.mycompany.main.consulta.utils.Status;
import com.mycompany.main.consultorio.Consultorio;
import usuarios.medicos.Medico;
import usuarios.medicos.Paciente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import usuarios.medicos.Administrador;
import usuarios.medicos.Rol;
import usuarios.medicos.Usuario;

/**
 * Clase que representa el Hospital.
 * Gestiona pacientes, médicos, consultas y más.
 * 
 * @author ameti
 */
public class Hospital {

    // Listas de objetos dentro del hospital
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Consultorio> listaConsultorios;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Administrador> listaAdmin;

    // Validador para validar reglas específicas del hospital
    private ValidadorHospital VH;

    public Hospital() {
        this.listaPacientes = new ArrayList<>();
        this.listaMedicos = new ArrayList<>();
        this.listaConsultas = new ArrayList<>();
        this.listaConsultorios = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaAdmin = new ArrayList<>();
        this.VH = new ValidadorHospital(); // Asegúrate de tener esta clase implementada

        // Registro del primer administrador
        Administrador admin = new Administrador("123a", "Luis", "Castillo", LocalDate.of(1999, 10, 16), 44345, 1234, Rol.ADMIN, 50000.00, "LUCA991016HDF", 5);
        this.listaUsuarios.add(admin);
        this.listaAdmin.add(admin);
    }

    // Registrar un nuevo paciente
    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
        this.listaUsuarios.add(paciente); // Añadimos el paciente también como usuario
    }

    // Registrar un nuevo médico
    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
        this.listaUsuarios.add(medico); // Añadimos el médico también como usuario
    }

    // Registrar un nuevo consultorio
    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    // Registrar una consulta
    public void registrarConsulta(Consulta consulta) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaHoraConsulta = consulta.getFechaHora().format(formatter);

        // Validar disponibilidad del consultorio
        if (!VH.validarDisponibilidadEnFechaConsulta(fechaHoraConsulta, consulta.getConsultorio().getNumConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha en el consultorio especificado.");
            return;
        }

        // Validar disponibilidad del médico
        if (!VH.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico(), consulta.getId(), this.listaConsultas)) {
            System.out.println("El médico no está disponible en la fecha y hora seleccionadas.");
            return;
        }

        this.listaConsultas.add(consulta);
        System.out.println("Consulta registrada con éxito para la fecha y hora: " + consulta.getFechaHora());
    }

    // Mostrar pacientes
    public void mostrarPacientes() {
        System.out.println("\n Pacientes del Hospital \n");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    // Mostrar médicos
    public void mostrarMedicos() {
        System.out.println("\n Médicos del Hospital \n");
        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatosM());
        }
    }

    // Mostrar consultorios
    public void mostrarConsultorios() {
        System.out.println("\n Consultorios del Hospital \n");
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarConsultorios());
        }
    }

    // Generar ID único para pacientes
    public String generarIDPaciente() {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPaciente = this.listaPacientes.size() + 1;
        int numeroAleatorio = alea.nextInt(1, 100000);
        return String.format("P%d%d%d%d", anoActual, mesActual, longitudPaciente, numeroAleatorio);
    }

    // Generar ID único para médicos
    public String generarIDMedico(String ApellidoMedico) {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        String inicialesMedico = ApellidoMedico.length() >= 2 ? ApellidoMedico.substring(0, 2) : ApellidoMedico;
        int longitudMedico = this.listaMedicos.size() + 1;
        int numeroAleatorio = alea.nextInt(50, 700000);
        return String.format("M%s%d%d%d", inicialesMedico, anoActual, longitudMedico, numeroAleatorio);
    }

    // Generar ID único para consultorios
    public String generarIDConsultorio(int pisoConsultorio, int numConsultorio) {
        Random alea = new Random();
        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int longitudConsultorios = this.listaConsultorios.size() + 1;
        int numeroAleatorio = alea.nextInt(1, 500000);
        return String.format("C%s%d%d%d", longitudConsultorios, diaActual, anoActual, numeroAleatorio);
    }

    // Generar ID único para consultas
    public String generarIDConsulta() {
        Random alea = new Random();
        int diaActual = LocalDate.now().getDayOfMonth();
        int numAlea = alea.nextInt(100000 - 50) + 50;
        return String.format("C0-%d-%d", listaConsultorios.size() + 1, numAlea, diaActual);
    }

    // Mostrar información personal de un paciente
    public void verInformacionPersonalPaciente(String idPaciente) {
        Paciente paciente = obtenerPacientePorId(idPaciente);
        if (paciente != null) {
            System.out.println("\nInformación Personal del Paciente:");
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    // Mostrar información personal de un médico
    public void verInformacionPersonalMedico(String idMedico) {
        Medico medico = obtenerMedicoPorId(idMedico);
        if (medico != null) {
            System.out.println("\nInformación Personal del Médico:");
            System.out.println(medico.mostrarDatosM());
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    // Ver consultas programadas para un médico específico
    public void verConsultasMedico(String idMedico) {
        Medico medico = obtenerMedicoPorId(idMedico);
        if (medico != null) {
            boolean hayConsultas = false;
            System.out.println("\nConsultas Programadas para el Médico " + medico.getNombre() + ":");
            for (Consulta consulta : listaConsultas) {
                if (consulta.getMedico().getId().equals(idMedico)) {
                    System.out.println(consulta.mostrarInfo());
                    hayConsultas = true;
                }
            }
            if (!hayConsultas) {
                System.out.println("No hay consultas programadas para este médico.");
            }
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    // Obtener paciente por ID
    public Paciente obtenerPacientePorId(String id) {
        return listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst().orElse(null);
    }

    // Obtener médico por ID
    public Medico obtenerMedicoPorId(String id) {
        return listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst().orElse(null);
    }

    // Mostrar todas las consultas
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

    // Métodos para validar (sin implementar todavía)
    public Usuario validarInicioSesion(String usuario, String contrasena) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean validarNumeroTelefonicoPaciente(String numeroTelefonoPaciente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
